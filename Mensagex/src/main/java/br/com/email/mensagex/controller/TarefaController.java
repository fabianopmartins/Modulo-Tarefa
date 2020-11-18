package br.com.email.mensagex.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.email.mensagex.dao.TarefaDao;
import br.com.email.mensagex.dao.UsuarioDao;
import br.com.email.mensagex.entity.Tarefa;
import br.com.email.mensagex.entity.Usuario;

@WebServlet(name = "tarefa", urlPatterns = {"/tarefaController"})
public class TarefaController extends HttpServlet {

	private static final long serialVersionUID = -5301305984442402075L;
	
	private static String ADICIONA = "/pages/tarefa.jsp";
	private static String LISTA_TAREFA = "/pages/listaTarefa.jsp";
	private TarefaDao tarefaDao;
	private UsuarioDao usuarioDao;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		tarefaDao = new TarefaDao();
		
		String forward = "";
		String action = req.getParameter("action");
			if(action.equalsIgnoreCase("listaTarefa")) {
				forward = LISTA_TAREFA;
				req.setAttribute("tarefas", tarefaDao.lista());				
			} else {
				int id = Integer.parseInt(req.getParameter("id"));
				req.setAttribute("id", id);
				forward = ADICIONA;
			}
		
		RequestDispatcher view = req.getRequestDispatcher(forward); view.forward( req, resp );
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		usuarioDao = new UsuarioDao();
		
		Tarefa tarefa = new Tarefa();

		Usuario usuario = new Usuario();		
		
		tarefa.setTitulo(req.getParameter("titulo"));
	
		usuario.setId(Integer.parseInt(req.getParameter("id")));
		
		tarefa.setUsuario(usuario);
		
		try {
			Date dataTarefa = null;
			
			if(req.getParameter("dataTarefa") != null) {
				dataTarefa = new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("dataTarefa"));
				tarefa.setDataTarefa(dataTarefa);
			}		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		TarefaDao tarefaDao = new TarefaDao();

		tarefaDao.adiciona(tarefa);

		RequestDispatcher view = req.getRequestDispatcher(LISTA_TAREFA);
        req.setAttribute("tarefas", tarefaDao.lista());
        view.forward(req, resp);
		
	}
}