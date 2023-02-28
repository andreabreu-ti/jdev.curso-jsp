package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

	private static String banco = "jdbc:postgresql://localhost:5432/jdev.cursojsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "alfa.123";
	private static Connection connection = null;
	
	static {
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
	}
	
}
