package br.fatec.exercicio9.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.fatec.exercicio9.dao.UsuarioDAO;
import br.fatec.exercicio9.dao.UsuarioDAOHibernate;
import br.fatec.exercicio9.model.Usuario;

@ManagedBean(name = "usuarioBean")
@RequestScoped

public class UsuarioBean {

	private List<SelectItem> usuarioItem;
	
	private Usuario usuario = new Usuario(); // propriedade do tipo Usuario

	private DataModel<Usuario> listaUsuarios;

	@SuppressWarnings("unchecked")
	public DataModel<Usuario> getListaUsuarios() {
		if (listaUsuarios == null) {
			UsuarioDAO dao = new UsuarioDAOHibernate();
			listaUsuarios = new ListDataModel<Usuario>(dao.listar());
		}
		return listaUsuarios;
	}

	public void setListaUsuarios(DataModel<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	private String confirmarSenha;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	// porta de entrada do formulário
	// preparar cadastro novo usuario
	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "publico/usuario"; // tenta exibir usuario.xhtml
	}

	public String listagem() {
		this.usuario = new Usuario();
		return "publico/listagem"; // tenta exibir usuarioalt.xhtml
	}

	public String salvar() {
		// facescontext adiciona as mensagens de erro que possam ser criadas
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) { // adicionando mensagem ao
													// context
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null; // null nao caira em nenhuma pagina, fica na mesma de
							// origem
		}

		// se deu certo
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return "usuariosucesso"; // tenta abrir pagina /public/usuariosucesso
									// nao colocou o publico mas
		// o contexto de salvar está em /publico
	}

	public Usuario buscaPorLogin() {
		UsuarioDAO dao = new UsuarioDAOHibernate();
		Usuario Usu = dao.carregar(usuario.getCodigo());
		return  Usu;
	//	return "publico/usuarioalt"; // tenta exibir usuarioalt.xhtml
	
	}


	public List<SelectItem> getUsuarios() {
		// Cria objeto de modelo Faces
		usuarioItem = new ArrayList<SelectItem>();
		// cria objeto DAO
		UsuarioRN pais = new UsuarioRN();
		List<Usuario> usuario2 = pais.listar();
		// Alimenta Modelo
		for (Usuario c : usuario2) {
			SelectItem selecao = new SelectItem(c.getCodigo(), c.getNome());
			usuarioItem.add(selecao);
		}
		return usuarioItem;
	}
}
