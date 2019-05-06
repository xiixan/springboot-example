package com.superface.example.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Response
 */
public class Response extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

	public Response() {
		put("code", 0);
		put("msg", "操作成功");
	}

	public static Response error() {
		return error(1, "操作失败");
	}

	public static Response error(String msg) {
		return error(500, msg);
	}

	public static Response error(int code, String msg) {
		Response Response = new Response();
		Response.put("code", code);
		Response.put("msg", msg);
		return Response;
	}

	public static Response ok(String msg) {
		Response Response = new Response();
		Response.put("msg", msg);
		return Response;
	}

	public static Response ok(Map<String, Object> map) {
		Response Response = new Response();
		Response.putAll(map);
		return Response;
	}

	public static Response ok() {
		return new Response();
	}

	@Override
	public Response put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}