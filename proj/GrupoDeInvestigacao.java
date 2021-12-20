package Projeto;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta e a classe Grupo de Investigacao
 */
public class GrupoDeInvestigacao implements Serializable {
    protected String nome;
    protected String acronimo;
    protected Investigador responsavel;
    protected ArrayList<Investigador> membros;

    public GrupoDeInvestigacao(){
        membros = new ArrayList<>();
    }
    public GrupoDeInvestigacao(String nome, String acronimo){
        this.nome = nome;
        this.acronimo = acronimo;
    }
    public GrupoDeInvestigacao(String nome, String acronimo, Investigador responsavel){
        this.nome = nome;
        this.acronimo = acronimo;
        this.responsavel = responsavel;
        membros = new ArrayList<>();
    }
    public GrupoDeInvestigacao(String nome, String acronimo, Investigador responsavel, ArrayList<Investigador> membros) {
        this.nome = nome;
        this.acronimo = acronimo;
        this.responsavel = responsavel;
        this.membros = membros;
        membros = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAcronimo() {
        return acronimo;
    }
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }
    public Investigador getResponsavel() {
        return responsavel;
    }
    public void setResponsavel(Investigador responsavel) {
        this.responsavel = responsavel;
    }
    public ArrayList<Investigador> getMembros() {
        return membros;
    }
    public void setMembros(ArrayList<Investigador> membros) {
        this.membros = membros;
    }
    public String toString(){
        return nome + " " + acronimo + " " + responsavel + " " + membros;
    }
}