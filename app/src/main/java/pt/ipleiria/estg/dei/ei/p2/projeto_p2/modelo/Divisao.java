package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

public class Divisao extends Descritor {
    private boolean aberta;
    public Divisao(String nome,boolean aberta) {
        super(nome);
        this.aberta = aberta;
    }
    public boolean isAberta(){
        return aberta;
    }
    public void abrir(){
        aberta= true;
    }
    public void fechar(){
        aberta=false;
    }
}
