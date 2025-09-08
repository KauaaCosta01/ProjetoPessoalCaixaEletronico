package ContaBancaria;

// Classe que representa uma conta bancária
public class ContaBancaria {
    private String usuario; // Nome do usuário da conta
    private String senha;   // Senha da conta
    private double saldo;   // Saldo atual

    // Construtor da conta (inicializa usuário, senha e saldo)
    public ContaBancaria(String usuario, String senha, double saldoInicial) {
        this.usuario = usuario;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    // Getter para pegar o usuário
    public String getUsuario() {
        return usuario;
    }

    // Método que valida login (confere usuário e senha)
    public boolean validarLogin(String usuario, String senha) {
        return this.usuario.equals(usuario) && this.senha.equals(senha);
    }

    // Método para ver o saldo
    public double getSaldo() {
        return saldo;
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!\n", valor);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
        } else if (valor > saldo) {
            System.out.println("Erro! Saldo insuficiente.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso!\n", valor);
        }
    }

    // Método para transferir dinheiro para outra conta
    public void transferir(ContaBancaria destino, double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência!");
        } else if (valor > saldo) {
            System.out.println("Erro! Saldo insuficiente para transferência.");
        } else {
            this.saldo -= valor; // retira da conta de origem
            destino.depositar(valor); // adiciona na conta de destino
            System.out.printf("Transferência de R$ %.2f para %s realizada com sucesso!\n",
                    valor, destino.getUsuario());
        }
    }

    // Futuras Implementações
}
