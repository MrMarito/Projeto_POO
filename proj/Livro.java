package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe Livro
 */
public class Livro extends Publicacao implements Serializable {
    protected String resumo;
    protected String editora;
    protected int IBSN;
    private String fator;

    public Livro(){}
    public Livro(String resumo, String editora, int IBSN) {
        this.resumo = resumo;
        this.editora = editora;
        this.IBSN = IBSN;
    }
    public Livro(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String editora, int IBSN) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao);
        this.resumo = resumo;
        this.editora = editora;
        this.IBSN = IBSN;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public int getIBSN() {
        return IBSN;
    }
    public void setIBSN(int IBSN) {
        this.IBSN = IBSN;
    }
    public String toString(){
        if(dimensao >= 10000)
            fator = "A";
        if(dimensao < 10000 && dimensao >= 5000)
            fator = "B";
        if(dimensao < 5000)
            fator = "C";
        return autores + " " + titulo + " " + palavraChave + " " + ano + " " + tipo + " " + fator + " " + resumo + " " + editora + " " + IBSN;
    }
}
