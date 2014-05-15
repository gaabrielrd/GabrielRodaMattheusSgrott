package negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Jogo {

    private ArrayList<Inimigo> bots = new ArrayList<Inimigo>();
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private static Jogo uniqueInstance;
    private String mapa;
    private String armaBoot;
    private final Random randomGenerator = new Random();

    private Jogo() {
    }

    public Jogador jogadorAleatorio() {
        Integer i = Math.abs(randomGenerator.nextInt(jogadores.size()));
        return jogadores.get(i);
    }

    public Inimigo inimigoAleatorio() {
        Integer i = Math.abs(randomGenerator.nextInt(bots.size()));
        return bots.get(i);
    }

    public void setArmaBoot(String arma) {
        this.armaBoot = arma;
    }

    public String getArmaBoot() {
        return this.armaBoot;
    }

    public void setComportamento(int i, Comportamento comportamento) {
        bots.get(i).setComportamento(comportamento);
    }

    public void setDificuldade(int nivel) {
        switch (nivel) {
            case 1:
                for (int i = 1; i <= ((jogadores.size() / 3) * 2); i++) {
                    bots.add(new Inimigo(i, this.getArmaBoot()));
                }
                break;
            case 2:
                for (int i = 1; i <= jogadores.size(); i++) {
                    bots.add(new Inimigo(i, this.getArmaBoot()));
                }
                break;
            case 3:
                for (int i = 1; i <= (jogadores.size() * 2); i++) {
                    bots.add(new Inimigo(i, this.getArmaBoot()));
                }
        }
    }

    public void addJogador(String nome, String arma) {
        jogadores.add(new Jogador(nome, arma));
    }

    public static Jogo getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Jogo();
        }
        return uniqueInstance;
    }

    public String getMapa() {
        return mapa;
    }

    public void setMapa(String mapa) {
        this.mapa = mapa;
    }

    public void removeGenteMorta() {
        Iterator<Jogador> jogadorIterator = jogadores.iterator();
        while (jogadorIterator.hasNext()) {
            Jogador next = jogadorIterator.next();
            if (next.estaMorto()) {
                jogadorIterator.remove();
            }
        }
    }

    public void quemTaVivoLevantaAMao() {
        for (Jogador j : jogadores) {
            System.out.println(j.getNome() + " continua vivo");
        }
    }

    public void botsAtiram(int quantos) {
        for (int i = 0; i < quantos; i++) {
            inimigoAleatorio().acao(jogadorAleatorio());
            removeGenteMorta();
        }
        quemTaVivoLevantaAMao();
    }

    public void botAtira(int i) {
        bots.get(i).acao(jogadorAleatorio());
        removeGenteMorta();
        quemTaVivoLevantaAMao();
    }

}
