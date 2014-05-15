package negocio;

public class MainClass {
    public static void main(String[] args) {
        Jogo.getInstance().addJogador("Jose", "Desert Eagle");
        Jogo.getInstance().addJogador("João", "Desert Eagle");
        Jogo.getInstance().addJogador("Mário", "Desert Eagle");
        Jogo.getInstance().addJogador("Márcio", "Desert Eagle");
        Jogo.getInstance().addJogador("Marílio", "Desert Eagle");
        
        Jogo.getInstance().setArmaBoot("AK47");
        Jogo.getInstance().setDificuldade(2);
        
        Jogo.getInstance().botsAtiram(3);
        
        Jogo.getInstance().setComportamento(1, new ComportamentoDefensivo());
        Jogo.getInstance().botAtira(1);
    }
}
