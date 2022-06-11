package com.this_project.dto;
import com.this_project.entity.Status;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class StatusDTO {

    String title;

    String description;

    String privacy;

//    LocalDateTime createdDateTime;
//
//    Boolean isDeleted;

    String location;

    String user;

    String attachmentPath;
}
