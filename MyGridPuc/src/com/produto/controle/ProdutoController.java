package com.produto.controle;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputHidden;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.produto.entidade.Produto;
import com.produto.negocio.ProdutoService;
import com.produto.util.ProdutoException;

/**
 * Classe que controla as requisicoes do cliente web
 * @author David Rodrigues
 *
 */
@ManagedBean(name="produtoController")
@RequestScoped
@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoBean produtoBean;
	@Autowired
	private List<ProdutoBean> listProdutoBean;
	@Autowired
	private ProdutoService produtoService;
	
	public ProdutoController(){
		produtoBean = new ProdutoBean();
	}
	
	
	/**
	 * Incluir um produto na base de dados
	 * @return
	 */
	public String incluir(){
		try{
			
			Produto produto = new Produto();
			
			//preenche os dados da tela no objeto persistente
			produto.setIdProduto(produtoBean.getIdProduto());
			produto.setNome(produtoBean.getNome());
			produto.setDescricao(produtoBean.getDescricao());
			produto.setQuantidade(produtoBean.getQuantidade());
			produto.setValor(produtoBean.getValor());
			produto.setDataInicio(new Date());
//			produto.setDataFim(formatDate(produtoBean.getDataVencimento()));
			produto.setDataFim(produtoBean.getDataFim());
			
			getProdutoService().incluir(produto);
			
			return "sucesso";
			
		}catch (Exception e){
			String msg = "Inclusão não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Lista produtos cadastrados
	 * @return
	 */
	public String listar(){
		try{
			List<Produto> listProdutos = getProdutoService().listar();
			
			if(listProdutos == null || listProdutos.size() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar";
			}
			
			//preeche a lista de pessoas da tela
			listProdutoBean = new ArrayList<ProdutoBean>();
			
			for(Produto produto: listProdutos){
				ProdutoBean produtoBean = new ProdutoBean();
				produtoBean.setIdProduto(produto.getIdProduto());
				produtoBean.setNome(produto.getNome());
				produtoBean.setDescricao(produto.getDescricao());
				produtoBean.setQuantidade(produto.getQuantidade());
				produtoBean.setValor(produto.getValor());
				produtoBean.setDataInicio(produto.getDataInicio());
				produtoBean.setDataFim(produto.getDataFim());
				listProdutoBean.add(produtoBean);
			}
			
			return "listar";
			
		}catch(Exception e){
			String msg = "Listagem não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public String consultar(){
		try{
			HtmlInputHidden idProduto = (HtmlInputHidden) getFacesContext().getViewRoot().findComponent("formulario:idProduto");
			
			Produto produto = getProdutoService().consultar((Integer) idProduto.getValue());
			
			if(produto == null || produto.getIdProduto() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar";
			}
			
			//preenche os dados do bean da tela
			produtoBean.setIdProduto(produto.getIdProduto());
			produtoBean.setNome(produto.getNome());
			produtoBean.setDescricao(produto.getDescricao());
			produtoBean.setQuantidade(produto.getQuantidade());
			produtoBean.setValor(produto.getValor());
			produtoBean.setDataInicio(produto.getDataInicio());
			produtoBean.setDataFim(produto.getDataFim());
			
			return "editar";
			
		}catch(Exception e){
			String msg = "Consulta não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Criar novo Produto
	 * @return
	 */
	public String criar(){
		try{
			produtoBean = new ProdutoBean();
			return "criar";
			
		}catch(Exception e){
			String msg = "Consulta não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	/**
	 * Excluir pessoa cadastrada
	 * @return
	 */
	public String excluir(){
		try{
			HtmlInputHidden idProduto = (HtmlInputHidden) getFacesContext().getViewRoot().findComponent("formulario:idProduto");
			
			Produto produto = getProdutoService().consultar((Integer) idProduto.getValue());
			
			if(produto == null || produto.getIdProduto() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar";
			}
			getProdutoService().excluir(produto.getIdProduto());
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Exclusão não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public String alterar(){
		try{
			
			Produto produto = getProdutoService().consultar(produtoBean.getIdProduto());
			
			if(produto == null || produto.getIdProduto() == 0){
				FacesMessage facesMessage = new FacesMessage("Nenhum registro encontrado");
				getFacesContext().addMessage("formulario", facesMessage);
				return "listar";
			}
			
			//preenche os dados da tela no objeto persistente
			produto.setNome(produtoBean.getNome());
			produto.setDescricao(produtoBean.getDescricao());
			produto.setValor(produtoBean.getValor());
			produto.setQuantidade(produtoBean.getQuantidade());
			produto.setDataFim(produtoBean.getDataFim());
			
			getProdutoService().alterar(produto);
			return "sucesso";
			
		}catch(Exception e){
			String msg = "Alteração não realizada. Movito: " + ((e instanceof ProdutoException ? ((ProdutoException)e).getEx().getMessage():""));
			FacesMessage message = new FacesMessage(msg);
			getFacesContext().addMessage("formulario", message);
			return "falha";
		}
	}
	
	public java.sql.Date formatDate(String date){
		
		DateFormat df = DateFormat.getDateInstance();
		java.util.Date dateUtil = new java.util.Date();
		
		try {
			dateUtil = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		java.sql.Date dateSql = new java.sql.Date(dateUtil.getTime());
		return dateSql;
	}
	
	public ProdutoBean getProdutoBean() {
		return produtoBean;
	}
	public void setProdutoBean(ProdutoBean produtoBean) {
		this.produtoBean = produtoBean;
	}
	public List<ProdutoBean> getListProdutoBean() {
		return listProdutoBean;
	}
	public void setListProdutoBean(List<ProdutoBean> listProdutoBean) {
		this.listProdutoBean = listProdutoBean;
	}
	public ProdutoService getProdutoService() {
		return produtoService;
	}
	public void setProdutoService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	private FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}
	
}
