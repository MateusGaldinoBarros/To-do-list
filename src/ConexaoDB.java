import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {
    private static final String URL = "jdbc:mysql://localhost:3306/to_do_list";
    private static final String USUARIO = "root";
    private static final String SENHA = "2024";

    //Parte do codigo responsavel por guardar as credenciais do banco de dados que vai ser utilizado

    public static Connection conectar() {
        try {
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA); //Cria uma variavel de conexão que utiliza o DriverManager para estabelecer um canal de comunicação entre o java e o MySQL
            System.out.println("Conectado ao banco");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage()); //Executa em caso de o java não conseguir se conectar com sucesso mostrando o erro
            return null;
        }
    }
}
