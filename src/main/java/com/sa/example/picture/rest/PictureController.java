package com.sa.example.picture.rest;

import com.sa.example.picture.domain.exception.ExtensionNotSupportedException;
import com.sa.example.picture.domain.exception.NoRecordFoundException;
import com.sa.example.picture.domain.exception.RequiredInputException;
import com.sa.example.picture.domain.exception.UnknownException;
import com.sa.example.picture.domain.service.PictureService;
import com.sa.example.picture.rest.dto.PictureResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@RequestMapping("/pic")
public class PictureController {
    private PictureService pictureService;

    @Autowired
    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }
//    @RequestMapping(path = "/accepted", method = RequestMethod.GET)
//    @ApiOperation(value = "show all accepted picture .. ", response = PictureResponse.class)
//    public ResponseEntity<List<PictureResponse>> showAllPictures() {
//        log.info("Rest ... Showing all accepted pictures ...");
//        return new ResponseEntity<>(this.pictureService.getAllPictures().stream().map(picture ->
//                new PictureResponse(picture.getId(),picture.getDescription(),picture.getCategory().name(),picture.getDimension().toString(),
//                        picture.getPath(),picture.getCreatedOn().toString())).collect(Collectors.toList()), HttpStatus.OK);
//    }

    @RequestMapping(path = "/showun", method = RequestMethod.GET)
    @ApiOperation(value = "show all unprocessed picture .. ", response = PictureResponse.class)
    public ResponseEntity<List<PictureResponse>> showAllUnprocessedPictures() {
        log.info("Rest.. Showing unprocessed - Pending picture...");
        return new ResponseEntity<>(this.pictureService.getAllUnProcessPictures().stream().map(picture ->
                new PictureResponse(picture.getId(),picture.getDescription(),picture.getCategory().name(),picture.getDimension().toString(),
                        picture.getPath(),picture.getCreatedOn().toString())).collect(Collectors.toList()), HttpStatus.OK);    }

    @PostMapping(path = "/accept/id/{id}")
    @ApiOperation(value = "accept picture by id ")
    public ResponseEntity<List<PictureResponse>> acceptPicture(@PathVariable("id") Integer id) throws NoRecordFoundException {
        log.info("accepting picture ... ");
        this.pictureService.acceptPicture(id);
        return new ResponseEntity<>(this.pictureService.getAllUnProcessPictures().stream().map(picture ->
                new PictureResponse(picture.getId(),picture.getDescription(),picture.getCategory().name(),picture.getDimension().toString(),
                        picture.getPath(),picture.getCreatedOn().toString())).collect(Collectors.toList()), HttpStatus.OK);
    }
    @PostMapping(path = "/reject/id/{id}")
    @ApiOperation(value = "rejecting picture by id ")
    public ResponseEntity<List<PictureResponse>> deletePicture(@PathVariable("id") Integer id) throws IOException, NoRecordFoundException {
        log.info("Rest: .. reject picture");
        this.pictureService.rejectPicture(id);
        return new ResponseEntity<>(this.pictureService.getAllUnProcessPictures().stream().map(picture ->
                new PictureResponse(picture.getId(),picture.getDescription(),picture.getCategory().name(),picture.getDimension().toString(),
                        picture.getPath(),picture.getCreatedOn().toString())).collect(Collectors.toList()), HttpStatus.OK);
    }
}
