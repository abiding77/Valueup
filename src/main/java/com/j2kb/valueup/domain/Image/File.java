package com.j2kb.valueup.domain.Image;


import com.j2kb.valueup.domain.Notice.Notice;
import lombok.*;

import javax.persistence.*;

@Entity(name = "noticeimage")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="notice_no")
    @ToString.Exclude
    private Notice notice;
    private String file_name;
    private String save_path;
}
