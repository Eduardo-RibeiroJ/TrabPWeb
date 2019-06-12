package br.fatec.exercicio9.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "permissao")
public class Permissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

    @ManyToOne
	@JoinColumn(name="codigoUsuario", referencedColumnName="codigo",nullable=false, insertable=false, updatable=false)
	private Usuario usuario;
    
	@NaturalId
	private int codigoUsuario;
	@NaturalId
	private String opcaoMenu;

	private boolean inserir;
	private boolean alterar;
	private boolean excluir;
	private boolean visualizar;

	public int getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getOpcaoMenu() {
		return opcaoMenu;
	}

	public void setOpcaoMenu(String opcaoMenu) {
		this.opcaoMenu = opcaoMenu;
	}

	public boolean isInserir() {
		return inserir;
	}

	public void setInserir(boolean inserir) {
		this.inserir = inserir;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public boolean isExcluir() {
		return excluir;
	}

	public void setExcluir(boolean excluir) {
		this.excluir = excluir;
	}

	public boolean isVisualizar() {
		return visualizar;
	}

	public void setVisualizar(boolean visualizar) {
		this.visualizar = visualizar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alterar ? 1231 : 1237);
		result = prime * result + codigoUsuario;
		result = prime * result + (excluir ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (inserir ? 1231 : 1237);
		result = prime * result + ((opcaoMenu == null) ? 0 : opcaoMenu.hashCode());
		result = prime * result + (visualizar ? 1231 : 1237);
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
		Permissao other = (Permissao) obj;
		if (alterar != other.alterar)
			return false;
		if (codigoUsuario != other.codigoUsuario)
			return false;
		if (excluir != other.excluir)
			return false;
		if (id != other.id)
			return false;
		if (inserir != other.inserir)
			return false;
		if (opcaoMenu == null) {
			if (other.opcaoMenu != null)
				return false;
		} else if (!opcaoMenu.equals(other.opcaoMenu))
			return false;
		if (visualizar != other.visualizar)
			return false;
		return true;
	}

}
