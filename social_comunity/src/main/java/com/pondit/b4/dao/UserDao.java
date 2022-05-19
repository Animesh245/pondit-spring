package com.pondit.b4.dao;

import com.pondit.b4.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;
    private List<User> users = new ArrayList<>();

    public void createUser(User user) {
//        User user = new User();
        user.setId(System.currentTimeMillis());
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setLocation(user.getLocation());
        var session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<User> getAllUser(){
        String hql = "FROM User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        List<User> listUser =(List<User>) query.getResultList();
        return listUser;
    }
}
