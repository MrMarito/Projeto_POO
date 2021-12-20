package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe dos membros efetivos
 */
public class MembroEfetivo extends Investigador implements Serializable {
    private int numGabinete;
    private int numTelemovel;

    public MembroEfetivo(){}
    public MembroEfetivo(int numGabinete, int numTelemovel) {
        this.numGabinete = numGabinete;
        this.numTelemovel = numTelemovel;
    }
    public MembroEfetivo(String nome, String email, GrupoDeInvestigacao grupo, int numGabinete, int numTelemovel) {
        super(nome, email, grupo);
        this.numGabinete = numGabinete;
        this.numTelemovel = numTelemovel;
    }
    public MembroEfetivo(String nome, String email, int numGabinete, int numTelemovel) {
        super(nome, email);
        this.numGabinete = numGabinete;
        this.numTelemovel = numTelemovel;
    }
    public int getNumGabinete() {
        return numGabinete;
    }
    public void setNumGabinete(int numGabinete) {
        this.numGabinete = numGabinete;
    }
    public int getNumTelemovel() {
        return numTelemovel;
    }
    public void setNumTelemovel(int numTelemovel) {
        this.numTelemovel = numTelemovel;
    }
    public String toString(){
        return nome + " " + email + " " + grupo.acronimo + " " + numGabinete + " " + numTelemovel;
    }
    /**
     * Esta funcao verifica se o investigaor e membro efetivo, pois se for da return 2.
     * @return Da return 2.
     */
    public int check(){
        return 2;
    }
}
