package com.rest.webapp.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestAPIService {
	
	public String callRestAPIPost(String restUrl) throws IOException {
		String result = null;
		String jsonbody="{}";
		try {
		URL url = new URL(""+restUrl+"/process-definition/key/DemoCamunda/start");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
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
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return result;
		
	}
	
	public String callRestAPIGet(String restUrl,String restPath) throws IOException {
		String result = null;
		try {
			URL url = new URL(""+restUrl+restPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

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
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		return result;
		
	}
}
