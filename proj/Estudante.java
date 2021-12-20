package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe estudante
 */
public class Estudante extends Investigador implements Serializable {
    private String tituloTese;
    private Data conclusao;
    private Investigador orientador;

    public Estudante(){}
    public Estudante(String tituloTese, Data conclusao, Investigador orientador) {
        this.tituloTese = tituloTese;
        this.conclusao = conclusao;
        this.orientador = orientador;
    }
    public Estudante(String nome, String email, String tituloTese){
        super(nome, email);
        this.tituloTese = tituloTese;
    }
    public Estudante(String nome, String email, GrupoDeInvestigacao grupo, String tese){
        super(nome, email, grupo);
        this.tituloTese = tese;
    }
    public Estudante(String nome, String email, GrupoDeInvestigacao grupo, String tituloTese, Data conclusao, Investigador orientador) {
        super(nome, email, grupo);
        this.tituloTese = tituloTese;
        this.conclusao = conclusao;
        this.orientador = orientador;
    }
    public String getTituloTese() {
        return tituloTese;
    }
    public void setTituloTese(String tituloTese) {
        this.tituloTese = tituloTese;
    }
    public Data getConclusao() {
        return conclusao;
    }
    public void setConclusao(Data conclusao) {
        this.conclusao = conclusao;
    }
    public Investigador getOrientador() {
        return orientador;
    }
    public void setOrientador(Investigador orientador) {
        this.orientador = orientador;
    }
    public String toString(){
        return nome + " " + email + " " + grupo.acronimo + " " + tituloTese + " " + conclusao + " " + orientador;
    }
    /**
     * Esta funcao verifica se o investigadoe e estudante, pois se for da return 1.
     * @return Da return 1.
     */
    public int check(){
        return 1;
    }
}
