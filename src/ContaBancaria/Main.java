package ContaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criando um banco com capacidade para 3 contas
        Banco banco = new Banco(3);

        // === Cadastro de contas ===
        System.out.println("=== Cadastro de Contas Bancárias ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("\nDigite o usuário da conta " + (i + 1) + ": ");
            String usuario = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();

            System.out.print("Digite o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();
            scanner.nextLine(); // limpar buffer

            banco.cadastrarConta(usuario, senha, saldoInicial);
        }

        // === Tela de Login ===
        ContaBancaria contaLogada = null;
        int tentativas = 0;

        while (tentativas < 3 && contaLogada == null) {
            System.out.println("\n=== Login Conta Bancária ===");
            System.out.print("Digite o usuário: ");
            String usuarioLogin = scanner.nextLine();

            System.out.print("Digite a senha: ");
            String senhaLogin = scanner.nextLine();

            contaLogada = banco.login(usuarioLogin, senhaLogin);

            if (contaLogada == null) {
                tentativas++;
                System.out.println("Usuário ou senha incorretos! Tentativas restantes: " + (3 - tentativas));
            }
        }

        if (contaLogada == null) {
            System.out.println("Conta bloqueada! Tente novamente mais tarde.");
            scanner.close();
            return;
        }

        // === Menu de serviços ===
        int servicos;
        do {
            System.out.println("\n=== Serviços ===");
            System.out.println("1 - Ver Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            servicos = scanner.nextInt();

            switch (servicos) {
                case 1:
                    System.out.printf("Saldo Atual: R$ %.2f\n", contaLogada.getSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaLogada.depositar(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double valorSaque = scanner.nextDouble();
                    contaLogada.sacar(valorSaque);
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (servicos != 4);

        scanner.close();
    }
}
