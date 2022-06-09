package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.model.AthleticPerformance;
import com.kuehen.nagel.decathlon.model.AthleticResult;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AthleticRankServiceImpl implements AthleticRankService{
    private Map<Integer, Integer> mapScoreOrder;
    @Override
    public List<AthleticResult> rank(List<AthleticPerformance> athletesPerformance) {
        mapScoreOrder = new HashMap<>();
        athletesPerformance.sort(Comparator.comparing(AthleticPerformance::getScore).reversed());
        return athletesPerformance.stream().map(this::mapResult).collect(Collectors.toList());
    }
    private AthleticResult mapResult(AthleticPerformance athletePerformance) {
        int decathlonValue = athletePerformance.getScore();
        if (! mapScoreOrder.containsKey(decathlonValue)) {
            mapScoreOrder.put(decathlonValue, mapScoreOrder.size() + 1);
        }
        return new AthleticResult(athletePerformance.getName(), decathlonValue, mapScoreOrder.get(decathlonValue));
    }
}
