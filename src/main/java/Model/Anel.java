package Model;

public class Anel {

    private String nome;
    private String efeito;
    private String local;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEfeito() {
        return efeito;
    }

    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Anel{" +
                "Nome='" + nome + '\'' +
                ", Efeito='" + efeito + '\'' +
                ", Localizacao='" + local + '\'' +
                '}';
    }
}
