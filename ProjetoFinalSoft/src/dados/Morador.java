package dados;

import java.util.LinkedList;

public class Morador extends Pessoa{
    private int nApartamento;
    private LinkedList<Assembleia> mensagens;

    public Morador(String n, Endereco e, String em, String t, int num) {
        super(n, e, em, t);
        this.nApartamento = num;
        mensagens = new LinkedList<>();
    }
    public int getnApartamento() {
        return nApartamento;
    }
    public void setnApartamento(int nApartamento) {
        this.nApartamento = nApartamento;
    }

    public LinkedList<Assembleia> getMensagens() {
        return mensagens;
    }
    public void setMensagens(LinkedList<Assembleia> mensagens) {
        this.mensagens = mensagens;
    }
    public void adicionarMensagem(Assembleia a){
        this.mensagens.add(a);
    }
}
