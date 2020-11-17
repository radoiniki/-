package com.code;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j {

	public static void Logger() {
		 Logger logger=LogManager.getLogger(Log4j.class);
		System.out.println("The Operator logged in");
logger.trace("This is trace message");
logger.info("This is information message");
logger.error("This is error message");
logger.warn("This is warn message");
logger.fatal("This is fatal message\n\n");
System.out.println("Completed");
	}

}
