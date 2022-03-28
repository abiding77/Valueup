package com.j2kb.valueup.domain.Comment;

import com.j2kb.valueup.domain.Community.Community;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDTO {

    private Community community_no;
    private String content;
    private String writer;
    private LocalDateTime createdDate = LocalDateTime.now();

    public Comment toEntity(){
        return Comment.builder()
                .community_no(community_no)
                .content(content)
                .writer(writer)
                .createdDate(createdDate)
                .build();
    }
}
