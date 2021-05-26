package mx.ipn.curso.ejercicios;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionDataSource {
	
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	static {
        try {
            cpds.setDriverClass("org.postgresql.Driver");
            cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/capacita");
            cpds.setUser("postgres");
            cpds.setPassword("postgres");
            cpds.setMinPoolSize(5);                                     
            cpds.setAcquireIncrement(5);
            cpds.setMaxPoolSize(20);
        } catch (PropertyVetoException e) {
            // handle the exception
        }
    }

	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
	
	private ConnectionDataSource() {
		
	}
	
	public static void close() {
		cpds.close();
	}
}
