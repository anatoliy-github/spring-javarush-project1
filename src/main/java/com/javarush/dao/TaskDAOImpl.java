package com.javarush.dao;

import com.javarush.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    private final SessionFactory sessionFactory;
    public TaskDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Task> getAll() {
        List<Task> allTasks = getSession().createQuery("from Task", Task.class)
                .getResultList();
        return allTasks;
    }

    @Override
    @Transactional
    public List<Task> getAll(int offset, int limit) {
        Query<Task> query = getSession().createQuery("from Task", Task.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }


    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
