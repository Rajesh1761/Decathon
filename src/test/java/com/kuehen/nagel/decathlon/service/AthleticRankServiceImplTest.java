package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.model.AthleticResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AthleticRankServiceImplTest extends BaseServiceTests{

    @Mock
    AthleticRankService athleticRankService;

    @BeforeEach
    void setUp() {
        when(athleticRankService.rank(getAthleticPerformance())).thenReturn(getAthleticResults());
    }

    @Test
    void rank() {
        List<AthleticResult> rank = athleticRankService.rank(getAthleticPerformance());
        assertNotNull(rank);
    }
}