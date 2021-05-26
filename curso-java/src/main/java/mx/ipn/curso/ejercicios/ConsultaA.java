package mx.ipn.curso.ejercicios;

import java.io.*;
import java.sql.*;

public class ConsultaA implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main ( String args[] )	{
		try	{
			Connection connection = ConnectionDataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM Empleado");
			ResultSet resulset = statement.executeQuery();
			String result = new String();
			while(resulset.next())	{
				result += resulset.getInt(1);
				result += "\t";
				result += resulset.getString(2);
				result += "\t";
				result += resulset.getString(3);
				result += "\t"; 
				System.out.println(result);
				result = "";
			}
			connection.close();
			ConnectionDataSource.close();
		}
		catch(SQLException e)	{
			while (e != null)	{
				System.out.println("SQL Excepcion " + e.getMessage());
				System.out.println("SQL State: " + e.getSQLState());
				System.out.println("VendorError: " + e.getErrorCode());
				e = e.getNextException();
			}
		}
		catch(Exception e)	{
			System.out.println("generic Exception " +e.toString());
			e.printStackTrace();
		}
	}
}