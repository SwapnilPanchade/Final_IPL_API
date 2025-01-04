package com.tka.dao;
import java.util.List;

import com.tka.entity.Player;
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

    public Team updateTeam(int id, Team team) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Team team1 = session.get(Team.class, id);
            team1.setName(team.getName());
            team1.setPlayers(team.getPlayers());
            session.saveOrUpdate(team1);
            session.getTransaction().commit();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return team;
    }


    public Team deleteTeam(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Team team = session.get(Team.class, id);
        session.delete(team);
        session.getTransaction().commit();
        return team;
    }

    public String addTeams(List<Team> teamList) {
        int cnt = 0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for(Team team:teamList){ session.saveOrUpdate(team);
        cnt ++;}
        session.getTransaction().commit();
        return  cnt + " teams with their provided data added successfully";
    }
}
