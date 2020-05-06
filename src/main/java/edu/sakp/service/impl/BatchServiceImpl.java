package edu.sakp.service.impl;

import edu.sakp.mapper.BatchMapper;
import edu.sakp.model.MMGridPageVoBean;
import edu.sakp.pojo.Batch;
import edu.sakp.pojo.BatchExample;
import edu.sakp.service.BatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class BatchServiceImpl implements BatchService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    BatchMapper batchMapper;
    @Override
    public Object getAllByLimit(Batch pojo) {
        int size = 0;

        Integer begin = (pojo.getPage() - 1) * pojo.getLimit();
        pojo.setPage(begin);

        List<Batch> rows = new ArrayList<>();
        try {
            rows = batchMapper.getAllByLimit(pojo);
            size = batchMapper.countAllByLimit(pojo);
        } catch (Exception e) {
            logger.error("根据条件查询异常", e);
        }
        MMGridPageVoBean<Batch> vo = new MMGridPageVoBean<>();
        vo.setTotal(size);
        vo.setRows(rows);

        return vo;
    }

    @Override
    public void deleteById(Integer id) {
        batchMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Batch pojo) {
        pojo.setCreateTime(new Date());
        batchMapper.insert(pojo);
    }

    @Override
    public void update(Batch pojo) {
        batchMapper.updateByPrimaryKey(pojo);
    }

    @Override
    public Batch getById(Integer id) {
        return batchMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Batch> list() {
        BatchExample example = new BatchExample();
        example.createCriteria().andIdGreaterThanOrEqualTo(0);
        return batchMapper.selectByExample(example);
    }

}
