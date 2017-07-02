package br.com.fabricadeprogramador.percistencia.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.fabricadeprogramador.percistencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();
	public void cadastra(Usuario usuario) {
		// TODO Auto-generated method stub
		
		String sql="insert into usuario(nome, login, senha)"+
		"values(?, ?, ?)";
		
		try (PreparedStatement preparador =  (PreparedStatement) con.prepareStatement(sql)){
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void alterar(Usuario usuario) {
		// TODO Auto-generated method stub
		
		String sql="update usuario set nome=?, login=?, senha=? where id_usuario=?";
				
		try (PreparedStatement preparador =  (PreparedStatement) con.prepareStatement(sql)){
			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getIdUsuario());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void excluir(Usuario usuario) {
		// TODO Auto-generated method stub
	
		String sql="delete from usuario where id_usuario=?";
		
		try (PreparedStatement preparador =  (PreparedStatement) con.prepareStatement(sql)){
			
			preparador.setInt(1, usuario.getIdUsuario());
			
			preparador.execute();
			preparador.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
	
	public void salvar(Usuario usuario){
		if(usuario.getIdUsuario() != 0){
			alterar(usuario);
			
		}else{
			cadastra(usuario);
		}
	}
	/**
	 * Busca de um registro no banco de dados pelo número do id do usuário
	 * @param id E um inteiro que representa o número do id do usuário a ser buscado
	 * @return Um objeto usuário quando encontrado ou null quando não encontrado
	 */
	
	public Usuario buscaPorId(Integer id){
		
		String sql = "select *from usuario where id_usuario=?";
		
		try(PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql)){
			
			preparador.setInt(1,id);
			ResultSet resultado =  preparador.executeQuery();
			// posicionando o cursor no primeiro registro
			if(resultado.next()){
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
		
		return null;
		
	}
	/**
	 * Realiza a busca de todos registro da tabela usuário
	 * @return uma lista de objetos Usuarios contendo 0 elementos quando não tiver registro ou n elementos
	 * quando tiver resultado
	 */
	public List<Usuario> buscarTodos(){
		
		String sql = "Select *from usuario";
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try (PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql)){
			
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()){
				Usuario usuairo = new Usuario();
				usuairo.setIdUsuario(resultado.getInt("id_usuario"));
				usuairo.setNome(resultado.getString("nome"));
				usuairo.setLogin(resultado.getString("login"));
				usuairo.setSenha(resultado.getString("senha"));
				
				listaUsuario.add(usuairo);
			}
			return listaUsuario;
		}catch(SQLException e){
				e.printStackTrace();
		 }		
		return null;
	}
	
	public Usuario autenticar(Usuario usuConsulta){
		
		String sql ="Select *from usuario where login=? and senha=?";
		
		try (PreparedStatement preparador = (PreparedStatement) con.prepareStatement(sql)){
			
			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());
			
			ResultSet resultado = preparador.executeQuery();
			
			if(resultado.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(resultado.getInt("id_usuario"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
		return null;
	}

}
