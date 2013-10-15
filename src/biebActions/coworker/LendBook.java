package biebActions.coworker;

import java.util.ArrayList;
import java.util.List;

import biebAware.UserAware;
import biebDomain.Book;
import biebDomain.BookStatus;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xerces.internal.util.Status;

public class LendBook extends ActionSupport{
	
	private IBiebService ibs = ServiceProvider.getBiebService();
	private int bookID;
	private String user;
	private List<Book> books = new ArrayList<Book>();

	
	
	public String execute() {
		ibs.lendBook(user, bookID);
		addFieldError("bookID", "Boek succesvol uitgeleend");
		return ActionSupport.SUCCESS;
	}

	public void validate(){
		books = ibs.getBooks();
		if(ibs.getBookById(bookID)==null){
			addFieldError("bookID", "Boek id is ongeldig");
		} else if(ibs.getBookById(bookID).getStatus() != BookStatus.AVAILABLE){
			addFieldError("bookID", "Boek is al in gebruik");
		}
		
		if(ibs.getUserByUsername(user) == null){
			addFieldError("user", "username is ongeldig");
		}
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
}

