package com.sdu.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sdu.biz.impl.ProjectBizImpl;
import com.sdu.dao.impl.ProjectDaoImpl;
import com.sdu.entity.Admin;
import com.sdu.entity.Project;


public class ProjetAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> map;
	private Project project;
	
	private ProjectBizImpl projectBiz;
	
	private String projectJSONStr;
	private int modelid;
	//=================================================
	
	public Map<String, Object> getMap() {
		return map;
	}
	
	public void setProjectBiz(ProjectBizImpl projectBiz) {
		this.projectBiz = projectBiz;
	}

	public String getProjectJSONStr() {
		return projectJSONStr;
	}

	public void setProjectJSONStr(String projectJSONStr) {
		this.projectJSONStr = projectJSONStr;
	}

	public int getModelid() {
		return modelid;
	}

	public void setModelid(int modelid) {
		this.modelid = modelid;
	}

	//--------------------------------------------------------------
	public String addProject(){
		System.out.println("projectJSONStr:"+projectJSONStr);
		JSONObject obj = new JSONObject(projectJSONStr);
		project = new Project();
		project.setP_name(obj.getString("name"));
		project.setP_describe(obj.getString("describe"));
		project.setP_admin((Admin) ActionContext.getContext().getSession().get("user"));
		Date date = new Date();
		project.setP_createTime(date.getYear()+"-"+date.getMonth()+"-"+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
		System.out.println("开始进入save");
		projectBiz.saveProject(project,obj.getInt("modelid"),obj.getInt("datafileid"));
		//通过modelid 得到algorithmString， 然后把它解析成JSON ARRAY，
		//取出第一个algorithm的actionname， 将它转发给对应antion去执行分析任务，转发时传递3个参数，第一个datafilepath，第二个algorithmString，第三个 index（初始为0，每执行一个action，就增一）
		String algorithmString = project.getP_model().getAlgorithmString();
		JSONArray array = new JSONArray(algorithmString);
		System.out.println("array.getString(0)"+array.getString(0));
		JSONObject obj1 = new JSONObject(array.getString(0));
		System.out.println("actionName"+obj1.getString("actionName"));
		String result = obj1.getString("actionName");
		return result;
	}
}
