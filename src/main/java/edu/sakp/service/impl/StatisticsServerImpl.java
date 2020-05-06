package edu.sakp.service.impl;

import edu.sakp.mapper.StatisticsMapper;
import edu.sakp.pojo.Statistics;
import edu.sakp.pojo.StatisticsExample;
import edu.sakp.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StatisticsServerImpl implements StatisticsService {
    @Autowired
    StatisticsMapper statisticsMapper;
    @Override
    public void add(Statistics pojo) {
        pojo.setCreateTime(new Date());
        statisticsMapper.insert(pojo);
    }

    @Override
    public List<Statistics> listAll() {
        StatisticsExample example = new StatisticsExample();
        example.createCriteria().andIdGreaterThanOrEqualTo(0L);
        return statisticsMapper.selectByExample(example);
    }
}
