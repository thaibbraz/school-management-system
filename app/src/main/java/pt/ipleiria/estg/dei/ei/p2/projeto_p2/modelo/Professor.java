package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario<GabineteProfessor,Sala>{
    private GabineteProfessor gabineteProfessor;
    private LinkedList<Horario> horarioAtendimento;


    public Professor(String nome, long numero,GabineteProfessor gabineteProfessor) {
        super(nome,numero, new LinkedList<Aula>());
        setGabinete(gabineteProfessor);
        horarioAtendimento = new LinkedList<>();
    }


    @Override
    protected void associar(Aula aula) {
        aula.setProfessor(this);

    }


    @Override
    protected void desassociar(Aula aula) {
    aula.desassociarProfessor();
    }

    @Override
    protected void escreverSumario(Aula aula){
        aula.adicionarLinhaSumario(aula.getNome());
        aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
        aula.adicionarLinhaSumario(nome);

        for (Aluno aluno : aula.getAlunos()){
            aluno.escreverSumario(aula);
            }
    }


    public LinkedList<Aula> getAulas(Horario horario) {
        LinkedList<Aula> aulasHorario = new LinkedList<>();

       for(Aula aula :aulas) {
            if(aula.getHorario().isSobreposto(horario)){
                aulasHorario = this.aulas;
            }
       }
    return aulasHorario;

    }

    @Override
    public void setGabinete(GabineteProfessor gabinete) {
        if(gabinete == null || this.gabineteProfessor == gabinete){
            return;
        }
        if (this.gabineteProfessor != null){
           this.gabineteProfessor.remover(this);
        }
        this.gabineteProfessor = gabinete;
        gabinete.adicionar(this);

    }

    @Override
    public GabineteProfessor getGabinete() {
        return gabineteProfessor;
    }

    @Override
    public void desassociarGabinete() {
        if(gabineteProfessor == null){
            return;
        }
        GabineteProfessor gabineteARemover = gabineteProfessor;
        gabineteProfessor = null;
        gabineteARemover.remover(this);


    }

    @Override
    public void abrirSala(Sala sala) {
        if(sala.isAberta()){
            return;
        }
        sala.abrir();
    }

    @Override
    public void fecharSala(Sala sala) {
        if(!sala.isAberta()){
            return;
        }
        sala.fechar();
    }

    @Override
    public void abrirGabinete() {
       if(gabineteProfessor.isAberta()){
           return;
       }
       gabineteProfessor.abrir();
    }

    @Override
    public void fecharGabinete() {
        if(!gabineteProfessor.isAberta()){
            return;
        }
        gabineteProfessor.fechar();

    }

    @Override
    public LinkedList<Horario> getHorarioAtendimento() {
        return horarioAtendimento;
    }


    public void adicionar(Horario horarioAtendimento){

    }
    public void remover(Horario horarioAtendimento){

    }
}
