package com.galaxy.bakendapirest.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Pictures")
@Data
public class PictureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "room_id")
    private Integer room_id;

    @Column(name = "name")
    private String name;

    @Column(name = "technique")
    private String technique;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "year")
    private LocalDate year;

    @Column(name = "link_image")
    private String link_image;

    @Column(name = "link_qr")
    private String link_qr;

    @Column(name = "link_audio")
    private String link_audio;

    @Column(name = "pos_x")
    private Integer pos_x;

    @Column(name = "pos_y")
    private Integer pos_y;

    @Column(name = "activate")
    private Boolean activate;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_at", insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    @Column(name = "updated_by", insertable = false)
    private String updatedBy;
}
