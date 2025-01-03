package com.tka.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Team;

@Repository
public class TeamDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Team save(Team team) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(team);
        return team;
    }

    public Team findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Team.class, id);
    }

    public List<Team> findAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Team.class);
		return criteria.list();
    }
}
