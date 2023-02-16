public class CalculadorImposto {

    private double totalImposto;

    public double getTotalImposto() {
        return totalImposto;
    }

    public void registra(Tributavel t) {

        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }
}
