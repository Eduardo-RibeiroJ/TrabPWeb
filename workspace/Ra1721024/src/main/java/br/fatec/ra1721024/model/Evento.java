package br.fatec.ra1721024.model;

import java.util.Date;

public class Evento {

	private int idEvento;
	private String nomeEvento;
	private Date dataEvento;
	private String localEvento;
		
	
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getLocalEvento() {
		return localEvento;
	}
	public void setLocalEvento(String localEvento) {
		this.localEvento = localEvento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
		result = prime * result + idEvento;
		result = prime * result + ((localEvento == null) ? 0 : localEvento.hashCode());
		result = prime * result + ((nomeEvento == null) ? 0 : nomeEvento.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		if (dataEvento == null) {
			if (other.dataEvento != null)
				return false;
		} else if (!dataEvento.equals(other.dataEvento))
			return false;
		if (idEvento != other.idEvento)
			return false;
		if (localEvento == null) {
			if (other.localEvento != null)
				return false;
		} else if (!localEvento.equals(other.localEvento))
			return false;
		if (nomeEvento == null) {
			if (other.nomeEvento != null)
				return false;
		} else if (!nomeEvento.equals(other.nomeEvento))
			return false;
		return true;
	}
	
	

	
	
}
