package com.sa.example.picture.domain.service;


import com.sa.example.picture.domain.data.Category;
import com.sa.example.picture.domain.data.Picture;
import com.sa.example.picture.domain.data.PictureRepository;
import com.sa.example.picture.domain.exception.ExtensionNotSupportedException;
import com.sa.example.picture.domain.exception.NoRecordFoundException;
import com.sa.example.picture.domain.exception.RequiredInputException;
import com.sa.example.picture.domain.exception.UnknownException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@Service
@Log4j2
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;
    private static final List<String> contentTypes = Arrays.asList("image/png", "image/jpeg", "image/gif");


    public PictureServiceImpl(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }


    @Override
    public void uploadTODb(MultipartFile file, String description, Category category) throws IOException,
            ExtensionNotSupportedException, RequiredInputException, UnknownException {

        //Check required input
        if (file == null || description == null || category == null) {
            log.error("file and description and category is mandatory fields to complete transaction");
            throw new RequiredInputException();
        }
        // Check file extension
        if (!contentTypes.contains(file.getContentType())) {
            log.error("file has to be image of extension : jpg, gif, png only !!");
            throw new ExtensionNotSupportedException();
        }
        //As of file size is checked in configuration
        log.info("Start uploading picture .... with description : {} ", description);
        // uploading file in root dir images ( can be found in project folder)
        File convertFile = new File("files/" + file.getOriginalFilename());
        convertFile.createNewFile();

        int width = 0, height = 0;
        log.debug("now.. getting dimensions");
        FileInputStream fis = new FileInputStream(convertFile);
        convertFile.getAbsolutePath();
        BufferedImage image = ImageIO.read(convertFile);
        if (image != null) {
            width = image.getWidth();
            height = image.getHeight();
            log.debug("width and height are : {} , {}, ", width, height);
        } else {
            log.warn("Image couldn't be read therefore dimensions will be zero for this image");
        }
        try (FileOutputStream fout = new FileOutputStream(convertFile)) {
            fout.write(file.getBytes());
        } catch (Exception exe) {
            log.error("OPS! something happen during streaming file");
            throw new UnknownException(exe);
        }
        pictureRepository.save(new Picture(description, category,
                false, false, new Dimension(width, height), null, new Date(), convertFile));
        log.info("Picture has been uploaded successfully to database");
    }

    @Override
    public List<Picture> getAllPictures() {
        return this.pictureRepository.findAllByAccepted(true);
    }

    @Override
    public List<Picture> getAllUnProcessPictures() {
        return this.pictureRepository.findAllByProcessed(false);
    }

    @Override
    public String acceptPicture(Integer id) throws NoRecordFoundException {

        Picture picture = pictureRepository.findById(id);
        if (picture != null) {
            String url = picture.getFile().getAbsolutePath();
            picture.setPath(url);
            picture.setAccepted(true);
            picture.setProcessed(true);
            this.pictureRepository.save(picture);
            return url;
        } else {
            log.error("No record was found for picture with id : {} to accept", id);
            throw new NoRecordFoundException();
        }
    }


    @Override
    public void rejectPicture(Integer id) throws IOException, NoRecordFoundException {

        log.info("Deleting picture ... ");
        Picture picture = this.pictureRepository.findById(id);

        if (picture != null) {
            if (picture.getFile() != null) {
                Path fileToDeletePath = Paths.get(picture.getFile().getAbsolutePath());
                Files.delete(fileToDeletePath);
                picture.setAccepted(false);
                picture.setProcessed(true);
                this.pictureRepository.save(picture);
                log.info("Picture : {}  is deleted from dir ", picture.getFile().getAbsolutePath());
            } else {
                log.error("Could not find file for picture : {}", id);
            }
        } else {
            log.error("Couldn't find picture with id : {} ", id);
            throw new NoRecordFoundException();
        }
    }
}
