package com.j2kb.valueup.domain.Image;

import com.j2kb.valueup.domain.Notice.Notice;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class FileResponseDTO {
    private Long no;
    private Notice notice;
    private String file_name;
    private String save_path;

    public FileResponseDTO(File entity){
        this.no = entity.getNo();
        this.notice = entity.getNotice();
        this.file_name = entity.getFile_name();
        this.save_path = entity.getSave_path();
    }
}
