package dev.fringe.app.supprt;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.FileCopyUtils;

/**
 * api for logging
 */
public class ApiRestLoggingRequestInterceptor implements ClientHttpRequestInterceptor {


	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		ClientHttpResponse response = execution.execute(request, body);
		log(request, body, response);
		return response;
	}

	private void log(HttpRequest request, byte[] body, ClientHttpResponse response) throws IOException {
			System.out.println(new String(body));
			System.out.println( new String(FileCopyUtils.copyToByteArray(response.getBody())));
	}
}