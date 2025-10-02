import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String []args){
        GerenciadorDeTarefa gerenciador = new GerenciadorDeTarefa();
        Scanner input = new Scanner(System.in);
        ArrayList<Tarefa> tarefas = new ArrayList<>();
        int escolha = 0;


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

                    gerenciador.removerTarefa(tarefas,escolha,input,tarefas);
                    break;

                case "3":
                    gerenciador.getTarefas(tarefas);
                    System.out.println("Qual tarefa deseja alterar?");
                    escolha = input.nextInt();
                    input.nextLine();

                    gerenciador.validarEscolha(tarefas,escolha);
                    int escolhaStatus = input.nextInt();
                    input.nextLine();

                    Tarefa novoStatus = tarefas.get(escolha-1);

                    gerenciador.alterarTarefa(tarefas,escolhaStatus,novoStatus);
                    break;

                case "4":
                    System.out.println("Quais tarefas deseja mostrar? ");
                    gerenciador.getMenuStatus(true);
                    escolha = input.nextInt();
                    input.nextLine();
                    String statusFiltrado;

                    switch(escolha){
                        case 1-> statusFiltrado = "Não feita";
                        case 2-> statusFiltrado = "Em andamento";
                        case 3-> statusFiltrado = "Concluida";
                        case 4-> statusFiltrado = "";
                        default-> {
                            statusFiltrado = null;
                            System.out.println("Opção invalida");
                        }

                    }
                    ArrayList<Tarefa> filtradas = new ArrayList<>();
                    gerenciador.mostrarFiltradas(tarefas,filtradas,statusFiltrado);

                    System.out.println("Deseja alterar alguma tarefa? (S/N) ");
                    String resposta = input.nextLine();

                    if(resposta.equalsIgnoreCase("S")){
                        gerenciador.alterarOuRemover(tarefas,escolha,input,filtradas);
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