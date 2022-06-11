package com.this_project.dao_impl;

import com.this_project.dao.AttachmentDAO;
import com.this_project.entity.Attachment;
import com.this_project.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AttachmentDAO_Impl implements AttachmentDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Long insert(Attachment attachment) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(attachment);
        }catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.flush();
        return id;
    }

    public List<Attachment> getAttachmentList(){
        Session session = sessionFactory.getCurrentSession();

        List<Attachment> attachmentList = session.createQuery("FROM Attachment", Attachment.class).list();
        session.flush();
        return attachmentList;
    }



    @Override
    public void insertBulks(List<Attachment> attachments) {
        Session session = sessionFactory.getCurrentSession();
        try {
            attachments.forEach(session::save);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }
}
