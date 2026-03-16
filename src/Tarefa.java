public class Tarefa {
    private String descricao;
    private String status;
    private int id;

    public Tarefa (String descricao, String status, int id){
        this.descricao = descricao;
        this.status = status;
        this.id = id;
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
    public int getId() {
        return id;
    }
    public void setStatus(int id) {
        this.id = id;
    }



    @Override
    public String toString(){
        return descricao+" "+"("+status+")";
    }
}