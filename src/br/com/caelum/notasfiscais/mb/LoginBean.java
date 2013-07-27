package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {
	private static final String PRODUTO="produto?faces-redirect=true";
	private static final String LOGIN=	"login?faces-redirect=true"	;
	private Usuario usuario = new Usuario();
	
	boolean logado=false;
	
	public boolean isLogado(){
		return logado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin(){
		 UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido =dao.existe(usuario);
		System.out.println("O login era valido? "+loginValido);
		if(loginValido){
			logado=true;
			return PRODUTO;
			
		}else{
			return LOGIN;
		}
	}
	
	public void logoff(){
		logado=false;
		usuario = new Usuario();
	}
	
}
