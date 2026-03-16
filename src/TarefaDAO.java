import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;


public class TarefaDAO {
    private Connection conexao;

    public TarefaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionar(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas (descricao, status) VALUES (?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, tarefa.getDescricao());
            stmt.setString(2, tarefa.getStatus());
            stmt.executeUpdate();
        }catch (SQLException e) {
            System.out.println("Erro ao adicionar: "+e.getMessage());
        }
    }

    public void remover (Tarefa tarefa) {
        String sql = "DELETE FROM tarefas WHERE id = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, tarefa.getId());
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
        ArrayList<Tarefa> tarefas = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Tarefa t = new Tarefa(rs.getString("descricao"), rs.getString("status"));
                t.setId(rs.getInt("id"));
                tarefas.add(t);
            }

        }catch (SQLException e) {
            System.out.println("Erro ao listar "+e.getMessage());
        }
        return tarefas;
    }
}
