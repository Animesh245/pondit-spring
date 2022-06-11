package com.this_project.dao_impl;

import com.this_project.dao.UserDAO;
import com.this_project.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO_impl implements UserDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long saveUser(User user){
        Session session = sessionFactory.getCurrentSession();;
        Long id = 1L;
        try{
            id = (Long) session.save(user);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return id;
    }
    @Override
    public void updateUser(User user){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(user); /*It creates a new user with updated attributes */

        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        session.delete(user);
        session.flush();
    }
    @Override
    public List<User> getUserList(){
        Session session = sessionFactory.getCurrentSession();

        List<User> userList = session.createQuery("FROM User", User.class).list();
        session.flush();
        return userList;
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, id);
        session.flush();
        return user;
    }
}
