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

public class HomePageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		Map<String,String> keyVersionMap ;
		List<Map<String,String>> keyList = new ArrayList<Map<String,String>>();
		try {

			ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
			String restUrl = prop.getRestUrl();
			String restPath = prop.getProcDefList();
			RestAPIService restService = new RestAPIService();
			String result = restService.callRestAPIGet(restUrl, restPath);
			ObjectMapper mapper = new ObjectMapper();
			ProcessDefinition[] procdefdata = mapper.readValue(result, ProcessDefinition[].class);
			for (ProcessDefinition procdef : procdefdata) {
				keyVersionMap= new HashMap<String,String>();
				keyVersionMap.put("proc",procdef.getName());
				keyVersionMap.put("version",Integer.toString(procdef.getVersion()));
				keyList.add(keyVersionMap);
			}

		} catch (Exception e) {
			// e.printStackTrace();
			throw new RuntimeException(e);

		}

		message = "Running Tasks are:<br><br>";

		for (Map<String,String> kv : keyList) {
			message = message +"<B>" +kv.get("proc")+"</B>" + "(Version - "+kv.get("version") + ")<br><br>";
		}

		request.setAttribute("message", message);
		RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
		view.forward(request, response);
	}
	/*
	 * @Override public void doGet(HttpServletRequest req, HttpServletResponse resp)
	 * throws ServletException, IOException { ApplicationPropertiesUtil prop = new
	 * ApplicationPropertiesUtil(); String restUrl=prop.getRestUrl(); RestAPIService
	 * restService = new RestAPIService(); String result =
	 * restService.callRestAPIGet(restUrl); resp.setContentType("text/plain");
	 * resp.getWriter().write("Hello World! Maven Web Project Example.");
	 * resp.getWriter().write("\n\n");
	 * 
	 * resp.getWriter().write("Output of rest is" + result); }
	 * 
	 * @Override public void doPost(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil(); String
	 * restUrl=prop.getRestUrl(); RestAPIService restService = new RestAPIService();
	 * String result = restService.callRestAPIPost(restUrl);
	 * resp.setContentType("text/plain");
	 * resp.getWriter().write("Hello World! Maven Web Project Example.");
	 * resp.getWriter().write("\n\n");
	 * 
	 * resp.getWriter().write("Output of rest is" + result); }
	 */

}
