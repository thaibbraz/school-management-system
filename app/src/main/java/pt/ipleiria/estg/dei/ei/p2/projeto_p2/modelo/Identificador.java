package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

public abstract class Identificador extends Descritor{
    protected String nome;
    protected long numero;

    public Identificador(String nome, long numero) {
        super(nome);
        this.nome = nome;
        this.numero = numero;
    }

    //getters and setters

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }
}
