package pt.ipleiria.estg.dei.ei.p2.projeto_p2.modelo;


import java.util.LinkedList;

public class Gabinete<Tfuncionario extends Funcionario> extends Divisao{

    protected LinkedList<Tfuncionario> funcionarios;

    public Gabinete(String nome,boolean aberta) {
        super(nome,aberta);
       funcionarios = new LinkedList<>();
    }

    public void adicionar(Tfuncionario funcionario){
        if(funcionarios == null || funcionarios.contains(funcionario)){
            return;
        }
        funcionarios.add(funcionario);
        funcionario.setGabinete(this);

    }
    public void remover(Tfuncionario funcionario){
        if(funcionarios == null || !funcionarios.contains(funcionario)){
            return;
        }
        funcionarios.remove(funcionario);
        funcionario.desassociarGabinete();
    }
}
