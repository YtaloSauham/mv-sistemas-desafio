package persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conexao;
    String user = "dev";
    String password = "1234";
    public Connection getConnection() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", user,
                        password);
            } else {
                return conexao;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível realizar a conexão. Erro: " + e.getMessage());
        }
        return conexao;
    }

    public void closeConnection() {
        try {
            this.conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }


}
