import java.sql.*;
import java.util.ArrayList;


public class TarefaDAO {
    private Connection conexao;

    public TarefaDAO(Connection conexao) {
        this.conexao = conexao;
    } //Estabelece a conexão com o banco de dados usando o DriverManager

    public void adicionar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (descricao, status) VALUES (?,?)"; //Guarda a query sql em uma string

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);  //Usa a conexão para mandar a string para o MySQL e informa que vai usa-la
            stmt.setString(1, tarefa.getDescricao());  //Usa o objeto enviado como parametro para comunicar quais os valores que vão ser enviados para o sql para preencher as lacunas
            stmt.setString(2, tarefa.getStatus());
            stmt.executeUpdate(); //Executa o update (Cria uma tarefa nova no banco de dados
        }catch (SQLException e) {
            System.out.println("Erro ao adicionar: "+e.getMessage()); //Pega o erro em caso de não conseguir adicionar
        }
    }

    public void remover (Tarefa tarefa) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, tarefa.getId()); //Pega o ID do objeto informado para remover a taefa no banco de dados
            stmt.executeUpdate();
            System.out.println("Tarefa removida com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao remover: "+e.getMessage());
        }
    }

    public void alterar (Tarefa tarefa) {
        String sql = "UPDATE tarefas SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tarefa.getStatus());
            stmt.setInt(2, tarefa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro no alterar "+e.getMessage());
        }
    }

    public ArrayList<Tarefa> listar() {
        String sql = "SELECT * FROM tarefas";
        ArrayList<Tarefa> tarefas = new ArrayList<>();//Cria um arrayList que vai ficar responsavel por guardar os dados enviados pelo sql

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(); //Cria uma variavel que executa a query e retorna dados

            while (rs.next()) { //Passa o cursor no banco de dados e informa se existe mais uma linha no banco de dados
                Tarefa t = new Tarefa(rs.getString("descricao"), rs.getString("status")); // Cria um objeto Tarefa com os valores da linha atual do banco
                t.setId(rs.getInt("id"));
                tarefas.add(t); //Adiciona as tarefas no arrayList
            }

        }catch (SQLException e) {
            System.out.println("Erro ao listar "+e.getMessage());
        }
        return tarefas;
    }

    public ArrayList<Tarefa> filtro(Tarefa tarefa) { //Faz a mesma coisa da função listar porém usa uma linha para definir o status a ser filtrado
        String sql = "SELECT * FROM tarefas WHERE status = ?";
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tarefa.getStatus());
            ResultSet rs = stmt.executeQuery();


            while(rs.next()) {
                Tarefa t = new Tarefa(rs.getString("descricao"), rs.getString("status"));
                t.setId(rs.getInt("id"));
                tarefas.add(t);
            }
        }catch (SQLException e) {
            System.out.println("Erro ao filtrar"+e.getMessage());
        }

        return tarefas;
    }
}
