package com.sitture.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestInstance {

	private static RequestSpecification request;
	public static Response response;


	public static synchronized RequestSpecification request() {
		if (request == null) {
			request = RestAssured.given();
		}
		return request;
	}

}
