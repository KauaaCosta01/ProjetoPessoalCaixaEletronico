import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Limite de contas que o banco pode ter
        final int MAX_CONTAS = 3;

        // Arrays para armazenar(Usuário, Senha e Saldo)
        String[] usuarios = new String[MAX_CONTAS];
        String[] senhas = new String[MAX_CONTAS];
        double[] saldos =  new double[MAX_CONTAS];

        // Cadastro das contas
        System.out.println("=== Cadastro de Contas Bancárias");
        for (int i = 0; i <MAX_CONTAS; i++) {
            System.out.println("\nCadastro da Conta: " + (i + 1));
            System.out.println("Digite o Usuário: ");
            usuarios[i] = scanner.nextLine();
            System.out.println("Digite o Senha: ");
            senhas[i] = scanner.nextLine();
            System.out.println("Digite o Saldo Inical: ");
            saldos[i] = scanner.nextDouble();

            scanner.nextLine();

            System.out.println("Conta Cadastrada com Sucesso!");
        }

        // Tela de Login
        boolean acessoPermitido = false;
        int contaLogada = -1;
        int tentavivas = 0;

        while (tentavivas < 3 && !acessoPermitido) {
            System.out.println("\n === Login Conta Bancária ===");
            System.out.println("Digite seu usuário: ");
            String usuarioLogin = scanner.nextLine();
            System.out.println("Digite seu senha: ");
            String senhaLogin = scanner.nextLine();

            // Verificando se o Usuário e senha Existem em alguma conta
            for (int i = 0; i < MAX_CONTAS; i++) {
                if (usuarios[i].equals(usuarioLogin) && senhas[i].equals(senhaLogin)) {
                    acessoPermitido = true;
                    contaLogada = i;
                    break;
                }
            }

            if (!acessoPermitido) {
                System.out.println("Usuário ou senhas incorretas! Tentativas restantes: " + (3 - tentavivas));
            }
        }

        // Se não conseguir logar em 3 tentativas
        if (!acessoPermitido) {
            System.out.println("Conta Bloqueada! Tente novamente mais tarde.");
            scanner.close();
            return;
        }

        // == Menu de Serviços == //
        int servicos;
        do {
            System.out.println("\n=== Serviços ===");
            System.out.println("1 - Ver Saldo \n2 - Depositar \n3 - Sacar \n4 - Sair");
            System.out.println("Escolha uma opção: ");
            servicos = scanner.nextInt();

            switch (servicos) {
                case 1:
                    System.out.printf("Saldo Atual: R$ %.2f", saldos[contaLogada]);
                    break;
                case 2:
                    System.out.println("Digite o valor que deseja depositar: ");
                    double valorDepositar = scanner.nextDouble();
                    if (valorDepositar > 0) {
                        saldos[contaLogada] += valorDepositar;
                        System.out.println("Deposito realizado com sucesso!");
                        System.out.printf("Saldo Atual: R$ %.2f", saldos[contaLogada]);
                    } else {
                        System.out.println("Valor inválido");
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja sacar: ");
                    double valorSacar = scanner.nextDouble();
                    if (valorSacar > saldos[contaLogada]) {
                        System.out.println("Erro! Saldo Insuficiente!");
                    } else {
                        saldos[contaLogada] -= valorSacar;
                        System.out.println("Saque realizado com sucesso!");
                        System.out.printf("Saldo Atual: R$ %.2f", saldos[contaLogada]);
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o Sistema...");
                    break;
                default:
                    System.out.println("opção Inválida! Tente Novamente.");
            }

        } while (servicos != 4);

        scanner.close();
    }
}