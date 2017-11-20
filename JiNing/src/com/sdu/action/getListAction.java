package com.sdu.action;

import java.util.ArrayList;
import java.util.Map;

/*import net.sf.json.JSONArray;*/



import com.opensymphony.xwork2.ActionSupport;
/*  */

public class getListAction extends ActionSupport{
	/*private ArrayList<Data> list = new ArrayList<Data>();*/
	/*private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}*/
	/*public ArrayList<Data> getList() {
		return list;
	}
	public void setList(ArrayList<Data> list) {
		this.list = list;
	}*/
	@Override
	public String execute() throws Exception {
/*		
		Data data1 = new Data();
		data1.setName("水质分析文件.csv");
		data1.setSize("37MB");
		data1.setCreatetime("2017-10-28 15:00:56");
		Data data2 = new Data();
		data2.setName("煤矿数据1.sql");
		data2.setSize("319MB");
		data2.setCreatetime("2017-10-28 15:00:57");
		list.add(data1);
		list.add(data2);*/
	/*	JSONArray array = JSONArray.fromObject(list);
		System.out.println(array);*/
		return SUCCESS;
	}
	
}
