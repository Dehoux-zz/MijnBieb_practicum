package biebActions.visitor;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;

import com.opensymphony.xwork2.ActionSupport;

import biebDomain.UserRole;

public class Menu extends ActionSupport implements ApplicationAware{

	Map application;
	
	@Override
	public void setApplication(Map<String, Object> app) {
		this.application = app;
	}

	@SuppressWarnings("unchecked")
	public String execute(){
		Integer aantal = (Integer)application.get("aantal");
		if(aantal==null) 
			aantal = 1;
		aantal++;
		application.put("aantal", aantal);
		return SUCCESS;
	}
}
