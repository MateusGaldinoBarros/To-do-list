import java.util.ArrayList;

public class GerenciadorDeTarefa {
    public void getMenu() {
        System.out.println("\n-------MENU-------");
        System.out.println("1.Adicionar Tarefa");
        System.out.println("2.Remover Tarefa");
        System.out.println("3.Alterar Tarefa");
        System.out.println("4.Mostrar Tarefas");
        System.out.println("5.Sair\n");
    }

    public void getMenuStatus(boolean avancado) {

        System.out.println("1.Não feita");
        System.out.println("2.Em andamento");
        System.out.println("3.Concluida");

        if (avancado) {
            System.out.println("4.todas as tarefas");
        }


    }

    public void getTarefas(ArrayList<Tarefa> tarefas) {
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println((i + 1) + "." + tarefas.get(i));
        }
    }


    public void adicionarTarefa(ArrayList<Tarefa> tarefas, int escolha, String status, String descricao) {
        if (escolha == 1) {
            status = "Não feita";
        } else if (escolha == 2) {
            status = "Em andamento";
        } else if (escolha == 3) {
            status = "Concluida";
        }

        Tarefa t = new Tarefa(descricao, status);

        tarefas.add(t);
        System.out.println("Tarefa adicionada com sucesso!\n");
        this.getTarefas(tarefas);
    }

    public void removerTarefa(ArrayList<Tarefa> lista, int escolha, ArrayList<Tarefa> tarefas) {

        if (lista.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada\n");
        } else if (escolha < 1 || escolha > lista.size()) {
            System.out.println("Nenhuma tarefa encontrada\n");
        } else {
            Tarefa paraRemover = lista.get(escolha-1);
            tarefas.remove(paraRemover);
            lista.remove(paraRemover);
            System.out.println("Tarefa removida com sucesso!\n");
        }
        this.getTarefas(lista);
    }

    public void validarEscolha(ArrayList<Tarefa> lista, int escolha) {
        if (lista.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada\n");
        } else if (escolha < 1 || escolha > lista.size()) {
            System.out.println("Nenhuma tarefa encontrada\n");
            return;
        }


        System.out.println("Qual o novo Status da tarefa?");
        this.getMenuStatus(false);
    }

    public void alterarTarefa(ArrayList<Tarefa> Tarefas, int escolhaStatus, Tarefa NovoStatus) {

        switch (escolhaStatus) {
            case 1:
                NovoStatus.setStatus("Não feita");
                break;
            case 2:
                NovoStatus.setStatus("Em andamento");
                break;
            case 3:
                NovoStatus.setStatus("Concluida");
                break;
            default:
                System.out.println("Opção invalida\n");
        }
        System.out.println("Tarefa alterada com sucesso!\n");
        this.getTarefas(Tarefas);
    }

    public void mostrarFiltradas(ArrayList<Tarefa> tarefas, ArrayList<Tarefa> filtradas, String statusFiltrado) {
        if(statusFiltrado.isEmpty()) {
            filtradas.addAll(tarefas);
        }else {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getStatus().equalsIgnoreCase(statusFiltrado)) {
                    filtradas.add(tarefa);
                }
            }
        }
        this.getTarefas(filtradas);
    }
    public String validarStatus(int escolha, String statusFiltrado){
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
        return statusFiltrado;
    }
}
