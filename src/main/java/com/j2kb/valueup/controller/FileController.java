package com.j2kb.valueup.controller;


import com.j2kb.valueup.domain.Image.FileResponseDTO;
import com.j2kb.valueup.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/file")
    public List<FileResponseDTO> findAll() {
        return fileService.findAll();
    }

    @GetMapping("/file/{no}")
    public FileResponseDTO findById(@PathVariable Long no){ return fileService.findById(no);}
}
