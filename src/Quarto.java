public class Quarto {
    private Integer quantDisp;
    private Integer tipo;
    private String modelo;
    private Integer preco;

    public Quarto(Integer quantDisp, Integer tipo, String modelo, Integer preco) {
        this.quantDisp = quantDisp;
        this.tipo = tipo;
        this.modelo = modelo;
        this.preco = preco;
    }

    public Integer getQuantDisp() {
        return quantDisp;
    }

    public void setQuantDisp(Integer quantDisp) {
        this.quantDisp = quantDisp;
    }

    public Integer getTipo() {
        return tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return quantDisp + " Tipo do QUarto " +
                tipo + " Estão disponiveis por " +
                preco + " Reais.";
    }
}
