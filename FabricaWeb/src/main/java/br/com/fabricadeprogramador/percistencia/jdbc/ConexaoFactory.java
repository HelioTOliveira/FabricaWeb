package br.com.fabricadeprogramador.percistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoFactory {

	public static Connection getConnection() {
		// TODO Auto-generated method stub
		
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/fabricaweb", "root", "root1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
