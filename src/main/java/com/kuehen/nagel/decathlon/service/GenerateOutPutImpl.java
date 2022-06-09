package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.exception.OutPutGenerationException;
import com.kuehen.nagel.decathlon.model.AthleticResult;
import com.kuehen.nagel.decathlon.model.DataForXmlFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.*;

@Service
@Slf4j
public class GenerateOutPutImpl implements GenerateOutPutFile{

    @Override
    public void generateFile(List<AthleticResult> athleticResults,
                             String outPutFile) throws OutPutGenerationException {
        DataForXmlFile xc = new DataForXmlFile();
        xc.setAthletes(athleticResults);
        File file = new File(outPutFile + OUTPUT_XML_FILE_NAME);
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(DataForXmlFile.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(xc, file);
            log.info(OUTPUT_FILE_GENERATION_LOCATION+file);
        } catch (Exception exception) {
            log.error(EXCEPTION_WHILE_GENERATING_XML_OUTPUT + exception.getMessage());
            throw new OutPutGenerationException(EXCEPTION_WHILE_GENERATING_XML_OUTPUT);
        }
    }
}
