import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String []args){
        Connection conexao = ConexaoDB.conectar();

        GerenciadorDeTarefa gerenciador = new GerenciadorDeTarefa();
        Scanner input = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int escolha,escolhaStatus;
        Tarefa novoStatus;



        while(true){
            gerenciador.getMenu();
            String opcao = input.nextLine();

            switch(opcao){
                case "1":
                    String status = "";
                    System.out.println("Qual tarefa deseja adicionar?");
                    String descricao = input.nextLine();

                    System.out.println("Qual o status da tarefa?");

                    gerenciador.getMenuStatus(false);
                    escolha = input.nextInt();
                    input.nextLine();

                    gerenciador.adicionarTarefa(tarefas,escolha,status,descricao);
                    break;

                case "2":
                    gerenciador.getTarefas(tarefas);

                    System.out.println("Qual tarefa deseja remover?");
                    escolha = input.nextInt();
                    input.nextLine();

                    gerenciador.removerTarefa(tarefas,escolha,tarefas);
                    break;

                case "3":
                    gerenciador.getTarefas(tarefas);
                    System.out.println("Qual tarefa deseja alterar?");
                    escolha = input.nextInt();
                    input.nextLine();

                    gerenciador.validarEscolha(tarefas,escolha);
                    escolhaStatus = input.nextInt();
                    input.nextLine();

                    novoStatus = tarefas.get(escolha-1);

                    gerenciador.alterarTarefa(tarefas,escolhaStatus,novoStatus);
                    break;

                case "4":
                    System.out.println("Quais tarefas deseja mostrar? ");
                    gerenciador.getMenuStatus(true);
                    escolha = input.nextInt();
                    input.nextLine();
                    String statusFiltrado = "";

                    gerenciador.validarStatus(escolha,statusFiltrado);

                    ArrayList<Tarefa> filtradas = new ArrayList<>();
                    gerenciador.mostrarFiltradas(tarefas,filtradas,statusFiltrado);

                    System.out.println("Deseja alterar alguma tarefa? (S/N) ");
                    String resposta = input.nextLine();

                    if(resposta.equalsIgnoreCase("S")){
                        System.out.println("Qual a alteração");
                        System.out.println("1.Remover Tarefa");
                        System.out.println("2.Alterar Tarefa");
                        escolha = input.nextInt();

                        switch (escolha) {
                            case 1:
                                gerenciador.getTarefas(filtradas);
                                gerenciador.removerTarefa(filtradas,escolha,tarefas);
                                break;
                            case 2:
                                gerenciador.getTarefas(filtradas);
                                System.out.println("Qual tarefa deseja alterar?");
                                escolha = input.nextInt();
                                input.nextLine();

                                gerenciador.validarEscolha(filtradas,escolha);
                                escolhaStatus = input.nextInt();
                                input.nextLine();

                                novoStatus = filtradas.get(escolha-1);
                                gerenciador.alterarTarefa(filtradas,escolhaStatus,novoStatus);

                        }
                    }else if(resposta.equalsIgnoreCase("N")){
                        break;
                    }else {
                        System.out.println("Opção invalida");
                        break;
                    }
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Opção invalida");
                    break;

            }
        }
    }
}