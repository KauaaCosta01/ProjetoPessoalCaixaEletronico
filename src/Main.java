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


        System.out.println("\n=== Login Conta Bancária ===");
        System.out.println("Digite seu Usuário: ");
        String usuarioLogin = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senhaLogin = scanner.nextLine();

        if (usuario.equals(usuarioLogin) && senha.equals(senhaLogin)) {

            System.out.println("Acesso Permitido!");
            System.out.println("\nDigite seu saldo: R$ ");
            double saldo = scanner.nextDouble();
            int servicos;
            do {
                System.out.println("\n=== Serviços ===");
                System.out.println("Escolha um dos serviços disponíveis: \n1 - Ver Saldo \n2 - Depositar \n3 - Sacar \n4 - Sair");
                servicos = scanner.nextInt();

                switch (servicos) {
                    case 1:
                        System.out.printf("Saldo Atual: R$ %.2f", saldo);
                        continue;
                    case 2:
                        System.out.println("Digite o valor que deseja depositar: R$");
                        double valorDepositar = scanner.nextDouble();
                        System.out.println("Depósito de R$ " + valorDepositar + " realizado com sucesso!");
                        saldo += valorDepositar;
                        System.out.printf("Saldo Atual: R$ %.2f", saldo);
                        continue;
                    case 3:
                        System.out.println("Digite o valor que deseja sacar: R$ ");
                        double valorSacar = scanner.nextDouble();
                        if (valorSacar > saldo) {
                            System.out.println("Saldo Insuficiente!");
                        } else if (valorSacar < saldo) {
                            System.out.println("Saque de R$: " + valorSacar + " efeutado com sucesso!");
                            saldo -= valorSacar;
                            System.out.printf("Saldo Atual: R$ %.2f", saldo);
                        } else {
                            System.out.println("Valor Inválido, tente novamente!");
                            continue;
                        }
                    case 4:
                        System.out.println("Encerrando Sessão");
                }
            } while (servicos  != 4);
        } else {
            System.out.println("Erro! senha ou usuário Inválidos, programa encerrado!");
        }

        scanner.close();
    }
}