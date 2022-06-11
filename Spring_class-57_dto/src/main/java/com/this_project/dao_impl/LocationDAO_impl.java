package com.this_project.dao_impl;

import com.this_project.dao.LocationDAO;
import com.this_project.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LocationDAO_impl implements LocationDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveLocation(Location location){
        Session session = sessionFactory.getCurrentSession();;

        try{
            session.save(location);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public void updateLocation(Location location){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(location);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public void deleteLocation(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try{
            session.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public List<Location> getLocationList(){
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Location";
        List<Location> locationList = session.createQuery(hql, Location.class).list();
        session.flush();
        return locationList;
    }

    @Override
    public Location getLocationById(Long id) {
        Session session = sessionFactory.getCurrentSession();

        Location location = null;
        try {
            location = session.get(Location.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return location;
    }

    @Override
    public Location getLocationByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        Location location = null;

        try {
            String hql = "FROM Location WHERE locationName=: name";
            Query query = session.createQuery(hql, Location.class).setParameter("name", name);
            location = (Location) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return location;
    }


}
