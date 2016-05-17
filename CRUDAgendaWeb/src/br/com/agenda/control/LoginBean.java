package br.com.agenda.control;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@ManagedBean (name="loginBean")
@SessionScoped
public class LoginBean {

	private String username = "";
	private String password = "";
	
	/**
	 * M�todo efetua o login do usu�rio, faz a valida��o de usu�rio e retorna p�gina Home caso login com sucesso
	 * @return String - p�gina home
	 */
	public String efetuarLogin(){
		
		if(username.equalsIgnoreCase("admin") && password.equals("admin")){
			System.out.println("login ok");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				
			}
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Ok","Login efetuado com sucesso");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
			
			return "home";
			
		}else{
			System.out.println("login erro");
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio ou senha inv�lidos","Usu�rio ou senha inv�lidos");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
			return "";
		}
		
	}

	//getters and setters
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
