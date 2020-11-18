package br.com.email.mensagex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.email.mensagex.dao.TarefaDao;
import br.com.email.mensagex.dao.UsuarioDao;
import br.com.email.mensagex.entity.Usuario;

@WebServlet(name = "usuario", urlPatterns = {"/usuarioController"})
public class UsuarioController extends HttpServlet {

	private static final long serialVersionUID = -865738222918951544L;
	
	private static String ADICIONA = "/pages/usuario.jsp";
	private static String LISTA_USUARIO = "/pages/listaUsuario.jsp";
	private static String LISTA_TAREFA_USUARIO = "/pages/listaTarefaUsuario.jsp";
	private UsuarioDao usuarioDao;
	private TarefaDao tarefaDao;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		usuarioDao = new UsuarioDao();
		
		String forward = "";
		String action = req.getParameter("action");
		
			if(action.equalsIgnoreCase("listaUsuario")) {
				forward = LISTA_USUARIO;
				req.setAttribute("usuarios", usuarioDao.lista());
				
				
			} else if (action.equalsIgnoreCase("listaTarefaUsuario")) {
				tarefaDao = new TarefaDao();
				forward = LISTA_TAREFA_USUARIO;
				int id =  Integer.parseInt(req.getParameter("id"));				
				req.setAttribute("tarefas", tarefaDao.getTarefaByUsuarioId(id));
			} else {			
				forward = ADICIONA;
			}
		
		RequestDispatcher view = req.getRequestDispatcher(forward); view.forward( req, resp );
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Usuario usuario = new Usuario();

		usuario.setNome( req.getParameter("nome"));		
		usuario.setEmail(req.getParameter("email"));
		usuario.setSenha(req.getParameter("senha"));

		UsuarioDao usuarioDao = new UsuarioDao();

		usuarioDao.adiciona(usuario);
		
		RequestDispatcher view = req.getRequestDispatcher(LISTA_USUARIO);
        req.setAttribute("usuarios", usuarioDao.lista());
        view.forward(req, resp);
		
	}
}