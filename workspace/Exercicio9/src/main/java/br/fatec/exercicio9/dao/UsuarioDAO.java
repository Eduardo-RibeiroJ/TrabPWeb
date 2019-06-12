package br.fatec.exercicio9.dao;

import java.util.List;

import br.fatec.exercicio9.model.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);	
	public void excluir(Usuario usuario);
	public Usuario carregar(Integer codigo);
	public Usuario buscarPorLogin(String login);
	public List listar();

}
