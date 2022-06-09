package com.kuehen.nagel.decathlon.utils;

import com.kuehen.nagel.decathlon.calulations.Events;

public interface DecathlonConstant {
    String EXCEPTION_READING_FILE = "EXCEPTION OCCURRED WHILE READING FILE ";
    String EXCEPTION_TIME_CONVERSION= "ERROR ON CONVERT %s TO SECONDS. ERROR: %s";
    String EXCEPTION_WHILE_GENERATING_XML_OUTPUT = "EXCEPTION OCCURRED WHILE GENERATING XML OUTPUT FILE";
    String OUTPUT_FILE_GENERATION_LOCATION ="OUTPUT FILE GENERATED SUCCESSFULLY ON LOCATION ";
    String FILE_READING_COMPLETED = "FILE READING COMPLETED NUMBERS OF LINE SUCCESSFULLY READ {} ";
    String ATHLETICS_STARTED_PROCESSING= "STARTED PROCESSING ATHLETICS DATA ";
    String ATHLETICS_PROCESS_COMPLETED= "ATHLETICS DATA PROCESSED SUCCESSFULLY ";
    String FILE_NAME = "results.csv";
    String OUTPUT_XML_FILE_NAME = "DecathlonResult.xml";
    String SPLITTER_DOT = "\\.";
    String SPLITTER_COLON = ":";
    String SPLITTER_SEMI_COLON = ";";

    //Points = INT(A(B — P)C) for track events (faster time produces a higher score)
    Events trackEvents = (performance, decathlon)-> (int)
            (decathlon.getA() * Math.pow(decathlon.getB() -
                    performance, decathlon.getC()));
    //Points = INT(A(P — B)C) for field events (greater distance or height produces a higher score)
    Events fieldEvents = (performance, decathlon)-> (int)
            (decathlon.getA() * Math.pow(performance - decathlon.getB(), decathlon.getC()));

}
