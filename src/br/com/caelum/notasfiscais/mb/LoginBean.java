package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
public class LoginBean {
	private static final String PRODUTO="produto";
	private static final String LOGIN=	"login"	;
	private Usuario usuario = new Usuario();
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin(){
		 UsuarioDAO dao = new UsuarioDAO();
		boolean loginValido =dao.existe(usuario);
		System.out.println("O login era valido? "+loginValido);
		if(loginValido){
			return PRODUTO;
		}else{
			return LOGIN;
		}
	}
	
}
