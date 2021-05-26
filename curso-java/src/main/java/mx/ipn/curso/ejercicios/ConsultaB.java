package mx.ipn.curso.ejercicios;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		try {
			Connection connection = ConnectionDataSource.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("SELECT SUM(importe_costo) FROM Departamento, Empleado, Curso, Emp_Curso "
							+ " WHERE Departamento.cve_depto	= Empleado.cve_depto"
							+ " AND Empleado.cve_emp			= Emp_Curso.cve_emp"
							+ " AND Curso.cve_curso				= Emp_Curso.cve_curso"
							+ " AND Departamento.descrip_depto=?");
			statement.setString(1, "produccion");
			ResultSet resulset = statement.executeQuery();
			String result = new String();
			while (resulset.next()) {
				result += resulset.getInt(1);
				result += "\t";
				System.out.println(result);
				result = "";
			}
			connection.close();
			ConnectionDataSource.close();
		} catch (SQLException e) {
			while (e != null) {
				System.out.println("SQL Excepcion " + e.getMessage());
				System.out.println("SQL State: " + e.getSQLState());
				System.out.println("VendorError: " + e.getErrorCode());
				e = e.getNextException();
			}
		} catch (Exception e) {
			System.out.println("generic Exception " + e.toString());
			e.printStackTrace();
		}
	}
}