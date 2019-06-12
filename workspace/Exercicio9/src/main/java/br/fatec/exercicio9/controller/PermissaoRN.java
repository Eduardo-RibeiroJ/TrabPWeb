package br.fatec.exercicio9.controller;

import java.util.List;

import br.fatec.exercicio9.dao.DAOFactoryPermissao;
import br.fatec.exercicio9.dao.PermissaoDAO;
import br.fatec.exercicio9.model.Permissao;

// unica camada que podera ser comunicar com a camada de dados
// entretanto nao existe qqq referencia ao hibernate mostrando o alto 
// nivel de dedesacoplamento entre camada de acesso a dados e regra de negocio
// por enquanto so permissao so permissao tera  regra de negocio
public class PermissaoRN {
	// padrão formal criar essa propriedade e a instanciacao usando DAOFactory
	private PermissaoDAO permissaoDAO;

	public PermissaoRN() {
		this.permissaoDAO = DAOFactoryPermissao.criaPermissaoDAO();
	}

	// carrega uma instancia
	public Permissao carregar(Integer codigo, String opcao) {
		return this.permissaoDAO.carregar(codigo);
	}

	  // faz repasse metodo na classe DAO
	public Permissao buscarPorCodigoOpcao(Integer codigo, String opcao) {
		return this.permissaoDAO.buscarPorUsuarioOpcao(codigo,opcao);
	}

	// se nao existe salva, caso contrario atualiza
	public void salvar(Permissao permissao) {
		Integer id = permissao.getId();
		if (id == null || id == 0) {
			this.permissaoDAO.salvar(permissao);
		} else {
			this.permissaoDAO.atualizar(permissao);
		}
	}

	public void excluir(Permissao permissao) {
		this.permissaoDAO.excluir(permissao);
	}	

	@SuppressWarnings("unchecked")
	public List<Permissao> listar() {
		return this.permissaoDAO.listar();
	}
}
