package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Pessoa implements RepositorioAulas{
    protected LinkedList<Aula> aulas;
    public PessoaComAulas(String nome, long numero,LinkedList<Aula> aulas) {

        super(nome, numero);
        this.aulas = new LinkedList<>();

        for(Aula aula: aulas)
            adicionar(aula);
    }

    @Override
    public void adicionar(Aula aula) {
        if (aula == null || aulas.contains(aula)) {
            return;
        }
        aulas.add(aula);
        associar(aula);
    }

    @Override
    public void remover(Aula aula) {
        if (!aulas.contains(aula)) {
            return;
        }
        aulas.remove(aula);
        desassociar(aula);
    }

    @Override
    public LinkedList<Aula> getAulas() {
        return aulas;
    }

    protected abstract void associar(Aula aula);
    protected abstract void desassociar(Aula aula);

    protected void escreverSumario(Aula aula){
        assinarSumario(aula);
    }

    protected void assinarSumario(Aula aula) {
        aula.adicionarLinhaSumario(nome);
    }

    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> resultado = new LinkedList<>();
        for (Aula aula:aulas){
            if (aula.getHorario().isSobreposto(horario)){
                resultado.add(aula);
            }
        }
        return resultado;
    }






}
