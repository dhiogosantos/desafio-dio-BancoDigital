import br.edu.bancodigital.controller.ExceptionsConta;
import br.edu.bancodigital.model.*;

import java.util.List;
import java.util.Scanner;

import static br.edu.bancodigital.model.Conta.listaContas;

public class Application {

    public static boolean controleWhile = true;

    public static void main(String[] args) throws ExceptionsConta {

        Scanner sc = new Scanner(System.in);

        while (controleWhile) {
            System.out.println("\n1. Cadastrar banco");
            System.out.println("2. Cadastrar cliente");
            System.out.println("3. Cadastrar conta");
            System.out.println("4. Sacar");
            System.out.println("5. Depositar");
            System.out.println("6. Transferir");
            System.out.println("7. Listar bancos cadastrados");
            System.out.println("8. Listar clientes cadastrados");
            System.out.println("9. Listar contas cadastrados");
            System.out.println("10. Sair");

            System.out.print("\nEscolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:

                    System.out.print("\nDigite o nome do banco: ");
                    String nomeBanco = sc.nextLine();

                    System.out.print("Digite o código do banco: ");
                    int codigoBanco = sc.nextInt();

                    Banco banco = new Banco(nomeBanco, codigoBanco);

                    Banco.listaBancos.add(banco);

                    System.out.println("\nBanco cadastrado com sucesso.");

                    break;

                case 2:

                    System.out.print("\nDigite o nome do(a) cliente: ");
                    String nomeCliente = sc.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpfCliente = sc.nextLine();

                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);

                    Cliente.listaClientes.add(cliente);

                    System.out.println("\nCliente cadastrado com sucesso.");

                    break;

                case 3:

                    if(Cliente.listaClientes.isEmpty()){
                        System.out.println("\nCadastre um cliente!");
                        break;
                    }

                    if(Banco.listaBancos.isEmpty()){
                        System.out.println("\nCadastre um banco!");
                        break;
                    }

                    int aux = 1;
                    int auxBanco = 1;
                    Banco opcaoBancoEscolhido = null;
                    Cliente clienteCadastroConta = null;

                    System.out.print("\nBancos cadastrados:\n");

                    for(Banco b : Banco.listaBancos){
                        System.out.println(auxBanco + " - " + b.getNome());
                        auxBanco++;
                    }

                    System.out.print("Escolha um banco para essa conta: ");
                    int opcaoClienteBanco = sc.nextInt();

                    opcaoBancoEscolhido = Banco.listaBancos.get(opcaoClienteBanco - 1);

                    System.out.print("\nDigite o número da agência: ");
                    int numeroAgencia = sc.nextInt();

                    System.out.print("\n1 - Cadastrar conta corrente" + "\n2 - Cadastrar conta poupança" + "\nDigite uma opção: ");
                    int opcaoCadastro = sc.nextInt();

                    System.out.print("\nClientes cadastrados:\n");

                    for(Cliente c : Cliente.listaClientes){
                        System.out.println(aux + " - " + c.getNome());
                        aux++;
                    }

                    System.out.print("Escolha um cliente para essa conta: ");

                    int opcaoCliente = sc.nextInt();

                    clienteCadastroConta = Cliente.listaClientes.get(opcaoCliente - 1);

                    if(opcaoCadastro == 1){
                        ContaCorrente cc = new ContaCorrente(clienteCadastroConta, numeroAgencia);
                        Conta.listaContas.add(cc);
                        opcaoBancoEscolhido.setListaContas(cc);
                        System.out.println("\nConta cadastrada com suceso.");
                    } else if(opcaoCadastro == 2){
                        ContaPoupanca cp = new ContaPoupanca(clienteCadastroConta, numeroAgencia);
                        Conta.listaContas.add(cp);
                        opcaoBancoEscolhido.setListaContas(cp);
                        System.out.println("\nConta cadastrada com suceso.");
                    } else {
                        System.out.println("\nOpção inválida!");
                        break;
                    }

                    break;

                case 4:

                    if(Conta.listaContas.isEmpty()){
                        System.out.println("\nNenhuma conta cadastrada.");
                        break;
                    }

                    Conta contaSaque = null;

                    System.out.print("\nContas cadastradas:\n");

                    for(Conta c : listaContas){
                        System.out.println("\nNúmero conta: " + c.getNumeroConta() + "\nTitular: " + c.getCliente().getNome());
                    }

                    System.out.print("\nEscolha uma conta para sacar: ");

                    int opcaoSaque = sc.nextInt();

                    contaSaque = Conta.listaContas.get(opcaoSaque - 1);

                    System.out.print("Digite o valor do saque: R$ ");
                    float valorSaque = sc.nextFloat();

                    try{
                        if(contaSaque instanceof ContaCorrente){
                            ((ContaCorrente) contaSaque).sacar(valorSaque);
                        }

                        if(contaSaque instanceof ContaPoupanca){
                            ((ContaPoupanca) contaSaque).sacar(valorSaque);
                        }

                    } catch (ExceptionsConta e){
                        System.out.println("\n" + e.getMessage());
                    }

                    break;

                case 5:

                    if(Conta.listaContas.isEmpty()){
                        System.out.println("\nNenhuma conta cadastrada.");
                        break;
                    }

                    Conta contaDeposito = null;

                    System.out.print("\nContas cadastradas:\n");

                    for(Conta c : listaContas){
                        System.out.println("\nNúmero conta: " + c.getNumeroConta() + "\nTitular: " + c.getCliente().getNome());
                    }

                    System.out.print("\nEscolha uma conta para depositar: ");

                    int opcaoDeposito = sc.nextInt();

                    contaSaque = Conta.listaContas.get(opcaoDeposito - 1);

                    System.out.print("Digite o valor do depósito: R$ ");
                    float valorDeposito = sc.nextFloat();

                    try{
                        if(contaSaque instanceof ContaCorrente){
                            ((ContaCorrente) contaSaque).depositar(valorDeposito);
                        }

                        if(contaSaque instanceof ContaPoupanca){
                            ((ContaPoupanca) contaSaque).depositar(valorDeposito);
                        }

                    } catch (ExceptionsConta e){
                        System.out.println("\n" + e.getMessage());
                    }

                    break;

                case 6:

                    if(Conta.listaContas.isEmpty()){
                        System.out.println("\nNenhuma conta cadastrada.");
                        break;
                    }

                    Conta contaDebitar = null;
                    Conta contaCreditar = null;

                    System.out.print("\nContas cadastradas:\n");

                    for(Conta c : listaContas){
                        System.out.println("\nNúmero conta: " + c.getNumeroConta() + "\nTitular: " + c.getCliente().getNome());
                    }

                    System.out.print("\nEscolha uma conta para debitar: ");
                    int posicaoContaDebitar = sc.nextInt();
                    contaDebitar = Conta.listaContas.get(posicaoContaDebitar - 1);

                    System.out.print("\nEscolha uma conta para creditar: ");
                    int posicaoContaCreditar = sc.nextInt();
                    contaCreditar = Conta.listaContas.get(posicaoContaCreditar - 1);

                    System.out.print("Digite o valor do transferência: R$ ");
                    float valorTransferencia = sc.nextFloat();

                    if(posicaoContaCreditar == posicaoContaDebitar){
                        System.out.println("\nAs contas precisam ser diferentes!");
                        break;
                    }

                    if(contaDebitar instanceof ContaCorrente){
                        try {
                            ((ContaCorrente) contaDebitar).sacar(valorTransferencia);
                            if (contaCreditar instanceof ContaCorrente){
                                ((ContaCorrente) contaCreditar).depositar(valorTransferencia);
                            } else {
                                ((ContaPoupanca) contaCreditar).depositar(valorTransferencia);
                            }
                        } catch (ExceptionsConta e) {
                            System.out.println("\n" + e.getMessage());
                        }

                    }

                    if(contaDebitar instanceof ContaPoupanca){
                        try {
                            ((ContaPoupanca) contaDebitar).sacar(valorTransferencia);
                            if (contaCreditar instanceof ContaCorrente){
                                ((ContaCorrente) contaCreditar).depositar(valorTransferencia);
                            } else {
                                ((ContaPoupanca) contaCreditar).depositar(valorTransferencia);
                            }
                        } catch (ExceptionsConta e) {
                            System.out.println("\n" + e.getMessage());
                        }

                    }

                    break;

                case 7:

                    if(Banco.listaBancos.isEmpty()){
                        System.out.println("\nNenhum banco cadastrado.");
                        break;
                    }

                    System.out.print("\n");
                    for(Banco b : Banco.listaBancos){
                        System.out.println(b.exibirDadosBanco() + "\n");
                    }

                    break;

                case 8:

                    if(Cliente.listaClientes.isEmpty()){
                        System.out.println("\nNenhum cliente cadastrado.");
                        break;
                    }

                    System.out.print("\n");
                    for(Cliente c : Cliente.listaClientes){
                        System.out.println(c.exibeDadosCliente() + "\n");
                    }

                    break;

                case 9:

                    if(Conta.listaContas.isEmpty()){
                        System.out.println("\nNenhuma conta cadastrada.");
                        break;
                    }

                    for (Conta conta : listaContas) {
                        if (conta instanceof ContaCorrente) {
                            ContaCorrente contaCorrente = (ContaCorrente) conta;
                            System.out.println(contaCorrente.exibirDadosConta());
                        } else if (conta instanceof ContaPoupanca) {
                            ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
                            System.out.println(contaPoupanca.exibirDadosConta());
                        }
                    }

                    break;

                case 10:

                    System.out.println("\nSaindo...");
                    controleWhile = false;
                    return;

                default:
                    System.out.println("\nOpção inválida, tente novamente.");
            }
        }

        sc.close();

    }
}