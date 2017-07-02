package br.com.fabricadeprogramador;

import java.util.List;

import br.com.fabricadeprogramador.percistencia.entidade.Usuario;
import br.com.fabricadeprogramador.percistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//testeCadastrar();
		//testeAlterar();
		//testeExcluir();
		//testeSalvar();
		//testeBuscarPorId();
		//testeBuscarTodos();
		testeAutenticar();
	}
	
	private static void testeAutenticar() {
		// TODO Auto-generated method stub
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usu = new Usuario();
		
		usu.setLogin("mar");
		usu.setSenha("123");
		
		Usuario usuRetorno = usuarioDAO.autenticar(usu);
		
		System.out.println(usuRetorno);
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
			usuario.setNome("Joãozão da Silva");
			usuario.setLogin("jzaoss");
			usuario.setSenha("12345678");
			
			UsuarioDAO usuDAO = new UsuarioDAO();
			usuDAO.alterar(usuario);
			
			System.out.println("Alterado com Sucesso!!!");
		}
	
	private static void testeCadastrar(){
		
	//criando usuario
		Usuario usuario = new Usuario();
		usuario.setNome("Joãozão");
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
	
	public static void testeBuscarTodos(){
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> listaUsuario = usuarioDAO.buscarTodos();
			
			for(Usuario usuario : listaUsuario)
			System.out.println(usuario);
	}

}
