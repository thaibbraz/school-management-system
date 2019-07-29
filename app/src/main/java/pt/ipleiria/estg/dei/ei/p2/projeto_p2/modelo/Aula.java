package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Aula extends Identificador{

private Horario horario;
private Professor professor;
private String sumario;
private LinkedList<Aluno> alunos;
private Sala sala;



    public Aula(String nome,long numero, Horario horario,Sala sala){

        this(nome,numero,null,new LinkedList<Aluno>(),horario,sala);
    }

    public Aula(String nome, long numero, Professor professor, LinkedList<Aluno> alunos, Horario horario,Sala sala) {
        super(nome,numero);
        this.sumario = "";
        //this.professor = professor;
        setProfessor(professor);
        this.alunos = new LinkedList<>();
        this.horario = horario;
        setSala(sala);
        for(Aluno aluno : alunos){
            adicionar(aluno);
        }

    }

    public Sala getSala() {
        return sala;
    }

    public Horario getHorario() {
        return horario;
    }

    public void atribuir(Professor professor){
        this.professor = professor;
        professor.adicionar(this);

}
public void adicionarLinhaSumario(String linha){
    StringBuilder sb = new StringBuilder(sumario);
    sb.append(linha).append("\n");
    sumario = sb.toString();

}

public void adicionar(Aluno aluno){
    if(alunos == null || alunos.contains(aluno)){
        return;
    }
    alunos.add(aluno);
}
    //setters and getters

    public String getNome() {
        return nome;
    }

    public long getNumero() {
        return numero;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getSumario() {
        return sumario;
    }

    public void setProfessor(Professor professor) {

      if(professor == null || this.professor == professor){
          return;
      }
      if(this.professor != null){
          this.professor.remover(this);
      }
        this.professor = professor;
        this.professor.adicionar(this);
    }



    public void desassociarProfessor(){
        if(professor == null){
            return;
        }
        Professor professorARemover = professor;
        professor = null;
        professorARemover.remover(this);
    }
    public void remover(Aluno aluno){
        if(!alunos.contains(aluno)){
            return;
        }
        alunos.remove(aluno);
    }

    public LinkedList<Aluno> getAlunos() {
        return new LinkedList<>(alunos);
    } //retorna lista de alunos

    //atribui e desassocia sala
    public void setSala(Sala sala) {
        if(sala == null || this.sala == sala){
            return;
        }
        if(this.sala !=null){
            this.sala.remover(this);
        }
        this.sala = sala;
        sala.adicionar(this);
    }

    public void desassociarSala() {
        if(sala == null){
            return;
        }
        Sala salaAeliminar = sala;
        sala = null;
        salaAeliminar.remover(this);
    }


    @Override
    public String toString() {
        return  nome + " ("+this.getNumero()+ ")"+ "\n" + sala;
    }
}