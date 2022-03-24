package com.j2kb.valueup.service;


import com.j2kb.valueup.domain.Image.File;
import com.j2kb.valueup.domain.Image.FileRequestDTO;
import com.j2kb.valueup.domain.Image.FileResponseDTO;
import com.j2kb.valueup.domain.Notice.Notice;
import com.j2kb.valueup.domain.Notice.NoticeResponseDTO;
import com.j2kb.valueup.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public Long saveFile(FileRequestDTO fileRequestDTO){
        return fileRepository.save(fileRequestDTO.toEntity()).getNo();
    }

    // 이미지 정보 공고 정보와 조인해서 전체 조회
    public List<FileResponseDTO> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC,"notice_no");
        List<File> list = fileRepository.findAll(sort);
        return list.stream().map(FileResponseDTO::new).collect(Collectors.toList());
    }
    public FileResponseDTO findById(final Long no){
        File entity = fileRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("검색할 파일이 없습니다."));
        return new FileResponseDTO(entity);
    }

}
