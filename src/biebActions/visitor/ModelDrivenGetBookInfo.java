package biebActions.visitor;

import java.util.List;

import biebDomain.Book;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ModelDrivenGetBookInfo extends ActionSupport implements ModelDriven{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private int bookID;
	private Book book;

	@Override
	public Object getModel() {
		return book;
	}
	
	public String execute() {
		book = ibs.getBookById(bookID);
		return SUCCESS;
	}
	
	public void validate(){
		if(ibs.getBookById(bookID)==null){
			addFieldError("bookID", "Boek id is ongeldig");
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
}
