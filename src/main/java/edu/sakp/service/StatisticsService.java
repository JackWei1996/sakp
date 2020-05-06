package edu.sakp.service;

import edu.sakp.pojo.Statistics;

import java.util.List;

public interface StatisticsService {
    void add(Statistics pojo);

    List<Statistics> listAll();
}
