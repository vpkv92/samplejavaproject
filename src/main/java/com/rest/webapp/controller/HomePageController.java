package com.rest.webapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.webapp.service.RestAPIService;
import com.rest.webapp.util.ApplicationPropertiesUtil;
import com.rest.webapp.vo.ProcessDefinition;
import com.rest.webapp.vo.TaskList;

public class HomePageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		//Map<String,String> keyVersionMap ;
		//List<Map<String,String>> keyList = new ArrayList<Map<String,String>>();
		List<ProcessDefinition> procList = new ArrayList<ProcessDefinition>();
		List<TaskList> taskList = new ArrayList<TaskList>();
		try {

			ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
			String restUrl = prop.getRestUrl();
			RestAPIService restService = new RestAPIService();
			ObjectMapper mapper = new ObjectMapper();
			String restPath="";
			String result="";
			
			restPath = prop.getProcDefList();
			result = restService.callRestAPIGet(restUrl, restPath);
			
			ProcessDefinition[] procdefdata = mapper.readValue(result, ProcessDefinition[].class);
			
 			for (ProcessDefinition procdef : procdefdata) {
 				procList.add(procdef);
			}
 			
 			restPath = prop.getTaskList();
			result = restService.callRestAPIGet(restUrl, restPath);
			TaskList[] taskdata = mapper.readValue(result, TaskList[].class);
			
 			for (TaskList task : taskdata) {
 				
 				taskList.add(task);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);

		}

		
		request.setAttribute("procList", procList);
		request.setAttribute("taskList", taskList);
		RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
		view.forward(request, response);
	}
	
}