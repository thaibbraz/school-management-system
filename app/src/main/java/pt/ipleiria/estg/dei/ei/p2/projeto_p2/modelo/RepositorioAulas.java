package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.LinkedList;

public interface RepositorioAulas {
    void adicionar(Aula aula);

    void remover(Aula aula);

    LinkedList<Aula> getAulas();
}
