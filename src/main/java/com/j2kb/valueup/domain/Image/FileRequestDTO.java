package com.j2kb.valueup.domain.Image;

import com.j2kb.valueup.domain.Notice.Notice;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileRequestDTO {
    private Notice notice;
    private String file_name;
    private String save_path;

    public File toEntity(){
        File build = File.builder()
                .notice(notice)
                .file_name(file_name)
                .save_path(save_path)
                .build();
        return build;
    }
}
