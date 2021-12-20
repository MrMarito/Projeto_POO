package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe do Livro Artigo de Conferencia
 */
public class LivroArtigoConferencia extends Livro implements Serializable {
    private String nomeConferencia;
    private int numArtigos;
    private String fator;

    public LivroArtigoConferencia(){}
    public LivroArtigoConferencia(String nomeConferencia, int numArtigos) {
        this.nomeConferencia = nomeConferencia;
        this.numArtigos = numArtigos;
    }
    public LivroArtigoConferencia(String resumo, String editora, int IBSN, String nomeConferencia, int numArtigos) {
        super(resumo, editora, IBSN);
        this.nomeConferencia = nomeConferencia;
        this.numArtigos = numArtigos;
    }
    public LivroArtigoConferencia(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String editora, int IBSN, String nomeConferencia, int numArtigos) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao, resumo, editora, IBSN);
        this.nomeConferencia = nomeConferencia;
        this.numArtigos = numArtigos;
    }
    public String getNomeConferencia() {
        return nomeConferencia;
    }
    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }
    public int getNumArtigos() {
        return numArtigos;
    }
    public void setNumArtigos(int numArtigos) {
        this.numArtigos = numArtigos;
    }
    public String toString(){
        if(dimensao >= 7500)
            fator = "A";
        if(dimensao < 7500 && dimensao >= 2500)
            fator = "B";
        if(dimensao < 2500)
            fator = "C";
        return autores + " " + titulo + " " + palavraChave + " " + ano + " " + tipo + " " + fator + " " + resumo + " " + editora + " " + IBSN + " " + nomeConferencia + " " + numArtigos;
    }
}
