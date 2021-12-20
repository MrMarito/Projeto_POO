package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe Artigo De Conferencia
 */
public class ArtigoDeConferencia extends Publicacao implements Serializable {
    private String resumo;
    private String nomeConferencia;
    private Data dataConferencia;
    private String localizacao;
    private String fator;

    public ArtigoDeConferencia(){}
    public ArtigoDeConferencia(String resumo, String nomeConferencia, Data dataConferencia, String localizacao) {
        this.resumo = resumo;
        this.nomeConferencia = nomeConferencia;
        this.dataConferencia = dataConferencia;
        this.localizacao = localizacao;
    }
    public ArtigoDeConferencia(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String nomeConferencia, Data dataConferencia, String localizacao) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao);
        this.resumo = resumo;
        this.nomeConferencia = nomeConferencia;
        this.dataConferencia = dataConferencia;
        this.localizacao = localizacao;
    }
    public ArtigoDeConferencia(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String nomeConferencia, String localizacao) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao);
        this.resumo = resumo;
        this.nomeConferencia = nomeConferencia;
        this.localizacao = localizacao;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public String getNomeConferencia() {
        return nomeConferencia;
    }
    public void setNomeConferencia(String nomeConferencia) {
        this.nomeConferencia = nomeConferencia;
    }
    public Data getDataConferencia() {
        return dataConferencia;
    }
    public void setDataConferencia(Data dataConferencia) {
        this.dataConferencia = dataConferencia;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public String toString(){
        if(dimensao >= 500)
            fator = "A";
        if(dimensao < 500 && dimensao >= 200)
            fator = "B";
        if(dimensao < 200)
            fator = "C";
        return autores + " " + titulo + " " + palavraChave + " " + ano + " " + tipo + " " + fator + " " + resumo + " " + nomeConferencia + " " + dataConferencia + " " + localizacao;
    }
}
