import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        Scanner input = new Scanner(System.in);
        TarefaDAO dao = new TarefaDAO(conexao);


        int opcao;
        do {
            Menu.menu();

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Qual tarefa você quer adicionar? ");

                    String tarefa = input.nextLine();

                    if(tarefa.isEmpty()) {
                        System.out.println("Opção invalida");
                        break;
                    }

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
                        break;
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

                    boolean encontrou = false;

                    for (Tarefa t: tarefas) {
                        if (t.getId() == opcao) {
                            encontrou = true;
                            break;
                        }
                    }

                    if(!encontrou) {
                        System.out.println("ID não encontrado");
                        break;
                    }

                    Tarefa t = new Tarefa();
                    t.setId(opcao);

                    dao.remover(t);

                    break;

                } case 3: {
                    ArrayList<Tarefa> tarefas = dao.listar();

                    for (Tarefa tarefa : tarefas) {
                        System.out.println(tarefa.getId()+"."+tarefa);
                    }

                    System.out.println("Qual o id da tarefa que você deseja alterar?");

                    opcao = input.nextInt();

                    boolean encontrou = false;

                    for (Tarefa t: tarefas) {
                        if (t.getId() == opcao) {
                            encontrou = true;
                        }
                    }

                    if(!encontrou) {
                        System.out.println("ID não encontrado");
                        break;
                    }
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
                        break;
                    }

                    Tarefa t = new Tarefa();
                    t.setId(opcao);
                    t.setStatus(status);

                    dao.alterar(t);

                    break;

                } case 4: {
                    ArrayList<Tarefa> tarefas = dao.listar();

                    for(Tarefa tarefa: tarefas ) {
                        System.out.println(tarefa.getId()+"."+tarefa);
                    }
                    break;
                }

            }
        } while (opcao != 5);

    }
}
