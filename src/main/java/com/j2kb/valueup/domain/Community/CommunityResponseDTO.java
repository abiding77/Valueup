package com.j2kb.valueup.domain.Community;

import com.j2kb.valueup.domain.Comment.CommentResponseDTO;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    private List<CommentResponseDTO> comments;

    public CommunityResponseDTO(Community entity){
        this.no = entity.getNo();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.view = entity.getView();
        this.category = entity.getCategory();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.comments = entity.getComments().stream().map(CommentResponseDTO::new).collect(Collectors.toList());
    }
}
