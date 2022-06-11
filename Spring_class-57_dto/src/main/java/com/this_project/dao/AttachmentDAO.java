package com.this_project.dao;

import com.this_project.entity.Attachment;
import com.this_project.entity.User;

import java.util.List;

public interface AttachmentDAO {
    Long insert(Attachment attachment);

    List<Attachment> getAttachmentList();

    void insertBulks(List<Attachment> attachments);
}
