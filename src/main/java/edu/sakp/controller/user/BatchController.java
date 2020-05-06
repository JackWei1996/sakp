package edu.sakp.controller.user;

import edu.sakp.pojo.Batch;
import edu.sakp.pojo.Statistics;
import edu.sakp.service.BatchService;
import edu.sakp.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("UserBatchController")
@RequestMapping("/user/batch")
public class BatchController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BatchService batchService;
    @RequestMapping(value = "/getAll")
    @ResponseBody
    @Transactional
    public Object getAll(Statistics pojo) {
        List<Batch> batchs = batchService.list();
        return batchs;
    }
}
