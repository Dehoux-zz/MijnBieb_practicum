package biebActions.manager;

import java.util.ArrayList;
import java.util.List;

import biebDomain.Book;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AlleUsers extends ActionSupport {

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> users = (ArrayList<User>)ibs.getUsers();
	
	public String execute() throws Exception{
		users = ibs.getUsers();
		
		return ActionSupport.SUCCESS;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
}
