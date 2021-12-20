package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe Investigador
 */
public abstract class Investigador implements Serializable {
    protected String nome;
    protected String email;
    protected GrupoDeInvestigacao grupo;

    public Investigador(){}
    public Investigador(String nome, String email, GrupoDeInvestigacao grupo) {
        this.nome = nome;
        this.email = email;
        this.grupo = grupo;
    }
    public Investigador(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public GrupoDeInvestigacao getGrupo() {
        return grupo;
    }
    public void setGrupo(GrupoDeInvestigacao grupo) {
        this.grupo = grupo;
    }
    public String toString(){
        return nome + " " + email + " " + grupo.acronimo;
    }
    public int check(){
        return 0;
    }
}