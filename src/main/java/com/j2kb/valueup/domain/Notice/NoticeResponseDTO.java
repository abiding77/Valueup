package com.j2kb.valueup.domain.Notice;


import com.j2kb.valueup.domain.Image.File;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.Collection;

@Getter
public class NoticeResponseDTO {
    private Long no;
    private String name;
    private String content;
    private String recruit_period;
    private String active_period;
    private String company;
    private int view;
    private String target;
    private String area;
    private String websiteurl;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private String category;
    private int heart;
    private String types;
    private int people;
//    @OneToMany(mappedBy = "notice", fetch = FetchType.EAGER)
//    @ToString.Exclude
//    private Collection<File> fileinfo;
    public NoticeResponseDTO(Notice entity) {
        this.no = entity.getNo();
        this.name = entity.getName();
        this.content = entity.getContent();
        this.recruit_period = entity.getRecruit_period();
        this.active_period = entity.getActive_period();
        this.company = entity.getCompany();
        this.view = entity.getView();
        this.target = entity.getTarget();
        this.area = entity.getArea();
        this.websiteurl = entity.getWebsiteurl();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
        this.category = entity.getCategory();
        this.heart = entity.getHeart();
        this.types = entity.getTypes();
        this.people = entity.getPeople();
    }
}
