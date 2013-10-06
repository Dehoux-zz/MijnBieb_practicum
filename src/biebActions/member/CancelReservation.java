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

@SuppressWarnings("serial")
public class CancelReservation extends ActionSupport implements UserAware{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private User user;
	private Book book;
	private int bookID;
	
	public String execute() {
		book = ibs.getBookById(bookID);
		for(int i=0; i < user.getBooks().size(); i++){
			if(book.equals(user.getBooks().get(i))){
				book.setStatus(BookStatus.AVAILABLE);
				user.getBooks().remove(i);
			}
		}
		addFieldError("bookID", "Boek succesvol geannuleerd");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if(ibs.getBookById(bookID)==null){
			addFieldError("bookID", "Boek id is ongeldig");
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public IBiebService getIbs() {
		return ibs;
	}

	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public List<Book> getMemberBooks(){
		return user.getBooks();
	}
}
