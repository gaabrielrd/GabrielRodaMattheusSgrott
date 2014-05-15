package negocio;

import java.util.ArrayList;

public class Jogador implements Observer, Subject {

    private String nome;
    private String arma;
    private boolean isAlive = true;
    public static ArrayList<Jogador> observers = new ArrayList<Jogador>();

    public Jogador(String nome, String arma) {
        this.setNome(nome);
        this.setArma(arma);
        registerObserver(this);
    }

    public void registerObserver(Jogador observador) {
        observers.add(observador);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

    public void isKill() {
        removeObserver(this);
        isAlive = false;
        notifyObservers();
    }

    public void removeObserver(Jogador remover) {
        observers.remove(remover);
    }

    public void notifyObservers() {
        for (Jogador j : observers) {
            j.update(this);
        }
    }

    public boolean estaMorto() {
        return !isAlive;
    }

    public void update(Jogador quem) {
        alguemMorreu(quem);
    }

    public void alguemMorreu(Jogador quem) {
        System.out.println(this.getNome()
                + " está ciente de que seu companheiro " + quem.getNome()
                + " morreu. ");
    }

}
