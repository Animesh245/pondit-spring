package com.this_project.dto;

import com.this_project.entity.Attachment;
import com.this_project.entity.User;
import lombok.Data;

@Data
public class AttachmentDTO {

    private String name;

    private String path;

    private String type;

    private String user;

}
