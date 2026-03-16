import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/to_do_list";
    private static final String USUARIO = "root";
    private static final String SENHA = "2024";

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectado ao banco");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
