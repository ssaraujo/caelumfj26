package br.com.caelum.notasfiscais.mb;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ViewScoped
@ManagedBean(name="produtoBean")
public class ProdutoBean implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Produto produto = new Produto();
private List<Produto> produtos;

DAO<Produto> dao;
public ProdutoBean() {
	dao = new DAO<Produto>(Produto.class);
	produtos=dao.listaTodos();
}

public Produto getProduto() {
	return produto;
}

 public void grava(){
	 if(produto.getId()==null){
		 dao.adiciona(produto);
	 }else{
		 dao.atualiza(produto);
	 }
	 
	 this.produto= new Produto();
	 produtos=dao.listaTodos();
 }
 public void remove(Produto p){
	 //DAO<Produto> dao = new DAO<Produto>(Produto.class);
	 dao.remove(p);	 
	 produtos=dao.listaTodos();
 }
 public List<Produto> getProdutos(){
	 return produtos;
 }
 public void setProduto(Produto p){
	 this.produto=p;
 }

}
