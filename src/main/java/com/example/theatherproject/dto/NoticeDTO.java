package com.example.theatherproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeDTO {
    private Long id;
    private String noticeTitle;
    private String noticeContents;
    private String noticeFileName;
    private MultipartFile noticeFile;
    private LocalDateTime createdTime;
    private int noticeHits;


}
