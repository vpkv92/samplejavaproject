package com.rest.webappl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleRestServlet extends HttpServlet {
	

	   private static final long serialVersionUID = 1L;
	   @Override
	   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
	         throws ServletException, IOException {
		   
		   	URL url = new URL("http://localhost:8080/engine-rest/process-definition/key/DemoCamunda/start");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			String result = null;
			String jsonbody="{}";
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(jsonbody.getBytes());
			os.flush();
			os.close();
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				result=output;
			}

			conn.disconnect();
	      resp.setContentType("text/plain");
	      resp.getWriter().write("Hello World! Maven Web Project Example.");
	      resp.getWriter().write("\n\n");
	      
	      resp.getWriter().write("Output of rest is" + result);
	   }

}
