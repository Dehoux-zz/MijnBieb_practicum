package biebActions.member;

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

public class BookReservation extends ActionSupport implements UserAware{
	
	private IBiebService ibs = ServiceProvider.getBiebService();
	private int bookID;
	private User user;
	private Book book;
	
	public String execute() {
		book = ibs.getBookById(bookID);
		book.setStatus(BookStatus.RESERVED);
		user.getBooks().add(book);
		addFieldError("bookID", "Boek succesvol gereserveerd");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if(ibs.getBookById(bookID)==null){
			addFieldError("bookID", "Boek id is ongeldig");
		} else if(ibs.getBookById(bookID).getStatus() != BookStatus.AVAILABLE){
			addFieldError("bookID", "Boek is al gereserveerd");
		}
	}
	
	public List<Book> getBooks(){
		return ibs.getBooks();
	}
	
	public void setBookID(String bookID) {
		this.bookID = Integer.parseInt(bookID);
	}

	public Book getBook(){
		return book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}

