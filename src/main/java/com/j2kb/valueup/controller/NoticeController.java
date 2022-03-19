package com.j2kb.valueup.controller;


import com.j2kb.valueup.MD5Generator;
import com.j2kb.valueup.domain.Image.FileRequestDTO;
import com.j2kb.valueup.domain.Notice.Notice;
import com.j2kb.valueup.domain.Notice.NoticeRequestDTO;
import com.j2kb.valueup.domain.Notice.NoticeResponseDTO;
import com.j2kb.valueup.service.FileService;
import com.j2kb.valueup.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoticeController {
    private final NoticeService noticeService;
    private final FileService fileService;

    // 공고 등록
    @PostMapping("/notice")
    public String save(@RequestParam(value="file", required = false)List<MultipartFile> files, final NoticeRequestDTO params){

        try {
            Notice notice = noticeService.save(params);

            for(MultipartFile multipartFile : files){
                String filename = multipartFile.getOriginalFilename();
                /* 실행되는 위치의 'files' 폴더에 파일이 저장됩니다. */
                String savePath = System.getProperty("user.dir") + "\\files";
                /* 파일이 저장되는 폴더가 없으면 폴더를 생성합니다. */
                if (!new File(savePath).exists()) {
                    try{
                        new File(savePath).mkdir();
                    }
                    catch(Exception e){
                        e.getStackTrace();
                    }
                }
                String filePath = savePath + "\\" + filename;
                multipartFile.transferTo(new File(filePath));

                FileRequestDTO fileDto = new FileRequestDTO();
                fileDto.setNotice(notice);
                fileDto.setFile_name(filename);
                fileDto.setSave_path(filePath);

                fileService.saveFile(fileDto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    // 공고 조회
    @GetMapping("notice")
    public List<NoticeResponseDTO> findAll(){
        return noticeService.findAll();
    }

    @GetMapping("notice/{no}")
    public NoticeResponseDTO findById(@PathVariable Long no){
        return noticeService.findById(no);
    }

    // 공고 수정
    @PatchMapping("notice/{no}")
    public Long save(@PathVariable final Long no, @RequestBody final NoticeRequestDTO params){
        return noticeService.update(no,params);
    }

    @DeleteMapping("notice/{no}")
    public Long delete(@PathVariable final Long no){
        noticeService.delete(no);
        return no;
    }
}
