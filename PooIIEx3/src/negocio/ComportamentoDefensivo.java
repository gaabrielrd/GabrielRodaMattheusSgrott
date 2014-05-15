package negocio;


public class ComportamentoDefensivo implements Comportamento {

	public ComportamentoDefensivo(){

	}


	public void getAcao(Inimigo inimigo, Jogador alvo){
           Acoes acao = new Acoes();
           acao.msgDefender(inimigo.getBootId());
	}

	public void getReacao(Inimigo inimigo, Jogador alvo){
           Acoes acao = new Acoes();
           acao.msgDefender(inimigo.getBootId());           
	}
}