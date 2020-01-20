package com.sa.example.picture.domain.service;

import com.sa.example.picture.domain.data.Category;
import com.sa.example.picture.domain.data.Picture;
import com.sa.example.picture.domain.exception.ExtensionNotSupportedException;
import com.sa.example.picture.domain.exception.NoRecordFoundException;
import com.sa.example.picture.domain.exception.RequiredInputException;
import com.sa.example.picture.domain.exception.UnknownException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PictureService {

    void uploadTODb(MultipartFile file, String description, Category category)
            throws IOException, ExtensionNotSupportedException, RequiredInputException, UnknownException;

    List<Picture> getAllPictures();

    List<Picture> getAllUnProcessPictures();

    String  acceptPicture(Integer id) throws NoRecordFoundException;

    void rejectPicture(Integer id) throws IOException, NoRecordFoundException;
}
