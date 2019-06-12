package br.fatec.exercicio9.dao;

import java.util.List;

import br.fatec.exercicio9.model.Permissao;

public interface PermissaoDAO {
	
	public void salvar(Permissao permissao);
	public void atualizar(Permissao permissao);	
	public void excluir(Permissao permissao);
	public Permissao carregar(Integer codigo);
	public Permissao buscarPorUsuarioOpcao(Integer codigo, String opcao);
	public List listar();

}
