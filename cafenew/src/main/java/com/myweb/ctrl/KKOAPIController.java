package com.myweb.ctrl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class KKOAPIController
{
	@RequestMapping(value = "/KKOAPIController", 
					method = { RequestMethod.POST, RequestMethod.GET}, 
					headers = { "Accept=application/json"})
	public String callAPI(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			String jsonInString = mapper.writeValueAsString(params);
			System.out.println(jsonInString);
		} catch (Exception e)
		{}
		return "index";
	}

}