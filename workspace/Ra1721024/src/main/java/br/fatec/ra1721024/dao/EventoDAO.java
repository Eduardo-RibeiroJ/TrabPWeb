package br.fatec.ra1721024.dao;

import java.util.List;

import br.fatec.ra1721024.model.Evento;

public interface EventoDAO {
	
	public void salvar(Evento evento);
	public void atualizar(Evento evento);	
	public void excluir(Evento evento);
	public Evento carregar(Integer codigo);
	public Evento buscarPorParticipanteOpcao(Integer codigo, String opcao);
	public List listar();

}
