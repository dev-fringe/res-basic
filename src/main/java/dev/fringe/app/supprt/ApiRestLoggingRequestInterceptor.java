package dev.fringe.app.supprt;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;

/**
 * api for logging
 */
public class ApiRestLoggingRequestInterceptor implements ClientHttpRequestInterceptor {

	private static final Logger requestLog = LogManager.getLogger("request");
	private static final Logger responseLog = LogManager.getLogger("response");

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		ClientHttpResponse response = execution.execute(request, body);
		log(request, body, response);
		return response;
	}

	private void log(HttpRequest request, byte[] body, ClientHttpResponse response) throws IOException {
		if (requestLog.isInfoEnabled()) {
			System.out.println(new String(body));
			requestLog.info(request.getURI().toString() + " - " + new String(body));
		}
		if (responseLog.isInfoEnabled()) {
			System.out.println( new String(FileCopyUtils.copyToByteArray(response.getBody())));
			responseLog.info(request.getURI().toString() + " - " + new String(FileCopyUtils.copyToByteArray(response.getBody())));
		}
	}
}