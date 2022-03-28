package com.j2kb.valueup.domain.Comment;


import com.j2kb.valueup.domain.Community.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @ManyToOne
    @JoinColumn(name = "community_no")
    private Community community_no;
    private String content;
    private String writer;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime updated_date;
    @ColumnDefault("0")
    private int likes;
}
