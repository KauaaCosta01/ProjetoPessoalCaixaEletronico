import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Scanner scanner =  new Scanner(System.in);
        System.out.println("=== Cadastro Bancário ===");

        System.out.println("Digite seu usuário: ");
        String usuario = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        System.out.println("Cadastro Realizado com sucesso!");


        // Login com 3 Tentativas
        boolean acessoPermitido = false;
        int tentativas = 0;

        while (tentativas < 3) {
            System.out.println("\n=== Login conta Bancária ===");
            System.out.println("Digite seu usuario: ");
            String usuarioLogin =  scanner.nextLine();
            System.out.println("Digite a senha: ");
            String senhaLogin = scanner.nextLine();

            // Validação do Login
            if (usuario.equals(usuarioLogin) && senha.equals(senhaLogin)) {
                System.out.println("Login realizado com sucesso!");
                acessoPermitido = true;
                break;
            } else {
                System.out.println("Usuário ou senha incorretos! Tentavias Restantes: " + (3 -  tentativas));
            }
        }

        if (!acessoPermitido) {
            System.out.println("Conta Bloqueada! Tente Novamente mais tarde.");
            scanner.close();
            return;
        }

        // Menu Bancário
        System.out.println("\nDigite seu saldo inicial: R$ ");
        double saldo =  scanner.nextDouble();

        int servicos;
        do {
            System.out.println("\n=== Serviços ====");
            System.out.println("Escolha um dos Serviços: ");
            System.out.println("\n1 - Ver Saldo \n2 - Depositar\n3 - Sacar \n4 - Sair");
            servicos = scanner.nextInt();

            switch (servicos) {
                case 1:
                    System.out.printf("Saldo Atual: R$ %.2f", saldo);
                    break;

                case 2:
                    System.out.println("Digite o valor que deseja depositar: R$ ");
                    double valorDepositar = scanner.nextDouble();
                    if (valorDepositar > 0) {
                        saldo += valorDepositar;
                        System.out.println("Depósito Realizado com sucesso!");
                    } else {
                        System.out.println("Valor inválido para depósito");
                    }
                    System.out.printf("Saldo Atual: R$ %.2f", saldo);
                    break;

                case 3:
                    System.out.println("Digite o valor que deseja sacar: R$ ");
                    double valorSacar = scanner.nextDouble();
                    if (valorSacar > saldo) {
                        System.out.println("Saldo Insuficiente");
                    } else if (valorSacar > 0) {
                        saldo -= valorSacar;
                        System.out.println("Saque Realizado com sucesso!");
                    } else{
                        System.out.println("Valor Inválido!");
                    }
                    System.out.printf("Saldo Atual: R$ %.2f", saldo);
                    break;

                case 4:
                    System.out.println("Encerrando o Sistema...");
                    break;

                default:
                    System.out.println("Opção Inválida! Tente novamente.");
            }
        } while (servicos != 4);

        scanner.close();
    }
}