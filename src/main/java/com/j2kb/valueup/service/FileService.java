package com.j2kb.valueup.service;


import com.j2kb.valueup.domain.Image.File;
import com.j2kb.valueup.domain.Image.FileRequestDTO;
import com.j2kb.valueup.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public Long saveFile(FileRequestDTO fileRequestDTO){
        return fileRepository.save(fileRequestDTO.toEntity()).getNo();
    }

    @Transactional
    public FileRequestDTO getFile(Long no){
        File file = fileRepository.findById(no).get();

        FileRequestDTO fileRequestDTO = FileRequestDTO.builder()
                .notice(file.getNotice())
                .file_name(file.getFile_name())
                .save_path(file.getSave_path())
                .build();
        return fileRequestDTO;
    }
}
