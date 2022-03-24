package com.j2kb.valueup.service;

import com.j2kb.valueup.domain.Notice.Notice;
import com.j2kb.valueup.domain.Notice.NoticeResponseDTO;
import com.j2kb.valueup.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
class NoticeServiceTest {

    private final NoticeRepository noticeRepository;
    @Test
    @Transactional
    public List<NoticeResponseDTO> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC,"no","createdDate");
        List<Notice> list = noticeRepository.findAll(sort);
        return list.stream().map(NoticeResponseDTO::new).collect(Collectors.toList());
    }

}