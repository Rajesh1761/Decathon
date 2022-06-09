package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.exception.OutPutGenerationException;
import com.kuehen.nagel.decathlon.exception.TimeToSecondsConversionException;
import com.kuehen.nagel.decathlon.model.AthleticPerformance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.*;

@Service
@Slf4j
public class DecathlonService {

    @Value("${decathlon.athletic.input.file}")
    String filePath;

    @Value("${decathlon.athletic.output.file}")
    String outPutFilePath;

    private final FileReaderService fileReaderService;

    private final AthleticRankService athleticRankService;

    private final GenerateOutPutFile generateOutPutFile;

    public DecathlonService(FileReaderService fileReaderService,
                            AthleticRankService athleticRankService,
                            GenerateOutPutFile generateOutPutFile) {
        this.fileReaderService = fileReaderService;
        this.athleticRankService = athleticRankService;
        this.generateOutPutFile = generateOutPutFile;
    }

    public void processAthleticsData() throws OutPutGenerationException {
        filePath = filePath != null && !filePath.isEmpty() ? filePath:FILE_NAME;
        List<String> rawFileData = fileReaderService.readFile(filePath);
        log.info(FILE_READING_COMPLETED,rawFileData.size());
        processEachLineFileData(rawFileData);
    }

    private void processEachLineFileData(List<String> rawFileData) {
        List<AthleticPerformance> athleticPerformanceList = rawFileData.stream().
                map(this::getAthleticPerformance).collect(Collectors.toList());
        generateOutPutFile.generateFile(athleticRankService.rank(athleticPerformanceList),
                outPutFilePath);
    }

    /**
     *
     *
     * @param eachLine
     * @return
     */
    private AthleticPerformance getAthleticPerformance(String eachLine) {
        String[] lineIndexes = eachLine.split(SPLITTER_SEMI_COLON);
        return AthleticPerformance.builder().name(lineIndexes[0])
                .sprint100m(Double.parseDouble(lineIndexes[1]))
                .longJump(Double.parseDouble(lineIndexes[2]))
                .shotPut(Double.parseDouble(lineIndexes[3]))
                .highJump(Double.parseDouble(lineIndexes[4]))
                .sprint400m(Double.parseDouble(lineIndexes[5]))
                .sprint110mHurdles(Double.parseDouble(lineIndexes[6]))
                .discusThrow(Double.parseDouble(lineIndexes[7]))
                .poleVault(Double.parseDouble(lineIndexes[8]))
                .javelinThrow(Double.parseDouble(lineIndexes[9]))
                .sprint1500mInSeconds(convertTimeToSeconds(lineIndexes[10]))
                .build();
    }

    private int convertTimeToSeconds(String lineIndex) {
        try {
            String[] timeSplitWithMilliSeconds = lineIndex.trim().split(SPLITTER_DOT);
            String[] timeSplitWithSeconds = timeSplitWithMilliSeconds[0].trim().split(SPLITTER_COLON);
            LocalTime secondsOfTime = LocalTime.of(0,
                    Integer.parseInt(timeSplitWithSeconds[0]),
                    Integer.parseInt(timeSplitWithSeconds[1]),
                    Integer.parseInt(timeSplitWithMilliSeconds[1]));
            return secondsOfTime.toSecondOfDay();
        } catch (Exception e) {
            log.info(String.format(EXCEPTION_TIME_CONVERSION,
                    lineIndex, e.getMessage()));
            throw new TimeToSecondsConversionException(String.format(EXCEPTION_TIME_CONVERSION,
                    lineIndex, e.getMessage()));
        }
    }
}
