package br.fatec.exercicio9.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.fatec.exercicio9.dao.PermissaoDAO;
import br.fatec.exercicio9.dao.PermissaoDAOHibernate;
import br.fatec.exercicio9.model.Permissao;

@ManagedBean(name = "permissaoBean")
@RequestScoped

public class PermissaoBean {

	private Permissao permissao = new Permissao(); // propriedade do tipo Permissao

	private DataModel<Permissao> listaPermissaos;

	@SuppressWarnings("unchecked")
	public DataModel<Permissao> getListaPermissaos() {
		if (listaPermissaos == null) {
			PermissaoDAO dao = new PermissaoDAOHibernate();
			listaPermissaos = new ListDataModel<Permissao>(dao.listar());
		}
		return listaPermissaos;
	}

	public void setListaPermissaos(DataModel<Permissao> listaPermissaos) {
		this.listaPermissaos = listaPermissaos;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

		// porta de entrada do formulário
	// preparar cadastro novo permissao
	public String novo() {
	this.permissao = new Permissao();
	/**	this.permissao.setInserir(true);
		this.permissao.setAlterar(true);
		this.permissao.setExcluir(true);
		this.permissao.setVisualizar(true);**/
		
		
		return "publico/permissao"; // tenta exibir permissao.xhtml
	}

	public String listagem() {
		this.permissao = new Permissao();
		return "publico/listagemp"; // tenta exibir permissaoalt.xhtml
	}

	public String salvar() {
		// se deu certo
		PermissaoRN permissaoRN = new PermissaoRN();
		permissaoRN.salvar(this.permissao);
		return "permissaosucesso"; // tenta abrir pagina /public/permissaosucesso
									// nao colocou o publico mas
		// o contexto de salvar está em /publico
	}

	public Permissao buscaPorLogin() {
		PermissaoDAO dao = new PermissaoDAOHibernate();
		Permissao Permi = dao.carregar(permissao.getId());
		return  Permi;
	//	return "publico/permissaoalt"; // tenta exibir permissaoalt.xhtml
	
	}


}
