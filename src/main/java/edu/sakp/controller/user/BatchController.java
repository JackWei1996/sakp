package edu.sakp.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("BatchController")
@RequestMapping("/batch")
public class BatchController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
}
