import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        Scanner input = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO(conexao);
        Menu.menu();

        int opcao;
        do {
            Menu.menu();

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
            }
        } while (opcao != 5);

    }
}
