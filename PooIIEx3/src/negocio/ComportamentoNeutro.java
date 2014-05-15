package negocio;

public class ComportamentoNeutro implements Comportamento {

    public ComportamentoNeutro() {

    }

    public void getAcao(Inimigo inimigo, Jogador alvo) {
        if (inimigo.isArmado()) {
            Acoes acao = new Acoes();
            acao.msgAtacar(inimigo.getBootId());
            alvo.isKill();
        } else {
            Acoes acao = new Acoes();
            acao.msgDefender(inimigo.getBootId());
        }
    }

    public void getReacao(Inimigo inimigo, Jogador alvo) {
        if (inimigo.isArmado()) {
            Acoes acao = new Acoes();
            acao.msgAtacar(inimigo.getBootId());
        } else {
            Acoes acao = new Acoes();
            acao.msgDefender(inimigo.getBootId());
        }
    }
}
