import junit.framework.TestCase;
import org.junit.*;
import dados.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TesteMorador extends TestCase{
    private Morador morador;

    public void setUp() {
        Endereco endereco = new Endereco("SC", "Rua Lindoia", "Buenos Retiro", -1);
        morador = new Morador("Ana", endereco, "ana@gmail.com", "987654321", 101);
    }

    public void testGetnApartamento() {
        assertEquals(101, morador.getnApartamento());
    }

    public void testSetnApartamento() {
        morador.setnApartamento(102);
        assertEquals(102, morador.getnApartamento());
    }

    public void testAdicionarMensagem() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Assembleia assembleia = new Assembleia("Sindico", sdf.parse("01/02/2024"), "Discussão sobre aumento do aluguel.", null);
        morador.adicionarMensagem(assembleia);
        assertTrue(morador.getMensagens().contains(assembleia));
    }

}