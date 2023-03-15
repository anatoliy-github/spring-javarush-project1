package com.javarush.dao;

import com.javarush.domain.Task;

import java.util.List;

public interface TaskDAO {

    public List<Task> getAll();
    public List<Task> getAll(int offset, int limit);
}
