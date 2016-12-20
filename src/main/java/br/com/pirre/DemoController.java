package br.com.pirre;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	//Code for demonstration only, ***Kids, don't try this at home*** :)
	@RequestMapping("/status")
	public String status() throws Exception{
		StringBuilder result = new StringBuilder();
		URL url = new URL("http://169.254.169.254/latest/meta-data/instance-id");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		rd.close();

		return new Date().toString() + " Glauber ID do servidor: " + result.toString();

	}


}
