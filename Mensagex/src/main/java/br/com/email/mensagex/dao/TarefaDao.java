package br.com.email.mensagex.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.email.mensagex.entity.Tarefa;
import br.com.email.mensagex.entity.Usuario;
import br.com.email.mensagex.factory.ConnectionFactory;

public class TarefaDao {

	private Connection connection;

	public TarefaDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public List<Tarefa> getTarefaByUsuarioId(int id) {		
		List<Tarefa> tarefas = new ArrayList<>();	
		try {			
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from tarefa where usuario_id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()) {			
				Tarefa tarefa = new Tarefa();
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				tarefas.add(tarefa);				
			}			
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tarefas;
	}
	
	public void adiciona(Tarefa tarefa) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("insert into tarefa (titulo, dataTarefa, usuario_id) values (?, ?, ?)");

			stmt.setString(1, tarefa.getTitulo());
			stmt.setDate(2, new Date(tarefa.getDataTarefa().getTime()));
			stmt.setInt(3, tarefa.getUsuario().getId());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Tarefa> lista() {
		List<Tarefa> listaTarefa = new ArrayList<>();
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tarefa");
			while (rs.next()) {
				Tarefa tarefa = new Tarefa();
				UsuarioDao usuarioDao = new UsuarioDao();
				Usuario usuario = new Usuario();				
				tarefa.setId(rs.getInt("id"));
				tarefa.setTitulo(rs.getString("titulo"));
				tarefa.setDataTarefa(rs.getDate("dataTarefa"));
				usuario.setId(rs.getInt("usuario_id"));				
				tarefa.setUsuario(usuarioDao.getUsuarioById(usuario.getId()));				
				listaTarefa.add(tarefa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaTarefa;
	}
}