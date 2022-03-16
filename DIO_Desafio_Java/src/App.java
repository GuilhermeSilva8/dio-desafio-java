public class App {
    public static void main(String[] args) throws Exception {
        Cliente guilherme = new Cliente();
        guilherme.setNome("guilherme");
        
        Conta cc = new ContaCorrente(guilherme);
        Conta poupanca = new ContaPoupanca(guilherme);

        cc.depositar(100);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
