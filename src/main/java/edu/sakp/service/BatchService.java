package edu.sakp.service;

import edu.sakp.pojo.Batch;

import java.util.List;

public interface BatchService {
    Object getAllByLimit(Batch pojo);

    void deleteById(Integer id);

    void add(Batch pojo);

    void update(Batch pojo);

    Batch getById(Integer id);

    List<Batch> list();
}
