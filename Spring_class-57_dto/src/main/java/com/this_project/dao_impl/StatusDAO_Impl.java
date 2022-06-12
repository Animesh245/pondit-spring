package com.this_project.dao_impl;

import com.this_project.dao.StatusDAO;
import com.this_project.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StatusDAO_Impl implements StatusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long insert(Status status) {
        Long id = -1L;
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(status);
        }catch (Exception e){
            session.getTransaction().rollback();
        }
        session.flush();
        return id;
    }

    @Override
    public Status getById(Long id) {
        return sessionFactory.getCurrentSession().get(Status.class, id);
    }

    @Override
    public void update(Status status) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(status);
//            id = status.getId();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Status status = session.load(Status.class, id);

        session.delete(status);
        session.flush();
    }

    @Override
    public List<Status> getAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM Status", Status.class);
        List<Status> statusList = query.list();

        return statusList;
    }
}
