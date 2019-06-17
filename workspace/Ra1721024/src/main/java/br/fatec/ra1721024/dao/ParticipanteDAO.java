package br.fatec.ra1721024.dao;

import java.util.List;

import br.fatec.ra1721024.model.Participante;

public interface ParticipanteDAO {
	
	public void salvar(Participante participante);
	public void atualizar(Participante participante);	
	public void excluir(Participante participante);
	public Participante carregar(Integer codigo);
	public List listar();

}
