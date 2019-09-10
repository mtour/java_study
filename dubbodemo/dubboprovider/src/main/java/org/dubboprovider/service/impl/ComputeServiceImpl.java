package org.dubboprovider.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcw.dubbointerface.*;

@Component
@Service(version = "1.0.0")
public class ComputeServiceImpl implements ComputeService{

	public int sum(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return arg0+arg1;
	}
   
}
