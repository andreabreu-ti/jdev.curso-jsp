package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

//	private static String banco = "jdbc:postgresql://localhost:5432/jdev.cursojsp?autoReconnect=true";
	private static String banco = "jdbc:sqlserver://localhost:1433;databaseName=jdev-curso-jsp;integratedSecurity=false;encrypt=true;trustServerCertificate=true;";
	private static String user = "jdev";
	private static String senha = "123456";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {
		conectar();
	}
	
	public SingleConnectionBanco() { //Quando tiver uma instância vai conectar
		conectar();
	}
	
	
	private static void conectar() {
		try {
			if(connection == null) {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Carrega o drive de conexão do banco
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);//Para não efetuar alterações no banco sem nosso comando.
			}
		} catch (Exception e) {
			e.printStackTrace(); //Mostrar qualquer erro no momento de conectar
		}
	}
	
	/*static {
		conectar();
	}
	
	public SingleConnectionBanco() { //QUando tiver uma instância vai conectar
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");//Carrega o drive de conexão do banco
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);//Para não efetuar alteraçoes no banco sem nosso comando.
			}
			
		} catch (Exception e) {
			e.printStackTrace();//Mostrar qualquer erro no momento de conectar
		}
	}

	public static Connection getConnection() {
		return connection;
	}*/
	
}
