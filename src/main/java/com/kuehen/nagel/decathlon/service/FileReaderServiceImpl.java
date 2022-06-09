package com.kuehen.nagel.decathlon.service;

import com.kuehen.nagel.decathlon.exception.FileReadException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static com.kuehen.nagel.decathlon.utils.DecathlonConstant.EXCEPTION_READING_FILE;

@Service
@Slf4j
public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFile(String filePath){
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream
                    .filter(this::nonBlank)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.info(EXCEPTION_READING_FILE + e.getMessage());
            throw new FileReadException(EXCEPTION_READING_FILE);
        }
    }
    private boolean nonBlank(String line) {
        return line != null && ! line.isEmpty();
    }
}
