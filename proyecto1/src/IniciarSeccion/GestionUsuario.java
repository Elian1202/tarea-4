package IniciarSeccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import IniciarSeccion.Usuarios;
import ventana.login;

public class GestionUsuario {
	
	public Usuarios obtenerUsuario(Usuarios usu) {
		
		Usuarios usuario = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			
			con = login.con;
			
			String sql = "select*from usuarios where usuario =? and Contraseña =?";
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, usu.getUsuario());
			pst.setString(2, usu.getContraseña());
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				usuario = new Usuarios(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				
			}
			
		}catch(Exception e) {
			System.out.println("Error en obtener usuario");
		}
		
		
		
		
		
		return usuario;
	}


}
