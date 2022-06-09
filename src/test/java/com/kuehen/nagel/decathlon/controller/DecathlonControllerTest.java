package com.kuehen.nagel.decathlon.controller;

import com.kuehen.nagel.decathlon.service.DecathlonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class DecathlonControllerTest {

    @InjectMocks
    DecathlonController decathlonController;

    @Mock
    DecathlonService decathlonService;

    @Test
    void processData() {
        doNothing().when(decathlonService).processAthleticsData();
        decathlonController.processData();
        verify(decathlonService,times(1)).processAthleticsData();

    }
}