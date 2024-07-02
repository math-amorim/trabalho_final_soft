import junit.framework.TestCase;
import org.junit.*;
import sistema.*;
import dados.*;
import java.util.*;

public class TesteSistema extends TestCase {
        private Sistema sistema;
        private Sindico sindico;
        private Morador morador;
        private Funcionario funcionario;
        private Apartamento apartamento, apartamento2;
        private Endereco endereco, enderecoFuncionario;

        public void setUp() {
            sistema = Sistema.getInstance();
            endereco = new Endereco("SC", "Rua Lindoia", "Buenos Retiro", -1);
            enderecoFuncionario = new Endereco("SC", "Bachs", "Costa e Nivia", 23);
            sindico = new Sindico("Carlos", endereco, "carlos@gmail.com", "123456789", 4, 1, "123");
            morador = new Morador("Ana", endereco, "ana@gmail.com", "987654321", -1);
            funcionario = new Funcionario("João", enderecoFuncionario, "joao@gmail.com", "555555555",  "Zelador");
            apartamento = new Apartamento(1, 2,2);
            apartamento2 = new Apartamento(2, 1, 1);
            sistema.getApartamentosSistema().add(apartamento);
            sistema.getApartamentosSistema().add(apartamento2);
        }

        public void testAddPessoa() {
            System.out.println("Rodando teste de adicionar pessoas ao sistema: \n");

            int result = sistema.addPessoa(sindico);
            assertEquals(1, result);
            assertEquals(sindico, sistema.getSindico());

            sistema.addPessoa(morador);
            assertTrue(sistema.getMoradoresSistema().contains(morador));

            sistema.addPessoa(funcionario);
            assertTrue(sistema.getFuncionarioSistema().contains(funcionario));
        }

        public void testRemoverPessoa() {
            sistema.addPessoa(morador);
            sistema.removerPessoa(morador);
            assertFalse(sistema.getMoradoresSistema().contains(morador));
        }

        public void testLogar() {
            sistema.addPessoa(sindico);
            Pessoa pessoaLogada = sistema.logar("Carlos", "123");
            assertEquals(sindico, pessoaLogada);
        }

        // verifica se o getApartamentoDisponiveis está realmente retornando apenas aqueles marcados como disponiveis
        public void testGetApartamentosDisponiveis() {
            //apartamento2.setDisponivel(false);
            apartamento2.adicionarMorador(sindico);
            LinkedList<Apartamento> disponiveis = sistema.getApartamentosDisponiveis();
            assertFalse(disponiveis.contains(apartamento2));

        }

}


