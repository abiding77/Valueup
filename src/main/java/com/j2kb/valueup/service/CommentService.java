package com.j2kb.valueup.service;


import com.j2kb.valueup.domain.Comment.Comment;
import com.j2kb.valueup.domain.Comment.CommentRequestDTO;
import com.j2kb.valueup.domain.Community.Community;
import com.j2kb.valueup.repository.CommentRepository;
import com.j2kb.valueup.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommunityRepository communityRepository;
    @Transactional
    public Long save(Long id, CommentRequestDTO dto){
        Community community = communityRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다." + id));
        dto.setCommunity_no(community);
        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return community.getNo();
    }

}
