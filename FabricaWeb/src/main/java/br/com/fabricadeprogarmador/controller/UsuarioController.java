package br.com.fabricadeprogarmador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.percistencia.entidade.Usuario;
import br.com.fabricadeprogramador.percistencia.jdbc.UsuarioDAO;

/**
 * Servlet implementation class UsuarioController
 */
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acao = req.getParameter("acao");
		
		if(acao.equals("exc")){
		
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			if(id != null)
				usu.setIdUsuario(Integer.parseInt(id));
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usu);
			
			resp.getWriter().println("Excluido com Sucesso");
		}else if(acao.equals("lis")){
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> lista = usuarioDAO.buscarTodos();
			resp.getWriter().println(lista);
		}
			
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usu = new Usuario();
		
		if(id != null)
			usu.setIdUsuario(Integer.parseInt(id));
			
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.salvar(usu);
		
		System.out.println("Salvo com Sucesso!!!!");
		
		resp.getWriter().print("<b>Salvo Com Sucesso!!!</b>");
	}
	
}
