package com.rest.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rest.webapp.service.RestAPIService;
import com.rest.webapp.util.ApplicationPropertiesUtil;

public class RestApiHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
		String restUrl=prop.getRestUrl();
		String restPath=prop.getProcDefList();
		RestAPIService restService = new RestAPIService();
		String result = restService.callRestAPIGet(restUrl, restPath);
		resp.setContentType("text/plain");
		resp.getWriter().write("Hello World! Maven Web Project Example.");
		resp.getWriter().write("\n\n");

		resp.getWriter().write("Output of rest is" + result);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ApplicationPropertiesUtil prop = new ApplicationPropertiesUtil();
		String restUrl=prop.getRestUrl();
		RestAPIService restService = new RestAPIService();
		String result = restService.callRestAPIPost(restUrl);
		resp.setContentType("text/plain");
		resp.getWriter().write("Hello World! Maven Web Project Example.");
		resp.getWriter().write("\n\n");

		resp.getWriter().write("Output of rest is" + result);
	}

}
