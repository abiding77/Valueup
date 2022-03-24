package com.j2kb.valueup.service;

import com.j2kb.valueup.domain.Image.File;
import com.j2kb.valueup.domain.Image.FileResponseDTO;
import com.j2kb.valueup.domain.Notice.Notice;
import com.j2kb.valueup.domain.Notice.NoticeRequestDTO;
import com.j2kb.valueup.domain.Notice.NoticeResponseDTO;
import com.j2kb.valueup.repository.FileRepository;
import com.j2kb.valueup.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final FileRepository fileRepository;

    // 공고 등록
    @Transactional
    public Notice save(final NoticeRequestDTO params){
        Notice entity = noticeRepository.save(params.toEntity());
        return entity;
    }

    // 공고 리스트 조회
    public List<NoticeResponseDTO> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC,"no","createdDate");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDTO::new).collect(Collectors.toList());
    }

    
    // 공고 리스트 번호로 조회
    public NoticeResponseDTO findById(final Long no){
        Notice entity = noticeRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("검색할 공고가 없습니다."));
        return new NoticeResponseDTO(entity);
    }

    @Transactional
    public Long update(final Long no, NoticeRequestDTO params){
        Notice entity = noticeRepository.findById(no).orElseThrow(()-> new IllegalArgumentException("수정할 공고가 없습니다."));
        entity.update(params.getName(), params.getContent(), params.getRecruit_period(), params.getActive_period(), params.getCompany(), params.getTarget(),
                params.getArea(), params.getWebsiteurl(), params.getCategory());
        return no;
    }

    @Transactional
    public void delete(Long no){
        Notice entity = noticeRepository.findById(no).orElseThrow(()->new IllegalArgumentException("삭제할 공고가 없습니다."));
        noticeRepository.delete(entity);
    }
}
