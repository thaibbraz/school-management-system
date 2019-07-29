package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Aluno extends PessoaComAulas{

    public Aluno(String nome, long numero) {
        this(nome,numero,new LinkedList<Aula>());
    }
    public Aluno(String nome, long numero,LinkedList<Aula> aulas) {
        super(nome,numero,aulas);
    }

    @Override
    protected void associar(Aula aula) {
        aula.adicionar(this);
    }

    @Override
    protected void desassociar(Aula aula) {
    aula.remover(this);
    }

    @Override
    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(nome);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasSobrepostas = new LinkedList<>();

        for(Aula aula: aulas){
            if(aula.getHorario().isSobreposto(horario)){
                aulasSobrepostas = this.aulas;
            }
        }
        return aulasSobrepostas;
    }
    @Override
    public String toString() {
        return  nome +" ("+ String.valueOf(numero)+ ")";
    }
}
