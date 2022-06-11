package com.this_project.entity;

import com.this_project.dto.AttachmentDTO;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "attachments")
public class Attachment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String attachmentName;

    @Column(name = "path")
    private String attachmentPath;

    @Column(name = "type")
    private String attachmentType;

//    @OneToOne(mappedBy = "attachment")
//    private User user;
//It will create a column in attachment table named status_id. We already have a jointable with status_id & attachment_id. So it's not required anymore.
//    @ManyToOne(targetEntity = Status.class)
//    private Status status;
}
