package com.j2kb.valueup.controller;


import com.j2kb.valueup.domain.Comment.CommentRequestDTO;
import com.j2kb.valueup.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/community/{no}/comment")
    public ResponseEntity save(@PathVariable Long no, @RequestBody CommentRequestDTO dto){
        return ResponseEntity.ok(commentService.save(no,dto));
    }
}
