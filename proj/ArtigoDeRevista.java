package Projeto;
import java.io.Serializable;

/**
 * Esta e a classe Artigo De Revista
 */
public class ArtigoDeRevista extends Publicacao implements Serializable {
    private String resumo;
    private String nomeRevista;
    private Data data;
    private int numeroRevista;
    private String fator;

    public ArtigoDeRevista(){}
    public ArtigoDeRevista(String resumo, String nomeRevista, Data data, int numeroRevista) {
        this.resumo = resumo;
        this.nomeRevista = nomeRevista;
        this.data = data;
        this.numeroRevista = numeroRevista;
    }
    public ArtigoDeRevista(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String nomeRevista, Data data, int numeroRevista) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao);
        this.resumo = resumo;
        this.nomeRevista = nomeRevista;
        this.data = data;
        this.numeroRevista = numeroRevista;
    }
    public ArtigoDeRevista(String autores, String titulo, String palavraChave, int ano, String tipo, int dimensao, String resumo, String nomeRevista, int numeroRevista) {
        super(autores, titulo, palavraChave, ano, tipo, dimensao);
        this.resumo = resumo;
        this.nomeRevista = nomeRevista;
        this.numeroRevista = numeroRevista;
    }
    public String getResumo() {
        return resumo;
    }
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    public String getNomeRevista() {
        return nomeRevista;
    }
    public void setNomeRevista(String nomeRevista) {
        this.nomeRevista = nomeRevista;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
    public int getNumeroRevista() {
        return numeroRevista;
    }
    public void setNumeroRevista(int numeroRevista) {
        this.numeroRevista = numeroRevista;
    }
    public String toString(){
        if(dimensao >= 1000)
            fator = "A";
        if(dimensao < 1000 && dimensao >= 500)
            fator = "B";
        if(dimensao < 500)
            fator = "C";
        return autores + " " + titulo + " " + palavraChave + " " + ano + " " + tipo + " " + fator + " " + resumo + " " + nomeRevista + " " + data + " " + numeroRevista;
    }
}
