package com.j2kb.valueup.service;

import com.j2kb.valueup.domain.Community.Community;
import com.j2kb.valueup.domain.Community.CommunityRequestDTO;
import com.j2kb.valueup.domain.Community.CommunityResponseDTO;
import com.j2kb.valueup.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepository communityRepository;

    // 게시글 생성
    @Transactional
    public Long save(final CommunityRequestDTO params){
        Community entity = communityRepository.save(params.toEntity());
        return entity.getNo();
    }

    // 게시글 리스트 조회
    public List<CommunityResponseDTO> findAll(){
        Sort sort = Sort.by(Sort.Direction.DESC,"no","createdDate");
        List<Community> list = communityRepository.findAll(sort);
        return list.stream().map(CommunityResponseDTO::new).collect(Collectors.toList());
    }

    public CommunityResponseDTO findById(Long no){
        Community entity = communityRepository.findById(no).orElseThrow(()->new IllegalArgumentException("검색할 해당 게시글이 없습니다. no =" + no));
        return new CommunityResponseDTO(entity);
    }

    // 게시글 수정
    @Transactional
    public Long update(final Long no, final CommunityRequestDTO params){
        Community entity = communityRepository.findById(no).orElseThrow(()->new IllegalArgumentException("수정할 해당 게시글이 없습니다. no " + no));
        entity.update(params.getName(), params.getContent(), params.getWriter(), params.getCategory());
        return no;
    }

    // 게시글 삭제
    @Transactional
    public void delete(Long no){
        Community community = communityRepository.findById(no).orElseThrow(() -> new IllegalArgumentException("삭제할 해당 게시글이 없습니다. No =" + no));
        communityRepository.delete(community);
    }
}
