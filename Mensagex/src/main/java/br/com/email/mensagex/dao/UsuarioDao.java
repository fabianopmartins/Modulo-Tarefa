package br.com.email.mensagex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.email.mensagex.entity.Tarefa;
import br.com.email.mensagex.entity.Usuario;
import br.com.email.mensagex.factory.ConnectionFactory;

public class UsuarioDao {

	private Connection connection;

	public UsuarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public Usuario getUsuarioById(int id) {
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuario where id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();			
			if (rs.next()) {							
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public void adiciona(Usuario usuario) {
		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("insert into usuario (nome, email, senha) values (?, ?, ?)");

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> lista() {
		List<Usuario> listaUsuario = new ArrayList<>();
		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from usuario");
			while (rs.next()) {
				Usuario usuario = new Usuario();
				TarefaDao tarefaDao = new TarefaDao(); 
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				
				List<Tarefa> tarefas = tarefaDao.getTarefaByUsuarioId(usuario.getId());
				
				usuario.setTarefas(tarefas);
								
				listaUsuario.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaUsuario;
	}
}