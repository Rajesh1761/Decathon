package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.exception.TimeToSecondsConversionException;
import com.kuehen.nagel.decathlon.model.AthleticPerformance;
import com.kuehen.nagel.decathlon.model.AthleticResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.EXCEPTION_TIME_CONVERSION;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


class DecathlonServiceTest extends BaseServiceTests{

    @InjectMocks
    DecathlonService decathlonService;

    @Mock
    AthleticRankService athleticRankService;

    @Mock
    GenerateOutPutFile generateOutPutFile;

    @BeforeEach
    void setUp() {
        when(athleticRankService.rank(getAthleticPerformance())).thenReturn(getAthleticResults());
        doNothing().when(generateOutPutFile).generateFile(getAthleticResults(),"/abc.xml");
    }

    @Test
    void processAthleticsData() {
        List<String> rawFileData = Arrays.asList(JOHN_SMITH,JANE_DOE,JAAN_LEPP,FOO_BAR);
        when(fileReaderService.readFile(anyString())).thenReturn(rawFileData);
        decathlonService.processAthleticsData();
        verify(fileReaderService,times(1)).readFile(anyString());
    }
    @Test
    void errorProcessAthleticsData() {
        List<String> rawFileData = Collections.singletonList(
                "JOHN SMITH;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25:72");
        when(fileReaderService.readFile(anyString())).thenReturn(rawFileData);
        TimeToSecondsConversionException thrown = assertThrows(
                TimeToSecondsConversionException.class,
                () -> decathlonService.processAthleticsData(),
                "ERROR ON CONVERT 5:25:72 TO SECONDS. ERROR: 1"
        );
        assertTrue(thrown.getMessage().contains("ERROR ON CONVERT"));
    }
}