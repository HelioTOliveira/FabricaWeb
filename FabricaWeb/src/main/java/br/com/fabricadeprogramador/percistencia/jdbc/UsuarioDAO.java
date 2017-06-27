package br.com.fabricadeprogramador.percistencia.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	 * Busca de um registro no banco de dados pelo n�mero do id do usu�rio
	 * @param id E um inteiro que representa o n�mero do id do usu�rio a ser buscado
	 * @return Um objeto usu�rio quando encontrado ou null quando n�o encontrado
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

}
