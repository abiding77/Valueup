package com.j2kb.valueup.domain.Notice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "notice")
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String content;
    private String recruit_period;
    private String active_period;
    private String company;
    @ColumnDefault("0")
    private int view;
    private String target;
    private String area;
    private String websiteurl;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;
    private String category;
    @ColumnDefault("0")
    private int heart;
    private String types;
    private int people;

    public void update(String name,String content, String recruit, String active, String company, String target, String area, String websiteurl, String category){
        this.name= name;
        this.content= content;
        this.recruit_period = recruit;
        this.active_period = active;
        this.company = company;
        this.target = target;
        this.area = area;
        this.websiteurl = websiteurl;
        this.category = category;
        this.modifiedDate = LocalDateTime.now();
    }
}