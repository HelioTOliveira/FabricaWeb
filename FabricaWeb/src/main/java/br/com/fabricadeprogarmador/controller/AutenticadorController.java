package br.com.fabricadeprogarmador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import br.com.fabricadeprogramador.percistencia.entidade.Usuario;
import br.com.fabricadeprogramador.percistencia.jdbc.UsuarioDAO;


public class AutenticadorController extends HttpServlet{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuAutenticar = usuarioDao.autenticar(usuario);
		
		if(usuAutenticar != null){
			
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuAtenticado", usuAutenticar);
			
			sessao.setMaxInactiveInterval(60*5);
			
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}else{
			resp.getWriter().println("<script> window.alert('Não encontrado!'); location.href='login.html';</script>");
		}
	}
}
