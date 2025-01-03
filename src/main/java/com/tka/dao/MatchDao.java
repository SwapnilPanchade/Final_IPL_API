package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Matches;

@Repository
public class MatchDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Matches save(Matches matches) {
		Session session = sessionFactory.openSession();
		session.save(matches);
		return matches;
	}

	public Matches findById(Long id) {
		Session session = sessionFactory.openSession();
		return session.get(Matches.class, id);
	}

	public List<Matches> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		return criteria.list();
	}
}
