package com.example.theatherproject.entity;

import com.example.theatherproject.dto.ClassADTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "class_A_table")
public class ClassAEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private int CountA;

    @Column
    private int DisCountA;

    @Column
    private String ticketDate;

    @Column
    private String seat;


    @Column
    private Long moviePk;

    @Column
    private Long TicketPk;

    @Column
    private Long MemberPk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_Id")
    private MovieEntity movieEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_Id")
    private TicketEntity ticketEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;


    public static ClassAEntity save(ClassADTO classADTO, MovieEntity movieEntity,TicketEntity ticketEntity,MemberEntity memberEntity) {
        ClassAEntity classAEntity = new ClassAEntity();
        classAEntity.setCountA(classADTO.getCountA());
        classAEntity.setSeat(classADTO.getSeat());
        classAEntity.setTicketDate(ticketEntity.getTicketDate());
        classAEntity.setMoviePk(movieEntity.getId());
        classAEntity.setTicketPk(ticketEntity.getId());
        classAEntity.setMemberPk(memberEntity.getId());
        classAEntity.setMovieEntity(movieEntity);
        classAEntity.setTicketEntity(ticketEntity);
        classAEntity.setMemberEntity(memberEntity);
        return classAEntity;
    }
}
