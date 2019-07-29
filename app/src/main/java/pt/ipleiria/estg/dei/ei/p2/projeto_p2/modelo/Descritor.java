package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

public abstract class Descritor {
    private String nome;

    public Descritor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
