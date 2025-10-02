public class Tarefa {
    private String descricao;
    private String status;

    public Tarefa (String descricao, String status){
        this.descricao = descricao;
        this.status = status;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString(){
        return descricao+" "+"("+status+")";
    }
}