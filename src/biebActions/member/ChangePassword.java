package biebActions.member;

import java.util.Map;

import org.apache.struts.action.ActionMessage;
import org.apache.struts2.interceptor.SessionAware;

import biebAware.UserAware;
import biebDomain.User;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePassword extends ActionSupport  implements UserAware{
	
	private String huidigWachtwoord;
	private String nieuwWachtwoord;
	private User user;
	
	public String execute(){
		user.setPassword(nieuwWachtwoord);
		addFieldError("huidigWachtwoord", "Wachtwoord succesvol gewijzigd");
		return ActionSupport.SUCCESS;
	}
	
	public void validate(){
		if(!user.getPassword().equals(huidigWachtwoord) && huidigWachtwoord!=null){
			addFieldError("huidigWachtwoord", "Wachtwoord klopt niet!");
		}
		if(!(nieuwWachtwoord.length()>8)){
			addFieldError("nieuwWachtwoord", "Wachtwoord is te kort");
		}
		boolean upper=false;
		boolean lower=false;
		boolean cijfer=false;
		boolean white=false;
		for(int i=0; i < nieuwWachtwoord.length(); i++){
			if(Character.isUpperCase(nieuwWachtwoord.charAt(i))){
				upper=true;			
			}
			if(Character.isLowerCase(nieuwWachtwoord.charAt(i))){
				lower=true;
			}
			if(Character.isDigit(nieuwWachtwoord.charAt(i))){
				cijfer=true;
			}
			if(!Character.isWhitespace(nieuwWachtwoord.charAt(i))){
				white=true;
			}
		}
		if(!upper){
			addFieldError("nieuwWachtwoord", "Wachtwoord moet minstens één hoofdletter bevatten");
		}
		if(!lower){
			addFieldError("nieuwWachtwoord", "Wachtwoord moet minstens één kleine letter bevatten");
		}
		if(!cijfer){
			addFieldError("nieuwWachtwoord", "Wachtwoord moet minstens één cijfer bevatten");
		}
		if(!white){
			addFieldError("nieuwWachtwoord", "Wachtwoord mag geen spaties bevatten");
		}
		
		
		
		
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setHuidigWachtwoord(String huidigWachtwoord) {
		this.huidigWachtwoord = huidigWachtwoord;
	}

	public void setNieuwWachtwoord(String nieuwWachtwoord) {
		this.nieuwWachtwoord = nieuwWachtwoord;
	}
	
	
	
	
}
