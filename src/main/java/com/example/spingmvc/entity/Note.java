package com.example.spingmvc.entity;

import lombok.Data;

@Data
public class Note {
    private long id;
    private String title;
    private String content;
}
