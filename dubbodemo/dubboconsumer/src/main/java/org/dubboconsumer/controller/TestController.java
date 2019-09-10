package org.dubboconsumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcw.dubbointerface.ComputeService;

@RestController
@RequestMapping("/")
public class TestController {

	@Reference
	ComputeService computeService;
	
	@RequestMapping("/test")
	public int Test() {
		
		return computeService.sum(1, 2);
	}
}
