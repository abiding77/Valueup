package com.j2kb.valueup.domain.Comment;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class CommentResponseDTO {
    private Long no;
//    private Community community_no;
    private String content;
    private String writer;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updated_date;
    private int likes;

    public CommentResponseDTO(Comment entity){
        this.no = entity.getNo();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.createdDate = entity.getCreatedDate();
        this.updated_date = entity.getCreatedDate();
        this.likes = entity.getLikes();
    }
}
