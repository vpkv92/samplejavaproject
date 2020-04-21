package com.rest.webapp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesUtil {
	
	private final Properties properties;
	
	File configDir = new File(System.getProperty("catalina.base"), "conf"); 
	File configFile = new File(configDir, "application.properties"); 
	InputStream streamdata = new FileInputStream(configFile);


	public ApplicationPropertiesUtil() throws FileNotFoundException {
        properties = new Properties();
        try {
            properties.load(streamdata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
	
	public String getRestUrl() {
        return properties.getProperty("restapi.url");
    }
	public String getProcDefList() {
        return properties.getProperty("restapi.procdeflist");
    }

	public String getTaskList() {
		return properties.getProperty("restapi.tasklist");
	}
	
	public String getTaskExecPre() {
		return properties.getProperty("restapi.starttaskpre");
	}
	
	public String getTaskExecPost() {
		return properties.getProperty("restapi.starttaskpost");
	}
}
	
