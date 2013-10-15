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

public class UnLendBook extends ActionSupport{
	
	private IBiebService ibs = ServiceProvider.getBiebService();
	private int bookID;
	private List<Book> allBooks = new ArrayList<Book>();
	private List<Book> books = new ArrayList<Book>();

	public String execute() {
		ibs.takeBackBook(bookID);
		addFieldError("bookID", "Boek succesvol terug gekregen");
		for (Book book : allBooks){
			if(book.getStatus() == BookStatus.BORROWED || book.getStatus() == BookStatus.RESERVED ){
				books.add(book);
			}
		}
		return ActionSupport.SUCCESS;
	}

	public void validate(){
		allBooks = ibs.getBooks();
		if(ibs.getBookById(bookID)==null){
			addFieldError("bookID", "Boek id is ongeldig");
		} else if(ibs.getBookById(bookID).getStatus() == BookStatus.AVAILABLE){
			addFieldError("bookID", "Boek niet in gebruik");
		}
	}
	
	public void setIbs(IBiebService ibs) {
		this.ibs = ibs;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public List<Book> getusedBooks() {
		return books;
	}
	
	public List<Book> getBooks() {
		return allBooks;
	}
	
}

