package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public interface Funcionario<TGabinete extends Gabinete,TDivisao extends Divisao>{

    void setGabinete(TGabinete gabinete);

    public Gabinete getGabinete();

    void desassociarGabinete();

    void abrirSala(TDivisao divisao);

    void fecharSala(TDivisao divisao);

    void abrirGabinete();

    void fecharGabinete();

    public LinkedList<Horario> getHorarioAtendimento();
}
