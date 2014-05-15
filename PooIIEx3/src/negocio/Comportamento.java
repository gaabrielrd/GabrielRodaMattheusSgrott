package negocio;


public interface Comportamento {

	public void getAcao(Inimigo inimigo, Jogador alvo);

	public void getReacao(Inimigo inimigo, Jogador alvo);

}