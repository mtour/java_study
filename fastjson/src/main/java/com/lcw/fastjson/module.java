package com.lcw.fastjson;

import java.util.List;

public class module {
	private int module_id;
	private int p_id;
	public List<module> module_list;
	public List<permission> permission_list;
	
	
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

}
