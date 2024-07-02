package dados;

public class AreaComum {
    String nome;
    int quantidadePessoas;
    double precoLocacao;
    boolean estaLocado;
    Pessoa responsavelLocacao;
    
    public AreaComum(String n, int qp, double pre, boolean e){
    	this.nome = n; 
    	this.quantidadePessoas = qp; 
    	this.precoLocacao = pre; 
    	this.estaLocado = false; 
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }
    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public double getPrecoLocacao() {
        return precoLocacao;
    }
    public void setPrecoLocacao(double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }

    public boolean isEstaLocado() {
        return estaLocado;
    }
    public void setEstaLocado(boolean estaLocado) {
        this.estaLocado = estaLocado;
    }

    public Pessoa getResponsavelLocacao() {
        return responsavelLocacao;
    }
    public void setResponsavelLocacao(Pessoa responsavelLocacao) {
        this.responsavelLocacao = responsavelLocacao;
    }
}
