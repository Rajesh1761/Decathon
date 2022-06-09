package com.kuehen.nagel.decathlon.controller;

import com.kuehen.nagel.decathlon.exception.OutPutGenerationException;
import com.kuehen.nagel.decathlon.service.DecathlonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.*;

@Controller
@Slf4j
public class DecathlonController {

    private final DecathlonService decathlonService;

    public DecathlonController(DecathlonService decathlonService) {
        this.decathlonService = decathlonService;
    }

    @PostConstruct
    public void processData() throws OutPutGenerationException {
        log.info(ATHLETICS_STARTED_PROCESSING);
        decathlonService.processAthleticsData();
        log.info(ATHLETICS_PROCESS_COMPLETED);
    }

}
