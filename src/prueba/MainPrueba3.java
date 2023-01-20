package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
 

public class MainPrueba3 {

	public static void main(String[] args) throws Exception{
		String churro = "[\r\n"
				+ "{\"hora_ini\":\"14:30\",\"hora_fin\":\"16:30\",\"modulo\":\"CFPROJ\",\"curso\":\"ASIX2/DAM2/DAW2\"},\r\n"
				+ "{\"hora_ini\":\"16:30\",\"hora_fin\":\"18:30\",\"modulo\":\"DAMM09\",\"curso\":\"DAM2\"}\r\n"
				+ "]\r\n"
				+ "";
		// Instantiate the Factory
		Class.forName("com.mysql.cj.jdbc.Driver");
		String conex = "jdbc:mysql://localhost:3306/pruebaxml_a_java";
		Connection conexion = DriverManager.getConnection(conex, "root", "");

		/*String sql = "INSERT INT horarios (profe,martes) VALUES (?, ?);";
		
		PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setString(1, "EDUARD");
				sentencia.setString(2, churro);
				System.out.print(sentencia);
				int filas = sentencia.executeUpdate();
				System.out.print("Filas afectadas: " + filas);
		*/
		
         String sql = "SELECT * FROM horarios WHERE profe='EDUARD';";
		
		 Statement sentencia = conexion.createStatement();
		 System.out.print(sentencia);
		 
	     ResultSet rs = sentencia.executeQuery(sql);
	     while ( rs.next() ) {
             String lastName = rs.getString("martes");
             System.out.println(lastName);
         }
			
		sentencia.close();
		conexion.close();
	}
}
