package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe do Capitulo Livro
 */
public class CapituloLivro extends Livro implements Serializable {
    private String nomdeCapitulo;
    private int paginaInicio;
    private int paginaFim;
    private String fator;

    public CapituloLivro(){}
    public CapituloLivro(String nomdeCapitulo, int paginaInicio, int paginaFim) {
        this.nomdeCapitulo = nomdeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFim = paginaFim;
    }
    public CapituloLivro(String resumo, String editora, int IBSN, String nomdeCapitulo, int paginaInicio, int paginaFim) {
        super(resumo, editora, IBSN);
        this.nomdeCapitulo = nomdeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFim = paginaFim;
    }
    public CapituloLivro(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String editora, int IBSN, String nomdeCapitulo, int paginaInicio, int paginaFim) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao, resumo, editora, IBSN);
        this.nomdeCapitulo = nomdeCapitulo;
        this.paginaInicio = paginaInicio;
        this.paginaFim = paginaFim;
    }
    public String getNomdeCapitulo() {
        return nomdeCapitulo;
    }
    public void setNomdeCapitulo(String nomdeCapitulo) {
        this.nomdeCapitulo = nomdeCapitulo;
    }
    public int getPaginaInicio() {
        return paginaInicio;
    }
    public void setPaginaInicio(int paginaInicio) {
        this.paginaInicio = paginaInicio;
    }
    public int getPaginaFim() {
        return paginaFim;
    }
    public void setPaginaFim(int paginaFim) {
        this.paginaFim = paginaFim;
    }
    public String toString(){
        if(dimensao>= 10000)
            fator = "A";
        if(dimensao < 10000 && dimensao >= 5000)
            fator = "B";
        if(dimensao < 5000)
            fator = "C";
        return autores + " " + titulo + " " + palavraChave + " " + ano + " " + tipo + " " + fator + " " + resumo + " " + editora + " " + IBSN + " " + nomdeCapitulo + " " + paginaInicio + " " + paginaFim;
    }
}