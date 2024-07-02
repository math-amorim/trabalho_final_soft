package dados;

public abstract class Pessoa {
    private String nome;
    private Endereco endereco;
    private String email;
    private String telefone;

    public Pessoa(String n, Endereco e, String em, String t) {
        this.nome = n;
        this.endereco = e;
        this.email = em;
        this.telefone = t;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
