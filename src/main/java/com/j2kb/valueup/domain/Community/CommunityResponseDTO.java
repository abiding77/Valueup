package com.j2kb.valueup.domain.Community;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommunityResponseDTO {

    private Long no;
    private String name;
    private String content;
    private String writer;
    private int view;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String category;

    public CommunityResponseDTO(Community entity){
        this.no = entity.getNo();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.view = entity.getView();
        this.category = entity.getCategory();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
