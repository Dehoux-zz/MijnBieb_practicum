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

@SuppressWarnings("serial")
public class AddBook extends ActionSupport{

	private IBiebService ibs = ServiceProvider.getBiebService();
	private List<User> coworkers = new ArrayList<User>();
	private List<Book> books = new ArrayList<Book>();
	private int bookId;
	private String titel;
	private String auteur;
	private String isbn;
	private int pages;

	public String execute() throws Exception{

		ibs.addBook(bookId, titel, auteur, isbn, pages);
		books = ibs.getBooks();
		System.out.println("validate2");

		return ActionSupport.SUCCESS;
	}

	public void validate(){
		try{
			titel = titel.trim();
			auteur = auteur.trim();
			if(titel.equals("")){
				addFieldError( "titel", "titel is verplicht");
			}
			if(auteur.equals("")){
				addFieldError( "auteur", "auteur is verplicht");
			}
			if(isbn.equals("")){
				addFieldError( "isbn", "isbn is verplicht");
			}
			if(bookId == 0){
				addFieldError( "bookId", "bookId is verplicht");
			}
			if(ibs.getBookById(bookId) != null){
				addFieldError( "bookId", "bookId is al in gebruik");
			}
			if(pages == 0){
				addFieldError( "pages", "pages is verplicht");
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void setBookId(String bookId) {
		if(bookId.equals("")){
			this.bookId = 0;
		} else {
		this.bookId = Integer.parseInt(bookId);
		}	
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setPages(String pages) {
		if(pages.equals("")){
			this.pages = 0;
		} else {
		this.pages = Integer.parseInt(pages);
		}
	}
	
	public List<Book> getBooks(){
		return this.books;
	}



}
