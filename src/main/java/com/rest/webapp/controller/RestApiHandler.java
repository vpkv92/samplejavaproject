package com.rest.webapp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.webapp.dao.ProcessDetailsDao;
import com.rest.webapp.service.RestAPIService;
import com.rest.webapp.util.ApplicationPropertiesUtil;
import com.rest.webapp.vo.CustId;
import com.rest.webapp.vo.JsonMaker;
import com.rest.webapp.vo.Msisdn;
import com.rest.webapp.vo.Protype;
import com.rest.webapp.vo.Variables;

public class RestApiHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
			String restUrl = prop.getRestUrl();
			String restPath = prop.getProcDefList();
			RestAPIService restService = new RestAPIService();
			String result = restService.callRestAPIGet(restUrl, restPath);
			resp.setContentType("text/plain");
			resp.getWriter().write("Hello World! Maven Web Project Example.");
			resp.getWriter().write("\n\n");

			resp.getWriter().write("Output of rest is" + result);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
			Map<String, String> jsonMap = new HashMap<String, String>();
			ProcessDetailsDao procDao = new ProcessDetailsDao();
			Map<String, String> procDaoInsMap = new HashMap<String, String>();
			boolean checkExistMSISDNAssgned = procDao.verifyMsisdn(req.getParameter("msisdn"));
			
			
				if(!checkExistMSISDNAssgned) {
				String restUrl = prop.getRestUrl();
				String restPathPre = prop.getTaskExecPre();
				String restPathPost = prop.getTaskExecPost();
				String restCallStartTaskKey = (String) req.getParameter("task");
	
				ObjectMapper mapper = new ObjectMapper();
				RestAPIService restService = new RestAPIService();
	
				JsonMaker jmk = new JsonMaker();
	
				CustId custId = new CustId();
				Msisdn nmbr = new Msisdn();
				Protype proType = new Protype();
				Variables varb = new Variables();
	
				custId.setValue(req.getParameter("custId"));
				nmbr.setValue(req.getParameter("msisdn"));
				proType.setValue(req.getParameter("protype"));
	
				varb.setCustId(custId);
				varb.setMsisdn(nmbr);
				varb.setProtype(proType);
	
				jmk.setVariables(varb);
	
				String jsonData = mapper.writeValueAsString(jmk);
	
				System.out.println("JSON data is" + jsonData);
	
				String restPath = restPathPre + restCallStartTaskKey + restPathPost;
				String result = restService.callRestAPIPost(restUrl, restPath, jsonData);
	
				jsonMap = mapper.readValue(result, Map.class);
				req.setAttribute("message", "Task# <B>" + jsonMap.get("id") + "</B> Started for Process Definition Key: <B>"
						+ restCallStartTaskKey + "</B> Successfully");
				System.out.println("Task#" + jsonMap.get("id") + " Started for Process Definition Key:"
						+ restCallStartTaskKey + "Successfully");
	
				
	
				procDaoInsMap.put("custId", req.getParameter("custId"));
				procDaoInsMap.put("msisdn", req.getParameter("msisdn"));
				procDaoInsMap.put("cmreqid", jsonMap.get("id"));
				procDaoInsMap.put("cmstatus", "Process Started in Camunda");
				
				}
			else {
				
				procDaoInsMap.put("custId", req.getParameter("custId"));
				procDaoInsMap.put("msisdn", req.getParameter("msisdn"));
				procDaoInsMap.put("cmreqid", null);
				procDaoInsMap.put("cmstatus", "Failed - MSISDN Already in Use");
				req.setAttribute("message", "Request Failed - "+req.getParameter("msisdn")+" is already assigned");
				System.out.println("Request Failed - "+req.getParameter("msisdn")+" is already assigned");
			}
			
			
			procDao.insertProcessStatus(procDaoInsMap);
			RequestDispatcher view = req.getRequestDispatcher("result.jsp");
			view.forward(req, resp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
