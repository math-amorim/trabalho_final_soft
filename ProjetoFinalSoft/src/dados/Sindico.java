package dados;

public class Sindico extends Morador{
    int mandato;
    String senha;

    public Sindico(String n, Endereco e, String em, String t, int m, int ape, String senha) {
        super(n, e, em, t, ape);
        this.senha = senha;
        this.mandato = m;
    }

    public int getMandato() {
        return mandato;
    }
    public void setMandato(int mandato) {
        this.mandato = mandato;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
