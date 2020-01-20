package com.sa.example.picture.rest.dto;

import lombok.Value;

import java.awt.*;
import java.util.Date;

@Value
public class PictureResponse {

    private Integer id;
    private String description;
    private String category;
    private String dimension;
    private String path;
    private String createdOn;}
