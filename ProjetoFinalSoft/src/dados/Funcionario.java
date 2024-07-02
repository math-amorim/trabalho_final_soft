package dados;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String n, Endereco e, String em, String t, String c) {
        super(n, e, em, t);
        this.cargo = c;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
