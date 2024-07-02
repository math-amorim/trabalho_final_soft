import junit.framework.TestCase;
import org.junit.*;
import dados.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TesteAssembleia extends TestCase {
    private Assembleia assembleia;
    private List<Pessoa> participantes;
    private SimpleDateFormat sdf;
    private Date data, data2;

    public void setUp() throws ParseException {
        sdf = new SimpleDateFormat("dd/mm/yyyy");
        data = sdf.parse("01/02/2024");
        participantes = new ArrayList<>();
        participantes.add(new Morador("Ana", null, null, null, -1));
        participantes.add(new Morador("João", null, null, null, -1));
        participantes.add(new Morador("Luiz", null, null, null, -1));

        assembleia = new Assembleia("Sindico", data, "Discussão sobre aumento do aluguel", participantes);
    }

    public void testGetData() throws ParseException {
        data2 = sdf.parse("01/02/2024");
        assertEquals(data2, assembleia.getData());
    }

    public void testSetData() throws ParseException {
        Date newData = sdf.parse("15/03/2024");
        assembleia.setData(newData);
        assertEquals(newData, assembleia.getData());
    }

    public void testGetPauta() {
        assertEquals("Discussão sobre aumento do aluguel", assembleia.getPauta());
    }

    public void testSetPauta() {
        assembleia.setPauta("Nova pauta");
        assertEquals("Nova pauta", assembleia.getPauta());
    }

    public void testGetParticipantes() {
        assertEquals(3, assembleia.getParticipantes().size());
        assertEquals("Ana", assembleia.getParticipantes().get(0).getNome());
        assertEquals("João", assembleia.getParticipantes().get(1).getNome());
        assertEquals("Luiz", assembleia.getParticipantes().get(2).getNome());

    }

    public void testAdicionarParticipante() {
        Morador novoParticipante = new Morador("Carlos", null, null, null, -1);
        assembleia.adicionarParticipante(novoParticipante);
        assertEquals(4, assembleia.getParticipantes().size());
        assertEquals("Carlos", assembleia.getParticipantes().get(3).getNome());
    }

    public void testExibirAssembleia() {
        assembleia.exibirAssembleia();
    }
}
