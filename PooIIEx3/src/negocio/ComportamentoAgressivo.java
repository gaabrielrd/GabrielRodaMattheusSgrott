package negocio;

public class ComportamentoAgressivo implements Comportamento {

    public void getAcao(Inimigo inimigo, Jogador alvo) {
        Acoes acao = new Acoes();
        acao.msgAtacar(inimigo.getBootId());
        alvo.isKill();
    }

    public void getReacao(Inimigo inimigo, Jogador alvo) {
        Acoes acao = new Acoes();
        acao.msgAtacar(inimigo.getBootId());
    }
}
