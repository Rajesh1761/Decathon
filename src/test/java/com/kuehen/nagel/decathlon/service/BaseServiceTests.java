package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.model.AthleticPerformance;
import com.kuehen.nagel.decathlon.model.AthleticResult;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BaseServiceTests {

    static String JOHN_SMITH = "JOHN SMITH;12.61;5.00;9.22;1.50;60.39;16.43;21.60;2.60;35.81;5:25.72";
    static String JANE_DOE = "JANE DOE;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6:50.76";
    static String JAAN_LEPP = "JAAN LEPP;13.75;4.84;10.12;1.50;68.44;19.18;30.85;2.80;33.88;6:22.75";
    static String FOO_BAR =  "FOO BAR;13.43;4.35;8.64;1.50;66.06;19.05;24.89;2.20;33.48;6:51.01";
    static String OUTPUT_FILE_PATH = "src/test/resources/";
    static String INPUT_FILE_PATH = "src/test/resources/results.csv";
    static String INVALID_INPUT_FILE_PATH = "src/test/resources/results1.csv";

    @Mock
    FileReaderService fileReaderService;
    public List<AthleticPerformance> getAthleticPerformance(){
        AthleticPerformance johnSmith = AthleticPerformance.builder().name("JOHN SMITH")
                .sprint100m(12.61).longJump(5.0).shotPut(9.22)
                .highJump(1.5).sprint400m(60.30).sprint110mHurdles(16.43).discusThrow(21.6)
                .poleVault(2.6).javelinThrow(35.81).sprint1500mInSeconds(325).build();
        AthleticPerformance janeDoe = AthleticPerformance.builder().name("JANE DOE")
                .sprint100m(13.04).longJump(4.53).shotPut(7.79)
                .highJump(1.55).sprint400m(64.72).sprint110mHurdles(18.74).discusThrow(24.2)
                .poleVault(2.4).javelinThrow(28.2).sprint1500mInSeconds(410).build();
        return Arrays.asList(johnSmith,janeDoe);
    }
    public List<AthleticResult> getAthleticResults(){
        AthleticResult john_smith= AthleticResult.builder().name("JOHN SMITH").score(3168).ranking(1).build();
        AthleticResult jaan_lepp= AthleticResult.builder().name("JAAN LEPP").score(2446).ranking(3).build();
        return Arrays.asList(john_smith,jaan_lepp);
    }
}
