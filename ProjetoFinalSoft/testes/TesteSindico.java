import junit.framework.TestCase;
import org.junit.*;
import dados.*;

public class TesteSindico extends TestCase {
    private Sindico sindico;

    public void setUp() {
        Endereco endereco = new Endereco("SC", "Rua Lindoia", "Buenos Retiro", 1);
        sindico = new Sindico("Carlos", endereco, "carlos@gmail.com", "123456789", 4, 1, "123");
    }

    public void testGetMandato() {
        assertEquals(4, sindico.getMandato());
    }

    public void testSetMandato() {
        sindico.setMandato(5);
        assertEquals(5, sindico.getMandato());
    }

    public void testGetSenha() {
        assertEquals("123", sindico.getSenha());
    }

    public void testSetSenha() {
        sindico.setSenha("456");
        assertEquals("456", sindico.getSenha());
    }

}