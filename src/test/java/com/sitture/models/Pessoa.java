package com.sitture.models;

import java.util.List;

public class Pessoa {

	private int codigo;
	private String nome;
	private String cpf;
	private List<Enderecos>  enderecos;
	private List<Telefone>  telefones;

	public Pessoa(int codigo, String nome,String cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Enderecos> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Enderecos> enderecos) {
		this.enderecos = enderecos;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> Ttelefones) {
		telefones = Ttelefones;
	}
	
	
	

	

}
