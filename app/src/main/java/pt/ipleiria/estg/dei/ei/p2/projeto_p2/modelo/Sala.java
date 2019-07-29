package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas {

    private LinkedList<Aula> aulas;

    public Sala(String nome,boolean aberta) {

        this(nome,new LinkedList<Aula>(),false);
    }

    public Sala(String nome, LinkedList<Aula> aulas, boolean aberta) {
        super(nome,aberta);
        this.aulas = new LinkedList<>();
        for(Aula aula: aulas){
            adicionar(aula);
        }

    }

    @Override
    public void adicionar(Aula aula) {
    if(aula == null || aulas.contains(aula)){
        return;
        }
    aulas.add(aula);
    aula.setSala(this);
    }
    @Override
    public void remover(Aula aula) {
        if (!aulas.contains(aula)) {
        return;
        }
        aulas.remove(aula);
        aula.desassociarSala();

    }




    @Override
    public LinkedList<Aula> getAulas() {

        return new LinkedList<>(aulas);
    }

    @Override
    public String toString() {
        return getNome().toString();
    }

}
