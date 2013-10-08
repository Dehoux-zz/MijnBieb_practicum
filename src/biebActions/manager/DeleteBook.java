package biebActions.manager;

import java.util.ArrayList;
import java.util.List;

import biebDomain.Book;
import biebDomain.BookStatus;
import biebDomain.User;
import biebDomain.UserRole;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DeleteBook extends ActionSupport{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<Book> books = new ArrayList<Book>();
	private int dBookId;
	
	public String execute() throws Exception{
		ibs.deleteBook(dBookId);
		books = ibs.getBooks();
		
		return ActionSupport.SUCCESS;
	}

	public void validate(){
		if(ibs.getBookById(dBookId).getStatus() == BookStatus.BORROWED){
			addFieldError( "bookID2", "kan geen boek verwijderen die uitgeleend zijn");
		}
		
		if(ibs.getBookById(dBookId).getStatus() == BookStatus.RESERVED){
			addFieldError( "bookID2", "kan geen boek verwijderen die gereserveerd zijn");
		}
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setDBookId(int dBookId){
		this.dBookId = dBookId;
	}
	
	
	
}
