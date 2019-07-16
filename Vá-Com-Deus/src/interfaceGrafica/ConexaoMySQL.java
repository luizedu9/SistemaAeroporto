package interfaceGrafica;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConexaoMySQL {

	public static boolean pesquisaSQL(String companhia, String usuario, String senha) {
		try {
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/loginVaComDeus", "root", "root");
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery("select senha from login where companhia='" + companhia + "' and usuario='" + usuario + "';");
			rs.next();
			if (senha.equals(rs.getString(1))) {
				rs.close();
				conn.close();
				return(true);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO - SQL: " + e.getMessage());
		}
		return(false);
	}
	
	public static boolean insereSQL(String companhia, String nome, String usuario, String senha) {
		try {
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/loginVaComDeus", "root", "root");
			PreparedStatement psInsert = conn.prepareStatement("insert into login" + "(companhia, nome, usuario, senha)" + "values(?,?,?,?)");
			psInsert.setString(1, companhia);
			psInsert.setString(2, nome);
			psInsert.setString(3, usuario);
			psInsert.setString(4, senha);
			psInsert.execute();
			conn.close();
			psInsert.close();
			return(true);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "ERRO - SQL: " + e.getMessage());
		}
		return(false);
	}	
	
}