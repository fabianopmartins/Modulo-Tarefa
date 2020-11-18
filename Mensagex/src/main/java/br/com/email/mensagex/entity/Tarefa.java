package br.com.email.mensagex.entity;

import java.util.Date;

public class Tarefa {

	private Integer id;
	private String titulo;
	private Date dataTarefa;
	private Usuario usuario;
	
	public Tarefa() {

	}

	Tarefa(Integer id, String titulo, Date dataTarefa, Usuario usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataTarefa = dataTarefa;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataTarefa() {
		return dataTarefa;
	}

	public void setDataTarefa(Date dataTarefa) {
		this.dataTarefa = dataTarefa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}