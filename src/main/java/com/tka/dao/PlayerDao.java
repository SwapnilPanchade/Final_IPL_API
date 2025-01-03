package com.tka.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Player;

@Repository
public class PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Player save(Player player) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(player);
        return player;
    }

    public Player findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Player.class, id);
    }

    public List<Player> findAll() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Player.class);
		return criteria.list();
    }
}
