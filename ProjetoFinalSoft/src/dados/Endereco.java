package dados;

public class Endereco {
    private String estado;
    private String rua;
    private String bairro;
    private int numero;

    public Endereco(String e, String r, String b, int n){
        this.estado = e;
        this.rua = r;
        this.bairro = b;
        this.numero = n;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

}
