package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.exception.OutPutGenerationException;
import com.kuehen.nagel.decathlon.model.AthleticResult;

import java.util.List;

public interface GenerateOutPutFile {
    void generateFile(List<AthleticResult> athleticResults, String outPutFile) throws OutPutGenerationException;
}
