package com.j2kb.valueup.domain.Notice;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeRequestDTO {
    private String name;
    private String content;
    private String recruit_period;
    private String active_period;
    private String company;
    private String target;
    private String area;
    private String websiteurl;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;
    private String category;

    public Notice toEntity(){
        return Notice.builder()
                .name(name)
                .content(content)
                .recruit_period(recruit_period)
                .active_period(active_period)
                .company(company)
                .target(target)
                .area(area)
                .websiteurl(websiteurl)
                .createdDate(createdDate)
                .category(category)
                .build();
    }
}
