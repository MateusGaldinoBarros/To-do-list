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
                    Tarefa t = null;
                    for (Tarefa tarefa: tarefas) {
                        if (tarefa.getId() == opcao) {
                            encontrou = true;
                            t= tarefa;
                            break;
                        }
                    }

                    if(!encontrou) {
                        System.out.println("ID não encontrado");
                        break;
                    }

                    System.out.println(t);
                    System.out.println("Tem certeza que deseja remover essa tarefa? (y/n)");
                    String resposta;
                    resposta = input.nextLine();
                    if (resposta.equals("y")|| resposta.equals("Y")) {
                        dao.remover(t);
                    }else {
                        break;
                    }



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
                    System.out.println("Quais tarefas deseja listar?");
                    System.out.println("1.Todas\n2.Concluidas\n3.Em andamento\n4.Não feitas");

                    opcao = input.nextInt();
                    input.nextLine();

                    if (opcao == 1) {
                        ArrayList<Tarefa> tarefas = dao.listar();

                        for(Tarefa tarefa: tarefas ) {
                            System.out.println(tarefa.getId()+"."+tarefa);
                        }
                    }else if(opcao == 2) {
                        Tarefa t = new Tarefa();
                        t.setStatus("Concluida");

                        ArrayList<Tarefa> tarefas = dao.filtro(t);

                        for(Tarefa tarefa: tarefas ) {
                            System.out.println(tarefa.getId()+"."+tarefa);
                        }
                    }else if (opcao == 3) {
                        Tarefa t = new Tarefa();
                        t.setStatus("Em andamento");

                        ArrayList<Tarefa> tarefas = dao.filtro(t);

                        for(Tarefa tarefa: tarefas ) {
                            System.out.println(tarefa.getId()+"."+tarefa);
                        }
                    } else if (opcao == 4) {
                        Tarefa t = new Tarefa();
                        t.setStatus("Não feita");

                        ArrayList<Tarefa> tarefas = dao.filtro(t);

                        for(Tarefa tarefa: tarefas ) {
                            System.out.println(tarefa.getId()+"."+tarefa);
                        }
                    }


                    break;
                }
                

            }
        } while (opcao != 5);

    }
}
