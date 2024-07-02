package dados;

import java.util.LinkedList;
import java.util.List;

public class Apartamento {
    private int numeroApartamento;
    private int quantidadeQuartos;
    private int quantidadePessoas;
    private int quantidadeOcupado;
    private List<Pessoa> moradores = new LinkedList<>();
    boolean disponivel;

    public Apartamento(int n, int qQ, int qP){
        this.numeroApartamento = n;
        this.quantidadePessoas = qP;
        this.quantidadeQuartos = qQ;
        this.quantidadeOcupado = 0;
        disponivel = true;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }
    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getNumeroApartamento() {
        return numeroApartamento;
    }
    public void setNumeroApartamento(int numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public int getQuantidadeOcupado() {
        return quantidadeOcupado;
    }
    public void setQuantidadeOcupado(int quantidadeOcupado) {
        this.quantidadeOcupado = quantidadeOcupado;
    }

    public List<Pessoa> getMoradores() {
        return moradores;
    }
    public void setMoradores(List<Pessoa> moradores) {
        this.moradores = moradores;
    }

    public void adicionarMorador(Pessoa morador){
        moradores.add(morador);
        quantidadeOcupado++;
        if(quantidadeOcupado == quantidadePessoas) disponivel = false;
    }

    public void removeMorador(Pessoa morador){
        moradores.remove(morador);
        quantidadeOcupado--;
        if(quantidadeOcupado < quantidadePessoas) disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean x){
        this.disponivel = x;
    }

    public String ocupacao(){
        if(quantidadeOcupado == 1) return "(Ocupado por " + moradores.get(0).getNome() + " e restam " + (quantidadePessoas - quantidadeOcupado) + " vagas) \n";
        if(quantidadeOcupado == 2) return "(Ocupado por " + moradores.get(0).getNome()  + " e " +  moradores.get(1).getNome() + " e restam " + (quantidadePessoas - quantidadeOcupado) + " vagas )\n";
        return "(Desocupado.)\n";
    }
}
