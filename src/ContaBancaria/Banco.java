package ContaBancaria;

// Classe Banco que gerencia várias contas
public class Banco {
    private ContaBancaria[] contas; // Lista de contas
    private int totalContas;       // Quantas contas foram cadastradas

    // Construtor do Banco (define número máximo de contas)
    public Banco(int capacidade) {
        contas = new ContaBancaria[capacidade];
        totalContas = 0;
    }

    // Método para cadastrar uma nova conta
    public void cadastrarConta(String usuario, String senha, double saldoInicial) {
        if (totalContas < contas.length) {
            contas[totalContas] = new ContaBancaria(usuario, senha, saldoInicial);
            totalContas++;
            System.out.println("Conta cadastrada com sucesso!");
        } else {
            System.out.println("Limite de contas atingido!");
        }
    }

    // Método para realizar login e retornar a conta logada
    public ContaBancaria login(String usuario, String senha) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].validarLogin(usuario, senha)) {
                return contas[i]; // Retorna a conta logada
            }
        }
        return null; // Se não encontrar, retorna nulo
    }

    // Método para buscar uma conta pelo nome de usuário
    public ContaBancaria buscarConta(String usuario) {
        for (int i = 0; i < totalContas; i++) {
            if (contas[i].getUsuario().equals(usuario)) {
                return contas[i];
            }
        }
        return null; // Se não encontrar, retorna nulo
    }
}
