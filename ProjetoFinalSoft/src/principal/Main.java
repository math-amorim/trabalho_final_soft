package principal;
import dados.*;
import sistema.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Sistema sistema = Sistema.getInstance();
    private static Scanner sc = new Scanner(System.in);
    private static Endereco enderecoCondominio = new Endereco("SC", "Rua Lindoia", "Buenos Retiro", -1);


    public static void main(String[] args) {

        Apartamento ap1 = new Apartamento(1, 2, 2);
        Apartamento ap2 = new Apartamento(2, 1,1);
        Apartamento ap3 = new Apartamento(3, 2, 2);
        Apartamento ap4 = new Apartamento(4, 1, 1);
        Apartamento ap5 = new Apartamento(5, 2, 2);
        AreaComum churrasco = new AreaComum("Churrasco", 10, 60, false);
        AreaComum salaoFesta = new AreaComum("Salão de Festas", 25, 100, false);

        sistema.getApartamentosSistema().add(ap1);
        sistema.getApartamentosSistema().add(ap2);
        sistema.getApartamentosSistema().add(ap3);
        sistema.getApartamentosSistema().add(ap4);
        sistema.getApartamentosSistema().add(ap5);
        sistema.getAreasComuns().add(churrasco);
        sistema.getAreasComuns().add(salaoFesta);

        menuInicial();
    }

    public static void menuInicial(){
        int escolha = 0;

        while(escolha != 3) {
            System.out.println("Bem vindo ao sistema de condomínio!\n1 - Cadastrar síndico\n2 - Logar\n3 - Sair do Programa\n");
            escolha = Integer.parseInt(sc.nextLine());
            switch (escolha) {
                case 1 :
                    cadastroSindico();
                    break;
                case 2:
                    logar();
                    break;
                case 3:
                    System.out.println("Saindo...\n");
                    break;
                default:
                    System.out.println("Escolha inválida!\n");
                    break;
            }
        }
    }

    public static void menuSindico(){
        int escolha = 0;
        while(escolha != -1){
            System.out.println("Indique o que deseja fazer: \n1 - Cadastrar novo morador:\n2 - Remover morador:\n3 - Cadastrar novo funcionário: \n4 - Remover funcionário:\n5 - Solicitar assembleia:\n6 - Visualizar moradores\n7 - Visualizar funcionários:\n-1 - Deslogar:\n");
            escolha = Integer.parseInt(sc.nextLine());
            switch(escolha){
                case 1:
                    cadastroMorador();
                    break;
                case 2:
                    if(sistema.getMoradoresSistema() != null) removerMorador();
                    else System.out.println("Não há moradores cadastrados!\n");
                    break;
                case 3:
                    cadastroFuncionario();
                    break;
                case 4:
                    if(sistema.getFuncionarioSistema() != null) removerFuncionario();
                    else System.out.println("Não há funcionários cadastrados!\n");
                    break;
                case 5:
                    solicitarAssembleia();
                    break;
                case 6:
                    visualizarMoradores();
                    break;
                case 7:
                    visualizarFuncionarios();
                    break;

                case -1:
                    System.out.println("Deslogando...\n");
                    break;
            }
        }


    }

    public static void solicitarAssembleia(){
        String convocador = sistema.getSindico().getNome(), pauta;

        System.out.println("Qual a pauta da assembleia?"); pauta = sc.nextLine();

        System.out.println("Digite a data da assembleia no formato dd/mm/yyyy:");
        String dataEntrada = sc.nextLine();

        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
            Date dataAssembleia = null;
        try {
            dataAssembleia = formato.parse(dataEntrada);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/mm/yyyy.");
            return;
        }

        Assembleia a = new Assembleia(convocador ,dataAssembleia,pauta,sistema.getMoradoresSistema());

        for(Pessoa m: sistema.getMoradoresSistema()){
            if(m instanceof Morador){
                ((Morador) m).getMensagens().add(a);
            }
        }

        System.out.println("Assembleia foi convocada com sucesso!\n");
    }

    public static void newPessoa(int i){
        String nome, email, telefone, senha;
        System.out.println("Digite o nome do novo cadastro:\n");
        nome = sc.nextLine();
        System.out.println("Digite o email do novo cadastro:\n");
        email = sc.nextLine();
        System.out.println("Digite o telefone do novo cadastro: \n");
        telefone =  sc.nextLine();

        switch(i){
            case 1:
                System.out.println("Digite a senha: \n");
                senha = sc.nextLine();
                newSindico(nome, email, telefone, enderecoCondominio, senha);
                break;
            case 2:
                newMorador(nome, email, telefone, enderecoCondominio);
                break;
            case 3:
                newFuncionario(nome, email, telefone, newEndereco());
                break;
        }

    }

    public static void cadastroSindico(){
        if(sistema.getSindico() == null){
            newPessoa(1);
        }else{
            System.out.println("Já existe um síndico cadastrado.\n");
        }
    }
    public static void newSindico(String nome, String email, String telefone, Endereco e, String senha){
        Apartamento a = alocarMorador();
        System.out.println("Quanto tempo de mandato?\n");

        int m = Integer.parseInt(sc.nextLine());
        Sindico s = new Sindico(nome, e, email, telefone, m, a.getNumeroApartamento(), senha);
        sistema.addPessoa(s);

        a.adicionarMorador(s);
        s.getEndereco().setNumero(a.getNumeroApartamento());

        System.out.println("Síndico adicionado com sucesso!\n");
    }

    public static void cadastroMorador(){
        System.out.println("Quantos novos moradores serão cadastrados?:\n");
        int escolha = Integer.parseInt(sc.nextLine());

        if(sistema.verificarCapacidade(escolha)){
            for(int i = 0; i < escolha; i ++){
                newPessoa(2);
            }
        }else{
            System.out.println("Não há apartamentos disponíveis para o número de moradores.\n");
        }
    }
    public static void newMorador(String nome, String email, String telefone, Endereco e){
        Apartamento a = alocarMorador();

        Morador m = new Morador(nome, e, email, telefone, a.getNumeroApartamento());
        a.adicionarMorador(m);
        m.getEndereco().setNumero(a.getNumeroApartamento());

        sistema.addPessoa(m);
        System.out.println("Morador cadastrado com sucesso!\n");
    }
    public static void removerMorador(){
        System.out.println("Qual o morador que você deseja remover? (Nome completo)\n");
        visualizarMoradores();
        String s = sc.nextLine(); Pessoa p = null;
        for(Pessoa m : sistema.getMoradoresSistema()){
            if(m.getNome().equals(s)) p = m;
        }
        if(p instanceof Sindico){
            System.out.println("Não se pode remover um síndico!\n");
        }else {
            if (p != null) {
                sistema.removerPessoa(p);
                System.out.println("Morador removido com sucesso!\n");
            } else {
                System.out.println("Nome inválido!\n");
            }
        }
    }

    public static void cadastroFuncionario(){
        System.out.println("Cadastro de funcionário: \n");
        newPessoa(3);
    }
    public static void newFuncionario(String nome, String email, String telefone, Endereco e){
        System.out.println("Qual a função do funcionário?\n");
        String f = sc.nextLine();
        Funcionario funcionario = new Funcionario(nome, e, email, telefone, f);
        sistema.addPessoa(funcionario);
        System.out.println("Funcionário adicionado com sucesso!\n");
    }
    public static void removerFuncionario(){
        System.out.println("Qual o funcionário que você deseja remover? (Nome completo)\n");
        visualizarFuncionarios();
        String s = sc.nextLine(); Pessoa p = null;
        for(Pessoa m : sistema.getFuncionarioSistema()){
            if(m.getNome().equals(s)) p = m;
        }
        if(p != null){
            sistema.removerPessoa(p);
            System.out.println("Funcionário removido com sucesso!\n");
        }else{
            System.out.println("Nome inválido!\n");
        }
    }

    public static Endereco newEndereco(){
        String estado, bairro, rua; int num;
        System.out.println("Digite o estado: \n");
        estado = sc.nextLine();
        System.out.println("Digite o bairro: \n");
        bairro = sc.nextLine();
        System.out.println("Digite a rua: \n");
        rua = sc.nextLine();
        System.out.println("Digite o número da casa/apartamento: \n");
        num = Integer.parseInt(sc.nextLine());
        return new Endereco(estado,rua,bairro,num);
    }

    public static Apartamento alocarMorador(){
        LinkedList<Apartamento> disponiveis = sistema.getApartamentosDisponiveis();
        System.out.println("Digite para qual apartamento deseja alocar o morador? \n");
        int contador = 0;
        for(Apartamento a : disponiveis){
            System.out.println((contador+1) + " - " + a.getNumeroApartamento() + " " + a.ocupacao());
            contador++;
        }
        int escolha = Integer.parseInt(sc.nextLine());
        return disponiveis.get(escolha - 1);
    }

    public static void logar(){
        if(sistema.getSindico() == null){
            System.out.println("Não existe síndico cadastrado!\n");
        }else {

            System.out.println("Login: \n");
            System.out.println("Digite o nome do síndico: \n");
            String nome = sc.nextLine();
            System.out.println("Digite a senha da pessoa do síndico: \n");
            String senha = sc.nextLine();

            Pessoa login = sistema.logar(nome, senha);
            if (login == null) {
                System.out.println("Nome ou senha estão errados!\n");
            } else {
                if (login instanceof Sindico) menuSindico();
            }
        }
    }

    public static void visualizarMoradores(){
        System.out.println("Moradores: ");
        for(Apartamento a : sistema.getApartamentosSistema()){
            if(a.getQuantidadeOcupado() > 0) {
                System.out.println("Apartamento número " + a.getNumeroApartamento() + ". " + a.ocupacao());
            }
        }

    }
    public static void visualizarFuncionarios(){
        System.out.println("Funcionários: ");
        for(Pessoa f : sistema.getFuncionarioSistema()){
            System.out.println("Nome do funcionário " + f.getNome() );
        }
    }

}