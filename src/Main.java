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
                case 1: {
                    System.out.println("Qual tarefa você quer adicionar? ");
                    String tarefa = input.nextLine();
                    System.out.println("Qual o status da tarefa? ");
                    System.out.print("1.Concluida\n2.Em andamento\n3.Não feita");
                    opcao = input.nextInt();

                    String status = "";

                    if (opcao == 1) {
                        status = "Concluida";
                    } else if (opcao == 2) {
                        status = "Em andamento";
                    }else if (opcao == 3) {
                        status = "Não feita";
                    }else {
                        System.out.println("Opção invalida");
                        return;
                    }

                    Tarefa t = new Tarefa(tarefa, status);

                    dao.adicionar(t);
                    break;
                } case 2: {

                }
            }
        } while (opcao != 5);

    }
}
