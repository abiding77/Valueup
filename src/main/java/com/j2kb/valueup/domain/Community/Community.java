package com.j2kb.valueup.domain.Community;

//import com.j2kb.valueup.domain.Comment.Comment;
import com.j2kb.valueup.domain.Comment.Comment;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    private String name;
    private String content;
    private String writer;
    @ColumnDefault("0")
    private int view;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;
    private String category;
    @OneToMany(mappedBy = "community_no", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public void update(String name, String content, String writer, String category){
        this.name = name;
        this.content = content;
        this.writer = writer;
        this.category = category;
        this.modifiedDate = LocalDateTime.now();
    }

}
