package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/login?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "natan07149";
	
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}
	
	public String logar(String usuario, String senha) {
		String listar = "Select * from usuarios;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(listar);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(usuario) && rs.getString(2).equals(senha)) {
						String tipo = rs.getString(3);
						return tipo;
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}
	
	public void addUsuario(String usuario, String senha, String tipo) {
		String add = "insert into usuarios (usuario, senha, tipo) values(?, ?, ?);";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(add);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			pst.setString(3, tipo);
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
}
