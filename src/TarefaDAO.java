import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
}
