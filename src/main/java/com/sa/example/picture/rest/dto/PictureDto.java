package com.sa.example.picture.rest.dto;

import lombok.Value;

@Value
public class PictureDto {
    private String description;
    private String category;
    private String url;
}
