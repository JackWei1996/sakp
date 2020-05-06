package edu.sakp.controller.user;

import edu.sakp.pojo.Batch;
import edu.sakp.pojo.Statistics;
import edu.sakp.pojo.User;
import edu.sakp.service.BatchService;
import edu.sakp.service.StatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Controller("StatisticsController")
@RequestMapping("/statistics")
public class StatisticsController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    private BatchService batchService;

    @RequestMapping(value = "/add")
    public String addUserPage(Model model) {
        List<Batch> batchs = batchService.list();
        List<String> names = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        for (Batch b : batchs){
            names.add(b.getName());
            ids.add(b.getId());
        }
        model.addAttribute("names", names);
        model.addAttribute("ids", ids);
        model.addAttribute("batchs", batchs);
        return "collect";
    }

    @RequestMapping(value = "/doAdd")
    @ResponseBody
    @Transactional
    public String doAdd(Statistics pojo) {
        try {
            statisticsService.add(pojo);
            return "SUCCESS";
        } catch (Exception e) {
            logger.error("添加异常", e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "ERROR";
        }
    }

    @RequestMapping(value = "/info")
    public String info(Integer batchId, Model model) {
        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        List<Statistics> statisticsList = statisticsService.listAll();

        for (Statistics s:statisticsList){
            String content = s.getContent();
            content = content.replaceAll("\\.", "");
            content = content.replaceAll("，", ",");
            content = content.replaceAll("。", "");

            String[] ws = content.split(",");
            for (String key: ws){
                key = key.trim();
                if (!"".equals(key)){
                    Integer integer = map.get(key);
                    if (integer == null){
                        map.put(key, 1);
                    }else {
                        map.put(key, ++integer);
                    }
                }
            }
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new)).forEach((k, v)->{
            words.add(k);
            counts.add(v);
        });

        model.addAttribute("w", words);
        model.addAttribute("c", counts);

        return "tj/tjFeiLei";
    }
}
