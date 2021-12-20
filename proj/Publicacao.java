package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe das publicacoes
 */
public abstract class Publicacao implements Serializable {
    protected String autores;
    protected String titulo;
    protected String palavraChave;
    protected int ano;
    protected String tipo;
    protected int dimensao;

    public Publicacao(){}
    public Publicacao(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao) {
        this.autores = autores;
        this.titulo = titulo;
        this.palavraChave = palavraChave;
        this.ano = ano;
        this.tipo = tipo;
        this.dimensao = dimensao;
    }
    public String getAutores() {
        return autores;
    }
    public void setAutores(String autores) {
        this.autores = autores;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getPalavraChave() {
        return palavraChave;
    }
    public void setPalavraChave(String palavraChave) {
        this.palavraChave = palavraChave;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getDimensao() {
        return dimensao;
    }
    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }
    public String toString(){
        return autores + " " + titulo +  " " + palavraChave +  " " + ano +  " " + tipo +  " " + dimensao;
    }
}