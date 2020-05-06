package edu.sakp.controller.user;

import edu.sakp.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("StatisticsController")
@RequestMapping("/statistics")
public class StatisticsController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/editUserPage")
    public String editUserPage(Integer batchId, Model model) {
        List<String> words = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String content = "a,b,c,d,a,c,d,b,cd,ad,aa,cc,aab,,ccadd,,ada,,cad,,ad,,ada.,d,akakd,,";
        content = content.replaceAll(".", "");
        content = content.replaceAll("，", ",");
        content = content.replaceAll("。", "");
        for (int i=0; i<100; i++){
            String[] ws = content.split(",");
            for (String key: ws){
                Integer integer = map.get(key);
                if (integer == null){
                    map.put(key, 0);
                }else {
                    map.put(key, ++integer);
                }
            }
        }
        return "user/userEdit";
    }
}
