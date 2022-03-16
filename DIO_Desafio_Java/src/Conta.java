public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.setCliente(cliente);
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public int sacar(double valor) {
        if(this.getSaldo() < valor) {
            System.out.println("Saldo insuficiente para saque");
            return -1;
        }
        else {
            saldo -= valor;
        }
        return 1;
        
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        //this.sacar(valor);
        //contaDestino.depositar(valor);
        if(this.sacar(valor) == -1) {
            System.out.println("Não foi possivel realizar a transferência");
        } else {
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Agencia: %.2f", this.saldo));
    }
}
