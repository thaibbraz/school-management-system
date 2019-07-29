package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public class Horario {

    private int horaDeInicio;
    private int duracao;
    private DiaSemana diaSemana;



    public Horario(DiaSemana diaSemana, int horaDeInicio, int duracao) {

    this.diaSemana = diaSemana;
    this.horaDeInicio = horaDeInicio;
    this.duracao = duracao;

    }

    public int getHoraDeInicio() {
        return horaDeInicio;
    }

    public long getDuracao() {
        return duracao;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public boolean isSobreposto(Horario horario){
        int horaFimSobreposto = (int) (horario.getHoraDeInicio()+horario.getDuracao());
        int horaFimNormal = horaDeInicio + duracao;
        if(horario.getDiaSemana() != this.getDiaSemana()){
            return false;
        }
        if ((horario.getHoraDeInicio() >= horaDeInicio) && (horaFimSobreposto <= horaFimNormal)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return diaSemana.toString() + " "+ String.valueOf(horaDeInicio)+ "h"+" - " + String.valueOf(horaDeInicio+duracao)+"h";
    }
}
