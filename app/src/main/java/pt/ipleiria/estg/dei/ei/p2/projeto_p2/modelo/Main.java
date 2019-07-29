package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public Main() {


        // Adicionar gabinetes professores

        GestorSemanaAulas.INSTANCIA.getAula(0);

        GabineteProfessor gabineteProfessorA1 = new GabineteProfessor("Gabinete Professor - A.1", false);
        GabineteProfessor gabineteProfessorD1 = new GabineteProfessor("Gabinete Professor - D.1", true);

        // Adicionar gabinete seguranças

        GabineteSegurança gabineteSegurancaA = new GabineteSegurança("Gabinete Segurança - Edifício A", false);
        GabineteSegurança gabineteSegurancaD = new GabineteSegurança("Gabinete Segurança - Edifício D", false);

        // Adicionar professores

        Professor professorManuelSilva = new Professor("Manuel Silva", 1, gabineteProfessorA1);
        Professor professorCarlosSantos = new Professor("Carlos Santos", 2, gabineteProfessorA1);
        Professor professorJoseMonteiro = new Professor("José Monteiro", 3, gabineteProfessorD1);

        // Adicionar horario aos professores

        professorManuelSilva.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 17, 2));
        professorCarlosSantos.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 17, 2));
        professorJoseMonteiro.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 17, 2));

        // Adicionar Seguranças

        Segurança segurancaMiguelMarques = new Segurança("Miguel Marques", 4, gabineteSegurancaA);
        Segurança segurancaJoaoSantos = new Segurança("João Santos", 5, gabineteSegurancaA);
        Segurança segurancaAntonioSilva = new Segurança("António Silva", 5, gabineteSegurancaD);

        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.QUINTA_FEIRA, 8, 8));
        segurancaMiguelMarques.adicionar(new Horario(DiaSemana.SEXTA_FEIRA, 8, 8));

        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.SEGUNDA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.TERCA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.QUARTA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.QUINTA_FEIRA, 16, 8));
        segurancaJoaoSantos.adicionar(new Horario(DiaSemana.SEXTA_FEIRA, 16, 8));


        segurancaAntonioSilva.adicionar(new Horario(DiaSemana.SABADO, 8, 8));


        Sala salaA1 = new Sala("Sala A1", true);
        Sala salaA2 = new Sala("Sala A2", true);
        Sala salaLAI1 = new Sala("Sala LAI1", false);

        Aula aula1 = new Aula("Programação II TP1", 1, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2), salaA1);
        Aula aula2 = new Aula("Programação II TP2", 2, new Horario(DiaSemana.SEGUNDA_FEIRA, 8, 2), salaA2);
        Aula aula3 = new Aula("Programação II PL1", 3, new Horario(DiaSemana.SEGUNDA_FEIRA, 10, 3), salaLAI1);

        // Os Professores abrem/fecham o próprio gabinete e qualquer sala
        professorManuelSilva.abrirGabinete();
        professorCarlosSantos.fecharGabinete(); // O Professor Carlos Santos fecha o seu gabinete (partilhado), que o Professor Manuel Silva abriu
        professorCarlosSantos.abrirSala(salaLAI1);
        professorCarlosSantos.fecharSala(salaLAI1);

        // Os Seguranças abrem/fecham o próprio gabinete e qualquer divisão (gabinete/sala)
        segurancaMiguelMarques.abrirGabinete();
        segurancaJoaoSantos.fechar(professorJoseMonteiro.getGabinete());
        segurancaAntonioSilva.fecharSala(salaA1);
        segurancaAntonioSilva.fecharSala(salaA2);

      //  System.out.println(aula1.getSala().getNome());

        // Aplicação do Polimorfismo numa estrutura de dados
        LinkedList<Descritor> descritores = new LinkedList<>();
        descritores.add(gabineteProfessorA1);
        descritores.add(gabineteProfessorD1);
        descritores.add(gabineteSegurancaA);
        descritores.add(gabineteSegurancaD);

        descritores.add(professorManuelSilva);
        descritores.add(professorCarlosSantos);
        descritores.add(professorJoseMonteiro);

        descritores.add(segurancaMiguelMarques);
        descritores.add(segurancaJoaoSantos);
        descritores.add(segurancaAntonioSilva);

        descritores.add(salaA1);
        descritores.add(salaA2);
        descritores.add(salaLAI1);

        descritores.add(aula1);
        descritores.add(aula2);
        descritores.add(aula3);

        for (Descritor descritor : descritores) {
            System.out.print("Nome: " + descritor.getNome() + " ");

            if (descritor instanceof Identificador) { // Verifica se o descritor é do tipo Identificador
                long numero = ((Identificador) descritor).getNumero(); // O cast é obrigatório para que seja possível aceder ao atributo numero
                System.out.println("(Identificador: nº " + numero + ")");
            } else if (descritor instanceof Divisao) { // Verifica se o descritor é do tipo Divisao
                System.out.println("(Divisão)");
            }
        }


    }


    public static void main(String[] args) {
     new Main();

    }
}
