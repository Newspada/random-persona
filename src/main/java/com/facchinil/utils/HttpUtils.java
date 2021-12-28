package com.facchinil.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import lombok.SneakyThrows;

public class HttpUtils {
	
	private HttpUtils() {
	    throw new IllegalStateException();
	  }
	
	@SneakyThrows
	public static <A> A getObject(String url, Class<A> clazz) {
		HttpGet request = new HttpGet(url);
        try(CloseableHttpClient client = HttpClients.createDefault()) {
	        CloseableHttpResponse response = client.execute(request);
	        HttpEntity entity = response.getEntity();
	        A obj = new Gson().fromJson(EntityUtils.toString(entity), clazz);
	        response.close();
	        return obj;
        }
	}
}
