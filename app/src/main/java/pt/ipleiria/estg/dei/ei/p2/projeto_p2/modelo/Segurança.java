package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Segurança extends Pessoa implements Funcionario <GabineteSegurança,Sala>{
    private GabineteSegurança gabineteSeguranca;
    private LinkedList<Horario> horarioAtendimento;

    public Segurança(String nome, long numero,GabineteSegurança gabineteSeguranca) {
        super(nome, numero);
        setGabinete(gabineteSeguranca);
        horarioAtendimento = new LinkedList<>();
    }

    @Override
    public LinkedList<Horario> getHorarioAtendimento() {
        return horarioAtendimento;
    }

    @Override
    public void setGabinete(GabineteSegurança gabineteSeguranca){
        if(gabineteSeguranca == null || this.gabineteSeguranca==gabineteSeguranca)
        {
            return;
        }
        if(this.gabineteSeguranca != null){
            this.gabineteSeguranca.remover(this);
        }
        this.gabineteSeguranca = gabineteSeguranca;
        gabineteSeguranca.adicionar(this);
    }

    @Override
    public GabineteSegurança getGabinete() {
        return gabineteSeguranca;
    }

    @Override
    public void desassociarGabinete() {
        if(gabineteSeguranca == null){
            return;
        }
        GabineteSegurança segurancaAremover = gabineteSeguranca;
        gabineteSeguranca= null;
        segurancaAremover.remover(this);
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
        if(gabineteSeguranca.isAberta()){
            return;
        }
        gabineteSeguranca.abrir();
    }

    @Override
    public void fecharGabinete() {
        if(!gabineteSeguranca.isAberta()){
            return;
        }
        gabineteSeguranca.fechar();

    }
    public void abrir(GabineteProfessor gabineteProfessor) {
        if(gabineteProfessor.isAberta()){
            return;
        }
        gabineteProfessor.abrir();
    }
    public void fechar(GabineteProfessor gabineteProfessor) {
        if(!gabineteProfessor.isAberta()){
            return;
        }
        gabineteProfessor.fechar();
    }
    //terminar
    public void adicionar(Horario horarioAtendimento){

    }
    public void remover(Horario horarioAtendimento){

    }

}
