package com.kuehen.nagel.decathlon.service;
import com.kuehen.nagel.decathlon.model.AthleticPerformance;
import com.kuehen.nagel.decathlon.model.AthleticResult;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AthleticRankService {
    List<AthleticResult> rank(List<AthleticPerformance> athletesPerformance);
}
