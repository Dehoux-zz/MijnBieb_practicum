package biebActions.member;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.User;

public class MemberBooks extends ActionSupport implements UserAware {
	
	private User user;
	
	public String execute(){
		return ActionSupport.SUCCESS;
	}

	public ArrayList<Book> getMemberBooks(){
		return user.getBooks();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
