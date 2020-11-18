package br.com.email.mensagex.entity;

import java.util.List;

public class Usuario {

	private Integer id;	
	private String nome;
	private String email;
	private String senha;
	private List<Tarefa> tarefas;
	
	public Usuario() {
		
	}

	Usuario(Integer id, String nome, String email, String senha, List<Tarefa> tarefas) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tarefas = tarefas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
}