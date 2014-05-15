package negocio;

public class Inimigo {

    public Comportamento comportamento;
    private int bootId;
    private boolean armado;
    private String arma;

    public Inimigo(int id, String arma) {
        this.setComportamento(new ComportamentoNeutro());
        this.setBootId(id);
        this.setArma(arma);
    }

    public void setComportamento(Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public void acao(Jogador alvo) {
        this.comportamento.getAcao(this, alvo);
    }

    public void reacao(Jogador alvo) {
        this.comportamento.getReacao(this, alvo);
    }

    public String getBootId() {
        return "" + this.bootId;
    }

    public void setBootId(int bootId) {
        this.bootId = bootId;
    }

    public boolean isArmado() {
        return armado;
    }

    public void setArmado(boolean armado) {
        this.armado = armado;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
        if (getArma().equals("")) {
            this.setArmado(false);
        } else {
            setArmado(true);
        }
    }
}
