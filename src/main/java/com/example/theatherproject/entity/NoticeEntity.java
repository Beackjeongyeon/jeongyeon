package com.example.theatherproject.entity;

import com.example.theatherproject.dto.NoticeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Table(name = "notice_table")
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String noticeTitle;

    @Column
    private String noticeContents;

    @Column
    private String noticeFileName;

    @Column
    private int noticeHits;

    public static NoticeEntity save(NoticeDTO noticeDTO){
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setId(noticeDTO.getId());
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeContents(noticeDTO.getNoticeContents());
        noticeEntity.setNoticeHits(noticeDTO.getNoticeHits());
        noticeEntity.setNoticeFileName(noticeDTO.getNoticeFileName());
        return noticeEntity;

    }


}
