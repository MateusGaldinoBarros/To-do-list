import java.sql.Connection;
import java.util.ArrayList;
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
                    ArrayList<Tarefa> tarefas = dao.listar();

                    for (Tarefa tarefa : tarefas) {
                        System.out.println(tarefa.getId()+"."+tarefa);
                    }

                    System.out.println("Qual o id da tarefa que deseja remover? ");

                    opcao = input.nextInt();
                    input.nextLine();

                    Tarefa t = new Tarefa();
                    t.setId(opcao);

                    dao.remover(t);

                } case 3: {
                    ArrayList<Tarefa> tarefas = dao.listar();

                    for (Tarefa tarefa : tarefas) {
                        System.out.println(tarefa.getId()+"."+tarefa);
                    }

                    System.out.println("Qual o id da tarefa que você deseja alterar?");

                    opcao = input.nextInt();
                    input.nextLine();

                    System.out.println("Qual o novo status da tarefa?");
                    System.out.print("1.Concluida\n2.Em andamento\n3.Não feita");

                    int opcao2 = input.nextInt();
                    String status = "";

                    if (opcao2 == 1) {
                        status = "Concluida";
                    } else if (opcao2 == 2) {
                        status = "Em andamento";
                    }else if (opcao2 == 3) {
                        status = "Não feita";
                    }else {
                        System.out.println("Opção invalida");
                        return;
                    }

                    Tarefa t = new Tarefa();
                    t.setId(opcao);
                    t.setStatus(status);

                    dao.alterar(t);

                } case 4: {
                    ArrayList<Tarefa> tarefas = dao.listar();

                    for(Tarefa tarefa: tarefas ) {
                        System.out.println(tarefa.getId()+"."+tarefa);
                    }

                }

            }
        } while (opcao != 5);

    }
}
