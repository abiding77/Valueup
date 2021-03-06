package com.j2kb.valueup.domain.Community;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommunityRequestDTO {
    private String name;
    private String content;
    private String writer;
    private String category;
    private LocalDateTime createDate = LocalDateTime.now();

    public Community toEntity(){
        return Community.builder()
                .name(name)
                .content(content)
                .writer(writer)
                .category(category)
                .createdDate(createDate)
                .build();
    }
}
