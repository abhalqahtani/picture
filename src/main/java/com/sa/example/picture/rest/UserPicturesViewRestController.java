package com.sa.example.picture.rest;

import com.sa.example.picture.domain.data.Category;
import com.sa.example.picture.domain.exception.ExtensionNotSupportedException;
import com.sa.example.picture.domain.exception.RequiredInputException;
import com.sa.example.picture.domain.exception.UnknownException;
import com.sa.example.picture.domain.service.PictureService;
import com.sa.example.picture.rest.dto.PictureDto;
import com.sa.example.picture.rest.dto.PictureResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/picture")
@Log4j2
public class UserPicturesViewRestController {
    private PictureService pictureService;

    @Autowired
    public UserPicturesViewRestController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @RequestMapping(value = "/upload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "upload picture ")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("description") String description,
                                             @RequestParam("category") String category) throws ExtensionNotSupportedException,
            RequiredInputException, UnknownException, IOException {
        log.info("Rest: uploading pic ... ");
        this.pictureService.uploadTODb(file,description, Category.valueOf(category));
        return new ResponseEntity<String>("Uploaded .. pending", HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/show", method = RequestMethod.GET)
    @ApiOperation(value = "show all accepted picture .. ", response = PictureDto.class)
    public ResponseEntity<List<PictureDto>> showAllPictures() {
        log.info("Rest ... Showing all accepted pictures ...");
        return new ResponseEntity<>(this.pictureService.getAllPictures().stream().map(picture ->
                new PictureDto(picture.getDescription(),picture.getCategory().name(),picture.getPath())).collect(Collectors.toList()), HttpStatus.OK);
    }

}
