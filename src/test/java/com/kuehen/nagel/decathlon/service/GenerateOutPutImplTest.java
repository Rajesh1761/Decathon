package com.kuehen.nagel.decathlon.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.EXCEPTION_WHILE_GENERATING_XML_OUTPUT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GenerateOutPutImplTest extends BaseServiceTests{

    @Mock
    private GenerateOutPutImpl generateOutPut;

    @Mock
    JAXBContext jaxbContext;

    @Test
    public void generateFileTest() throws JAXBException {
        jaxbContext = Mockito.mock(JAXBContext.class);
        doNothing().when(generateOutPut).generateFile(getAthleticResults(),OUTPUT_FILE_PATH);
        generateOutPut.generateFile(getAthleticResults(),OUTPUT_FILE_PATH);
        verify(generateOutPut,times(1)).generateFile(getAthleticResults(),
                OUTPUT_FILE_PATH);
    }

    @Test
    public void generateFileExceptionTest() {
        doThrow(RuntimeException.class).when(generateOutPut).generateFile(null,null);
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> generateOutPut.generateFile(null,null),
                EXCEPTION_WHILE_GENERATING_XML_OUTPUT
        );
        assertNotNull(thrown);
    }
}

