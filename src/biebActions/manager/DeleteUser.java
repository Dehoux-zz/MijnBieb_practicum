package biebActions.manager;

import java.util.ArrayList;
import java.util.List;

import biebDomain.Book;
import biebDomain.User;
import biebDomain.UserRole;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteUser extends ActionSupport{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> users = new ArrayList<User>();
	private String username;

	public String execute() throws Exception{
		System.out.println("test");
		if(username != null){
			ibs.deleteUser(username);
			System.out.println(username);
		}

		users = ibs.getUsers();

		return ActionSupport.SUCCESS;
	}

	public void validate(){
		try{
			username = username.trim();

			if (ibs.hasBorrowedBooks(username)){			
				addFieldError( "username", "kan geen users verwijderen die een boek hebben");
			}

		}catch(NullPointerException npe){}
	}

	public List<User> getUsers() {
		return users;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


}
