package dados;

import java.util.Date;
import java.util.List;

public class Assembleia {
    private Date data;
    private String pauta;
    private List<Pessoa> participantes;

    public Assembleia(String convocador, Date data, String pauta, List<Pessoa> participantes) {
        this.data = data;
        this.pauta = pauta;
        this.participantes = participantes;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public String getPauta() {
        return pauta;
    }
    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public List<Pessoa> getParticipantes() {
        return participantes;
    }
    public void adicionarParticipante(Pessoa participante) {
        this.participantes.add(participante);
    }

    public void exibirAssembleia() {
        System.out.println("Data: " + data);
        System.out.println("Pauta: " + pauta);
        System.out.println("Participantes: ");
        for (Pessoa participante : participantes) {
            System.out.println(" - " + participante.getNome());
        }
    }

}
