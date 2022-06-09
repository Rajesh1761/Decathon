package com.kuehen.nagel.decathlon.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.EXCEPTION_READING_FILE;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileReaderServiceImplTest extends BaseServiceTests{

    @Autowired
    FileReaderService fileReaderService;

    @Test
    void readFile() {
        List<String> stringList =fileReaderService.readFile(INPUT_FILE_PATH);
        assertNotNull(stringList);
    }
    @Test
    void fileReadException() {
        Exception thrown = assertThrows(
                Exception.class,
                () -> fileReaderService.readFile(INVALID_INPUT_FILE_PATH),
                EXCEPTION_READING_FILE
        );
        assertTrue(thrown.getMessage().contains(EXCEPTION_READING_FILE));

    }
}