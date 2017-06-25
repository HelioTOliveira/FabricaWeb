package br.com.fabricadeprogramador.percistencia.jdbc;

import java.sql.Connection;
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

}
