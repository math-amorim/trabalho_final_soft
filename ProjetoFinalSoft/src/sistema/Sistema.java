package sistema;

import dados.*;
import java.util.*;

public class Sistema {
    private static Sistema instance;
    private LinkedList<Pessoa> moradoresSistema, funcionarioSistema;
    private LinkedList<Apartamento> apartamentosSistema;
    private LinkedList<AreaComum> areasComuns;
    private Sindico sindico;

    private Sistema(){
        moradoresSistema = new LinkedList<>();
        apartamentosSistema = new LinkedList<>();
        funcionarioSistema = new LinkedList<>();
        areasComuns = new LinkedList<>();
    }

    public static Sistema getInstance(){
        if(instance == null){
            instance = new Sistema();
        }
        return instance;
    }

    public int addPessoa(Pessoa p){
        if(p instanceof Sindico){
            if(this.sindico != null){
                return 2; // sindico ja existe
            }else{
                this.sindico = (Sindico) p;
                return 1;
            }
        }
        if(p instanceof Funcionario) funcionarioSistema.add(p);
        if(p instanceof Morador) moradoresSistema.add(p);

        return 0; // settou outros tipos de pessoas
    }

    public void removerPessoa(Pessoa p){
        if(p instanceof  Funcionario){
            funcionarioSistema.remove(p);
        }
        if(p instanceof Morador){
            moradoresSistema.remove(p);
            for(Apartamento a : apartamentosSistema){
                for(Pessoa m : a.getMoradores()){
                    if(m.getNome().equals(p.getNome())){
                        moradoresSistema.remove(p);
                        a.removeMorador(p);
                    }
                }
            }
        }
    }


    public Pessoa logar(String nome, String senha){
        if(sindico.getNome().equals(nome) &&  sindico.getSenha().equals(senha)){
            return sindico;
        }
        return null;
    }

    public boolean verificarCapacidade(int x){
        int sum = 0;
        for(Apartamento a : getApartamentosDisponiveis()){
            sum += a.getQuantidadePessoas() - a.getQuantidadeOcupado();
        }

        if(sum > x) return true;

        return false;
    }
    public LinkedList<Apartamento> getApartamentosDisponiveis(){
        LinkedList<Apartamento> apes = new LinkedList<>();
        for(Apartamento a : apartamentosSistema){
            if(a.isDisponivel()) apes.add(a);
        }
        return apes;
    }
    public LinkedList<Apartamento> getApartamentoPorCapacidade(int x){
        LinkedList <Apartamento> lista = getApartamentosDisponiveis();
        for(Apartamento a : lista){
            if(a.getQuantidadeOcupado() + x > a.getQuantidadePessoas() && a.getQuantidadePessoas() < x){
                lista.remove(a);
            }
        }
        return lista;
    }

    public LinkedList<Pessoa> getMoradoresSistema() {
        return moradoresSistema;
    }
    public void setMoradoresSistema(LinkedList<Pessoa> moradoresSistema) {
        this.moradoresSistema = moradoresSistema;
    }

    public LinkedList<Pessoa> getFuncionarioSistema() {
        return funcionarioSistema;
    }
    public void setFuncionarioSistema(LinkedList<Pessoa> funcionarioSistema) {
        this.funcionarioSistema = funcionarioSistema;
    }

    public LinkedList<Apartamento> getApartamentosSistema() {
        return apartamentosSistema;
    }
    public void setApartamentosSistema(LinkedList<Apartamento> apartamentosSistema) {
        this.apartamentosSistema = apartamentosSistema;
    }

    public LinkedList<AreaComum> getAreasComuns() {
        return areasComuns;
    }
    public void setAreasComuns(LinkedList<AreaComum> areasComuns) {
        this.areasComuns = areasComuns;
    }

    public Pessoa getSindico() {
        return sindico;
    }
    public void setSindico(Sindico sindico) {
        this.sindico = sindico;
    }
}
