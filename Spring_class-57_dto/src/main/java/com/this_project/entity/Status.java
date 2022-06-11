package com.this_project.entity;

import com.this_project.dto.StatusDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "status")
public class Status  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String statusTitle;

    @Column(name = "description")
    private String statusDescription;

    @Column(name = "privacy")
    private String statusPrivacy;

    @Column(name = "createdDateTime")
    private LocalDateTime createdDateTime;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY , orphanRemoval = true)
    @JoinTable(name = "status_attachments",
            joinColumns = {@JoinColumn(name = "status_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "attachment_id", referencedColumnName = "id")}
    )
    private List<Attachment> statusAttachmentList /*= new ArrayList<>()*/;
}

