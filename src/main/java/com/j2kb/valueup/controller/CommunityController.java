package com.j2kb.valueup.controller;


import com.j2kb.valueup.domain.Community.CommunityRequestDTO;
import com.j2kb.valueup.domain.Community.CommunityResponseDTO;
import com.j2kb.valueup.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommunityController {
    private final CommunityService communityService;

    // 게시글 등록
    @PostMapping("/community")
    public Long save(@RequestBody final CommunityRequestDTO params){
        return communityService.save(params);
    }

    // 게시글 조회
    @GetMapping("/community")
    public List<CommunityResponseDTO> findAll(){
        return communityService.findAll();
    }

    @GetMapping("/community/{no}")
    public CommunityResponseDTO findById(@PathVariable Long no){
        return communityService.findById(no);
    }
    // 게시글 수정
    @PatchMapping("/community/{no}")
    public Long save(@PathVariable final Long no, @RequestBody final CommunityRequestDTO params){
        return communityService.update(no,params);
    }

    // 게시글 삭제
    @DeleteMapping("community/{no}")
    public Long delete(@PathVariable final Long no){
        communityService.delete(no);
        return no;
    }

}
