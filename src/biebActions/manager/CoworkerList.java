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

public class CoworkerList extends ActionSupport{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> coworkers = new ArrayList<User>();
	private String username;
	private String password;

	public String execute() throws Exception{
		if(username != null){
			ibs.addCoworker(username,password);
		}

		List<User> users = ibs.getUsers();

		for(User user : users){
			if (user.getUr() == UserRole.Coworker){
				coworkers.add(user);
			}
		}

		return ActionSupport.SUCCESS;
	}

	public void validate(){
		try{
			username = username.trim();
			password = password.trim();

			if (username.length() == 0 ){			
				addFieldError( "username", "naam is verplicht");
			}
			else if ( ibs.userExists(username ) ){		
				addFieldError("username", "gebruiker bestaat al");
			}

			if ( password.length() == 0 ){			
				addFieldError( "password", "wachtwoord is verplicht");
			}
		}catch(NullPointerException npe){}
	}

	public List<User> getCoworkers() {
		return coworkers;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


}
