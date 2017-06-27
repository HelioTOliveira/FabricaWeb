package br.com.fabricadeprogramador;

import br.com.fabricadeprogramador.percistencia.entidade.Usuario;
import br.com.fabricadeprogramador.percistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeSalvar();
		testeBuscarPorId();
	}
	
	private static void testeExcluir(){
		
	//criando usuario
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(4);
			
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usuario);
		
		System.out.println("Excluido com Sucesso!!!");
	}

	private static void testeAlterar(){
		
		//criando usuario
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(4);
			usuario.setNome("Jo�oz�o da Silva");
			usuario.setLogin("jzaoss");
			usuario.setSenha("12345678");
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.alterar(usuario);
			
			System.out.println("Alterado com Sucesso!!!");
		}
	
	private static void testeCadastrar(){
		
	//criando usuario
		Usuario usuario = new Usuario();
		usuario.setNome("Jo�oz�o");
		usuario.setLogin("jzao");
		usuario.setSenha("123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastra(usuario);
		
		System.out.println("Cadastrado com Sucesso!!!");
	}
	public static void testeSalvar(){
		
		Usuario usuario = new Usuario();
		//usuario.setIdUsuario(2);
		usuario.setNome("Helio");
		usuario.setLogin("hlt");
		usuario.setSenha("4567");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Salvo com Sucesso");
	}
	
	public static void testeBuscarPorId(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscaPorId(2);
		
		System.out.println(usuario);
	}

}
