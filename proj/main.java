package Projeto;
import java.io.*;
import java.util.*;


public class main {
    public static void main(String[] args) {
        menuInterativo();
    }
    /**
     * Esta funcao le o ficheiro que contem os grupos.
     * @return  Da return  a um ArrayList do tipo grupoDeInvestigacao com todos os grupos.
     */
    public static ArrayList<GrupoDeInvestigacao> lerGrupos(){
        File f = new File("Grupos.txt");
        ArrayList<GrupoDeInvestigacao> grupos = new ArrayList<>();
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null) {
                    String [] a = line.split(", ");
                    GrupoDeInvestigacao b = new GrupoDeInvestigacao(a[0], a[1]);
                    MembroEfetivo c = new MembroEfetivo(a[2], a[3], Integer.parseInt(a[4]), Integer.parseInt(a[5]));
                    b.setResponsavel(c);
                    c.setGrupo(b);
                    b.setResponsavel(c);
                    grupos.add(b);
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
        return grupos;
    }
    /**
     * Esta funcao le o ficheiro que contem todos os membros.
     * @param grupos A variavel e um arraylist com todos os grupos.
     * @return Da return a um ArrayList do tipo investigador com todos os membros.
     */
    public static ArrayList<Investigador> lermembros(ArrayList<GrupoDeInvestigacao> grupos){
        File f = new File("membros.txt");
        ArrayList<Investigador> todos = new ArrayList<>();
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null) {
                    String [] a = line.split(", ");
                    if(a.length == 5) {
                        for(GrupoDeInvestigacao b : grupos) {
                            if(a[2].equals(b.acronimo)) {
                                MembroEfetivo c = new MembroEfetivo(a[0], a[1], b, Integer.parseInt(a[3]), Integer.parseInt(a[4]));
                                todos.add(c);
                            }
                        }
                    }
                    else {
                        for(GrupoDeInvestigacao b : grupos) {
                            if(a[2].equals(b.acronimo)) {
                                Estudante d = new Estudante(a[0], a[1], b, a[3]);
                                String [] e = a[4].split("/");
                                Data g = new Data(Integer.parseInt(e[0]), Integer.parseInt(e[1]), Integer.parseInt(e[2]));
                                MembroEfetivo h = new MembroEfetivo(a[5], a[6], b, Integer.parseInt(a[7]), Integer.parseInt(a[8]));
                                d.setConclusao(g);
                                d.setOrientador(h);
                                todos.add(d);
                            }
                        }
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
        return todos;
    }
    /**
     * Esta funcao le todas as publicacoes.
     * @return Da return a um ArrayList do tipo publicacao com todas as publicacoes.
     */
    public static ArrayList<Publicacao> lerpublicacoes(){
        File f = new File("publicacoes.txt");
        ArrayList<Publicacao> publicacoes = new ArrayList<>();
        if(f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null){
                    String a [] = line.split(", ");
                    if(a[4].equals("Livro")){
                        Livro b = new Livro(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6], a[7], Integer.parseInt(a[8]));
                        publicacoes.add(b);
                    }
                    if(a[4].equals("CapituloLivro")){
                        CapituloLivro b = new CapituloLivro(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6], a[7], Integer.parseInt(a[8]), a[9], Integer.parseInt(a[10]), Integer.parseInt(a[11]));
                        publicacoes.add(b);
                    }
                    if(a[4].equals("LivroArtigoConferencia")){
                        LivroArtigoConferencia b = new LivroArtigoConferencia(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6], a[7], Integer.parseInt(a[8]), a[9], Integer.parseInt(a[10]));
                        publicacoes.add(b);
                    }
                    if(a[4].equals("ArtigoDeConferencia")){
                        ArtigoDeConferencia b = new ArtigoDeConferencia(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6], a[7], a[9]);
                        String d [] = a[8].split("/");
                        Data c = new Data(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
                        b.setDataConferencia(c);
                        publicacoes.add(b);
                    }
                    if(a[4].equals("ArtigoDeRevista")){
                        ArtigoDeRevista b = new ArtigoDeRevista(a[0], a[1], a[2], Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), a[6], a[7], Integer.parseInt(a[9]));
                        String d [] = a[8].split("/");
                        Data c = new Data(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]));
                        b.setData(c);
                        publicacoes.add(b);
                    }
                }
                br.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");
            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
        return publicacoes;
    }
    /**
     * Esta funcao escrever os grupos num ficheiro objeto chamado grupos.obj.
     * @param grupos Recebe um arraylist contendo todos os grupos.
     */
    public static void escrever1(ArrayList<GrupoDeInvestigacao> grupos){
        File f = new File("grupos.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(GrupoDeInvestigacao a : grupos)
                oos.writeObject(a);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
    /**
     * Esta funcao escreve os membros num ficheiro objeto chamado membros.obj.
     * @param membros Recebe um arraylist com todos os membros.
     */
    public static void escrever2(ArrayList<Investigador> membros){
        File f = new File("membros.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Investigador a : membros)
                oos.writeObject(a);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
    /**
     * Esta funcao escreve todas as publicacoes num ficheiro objeto publicacoes.obj.
     * @param publicacoes Recebe um arraylist contendo todas as publicacoes.
     */
    public static void escrever3(ArrayList<Publicacao> publicacoes){
        File f = new File("publicacoes.obj");
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for(Publicacao a : publicacoes)
                oos.writeObject(a);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
    /**
     * Esta funcao separa o arraylist de todos os membros em 6 arraylist organizados pelo respetivo grupo e da set do arraylist do tipo membros no respetivo grupo.
     * @param grupos Recebe um arraylist contendo todos os grupos.
     * @param membros Recebe um arraylist contendo todos os membros.
     */
    public static void setDosMembros(ArrayList<GrupoDeInvestigacao> grupos, ArrayList<Investigador> membros){
        ArrayList<Investigador> grupo = new ArrayList<>();
        ArrayList<Investigador> grupo1 = new ArrayList<>();
        ArrayList<Investigador> grupo2 = new ArrayList<>();
        ArrayList<Investigador> grupo3 = new ArrayList<>();
        ArrayList<Investigador> grupo4 = new ArrayList<>();
        ArrayList<Investigador> grupo5 = new ArrayList<>();
        for(Investigador a : membros){
            if(a.getGrupo().acronimo.equals("AC")){
                grupo.add(a);
            }
            if(a.getGrupo().acronimo.equals("CMS")){
                grupo1.add(a);
            }
            if(a.getGrupo().acronimo.equals("ECOS")){
                grupo2.add(a);
            }
            if(a.getGrupo().acronimo.equals("IS")){
                grupo3.add(a);
            }
            if(a.getGrupo().acronimo.equals("LCT")){
                grupo4.add(a);
            }
            if(a.getGrupo().acronimo.equals("SSE")){
                grupo5.add(a);
            }
        }
        for(GrupoDeInvestigacao a : grupos){
            if(a.getAcronimo().equals("AC"))
                a.setMembros(grupo);
            if(a.getAcronimo().equals("CMS"))
                a.setMembros(grupo1);
            if(a.getAcronimo().equals("ECOS"))
                a.setMembros(grupo2);
            if(a.getAcronimo().equals("IS"))
                a.setMembros(grupo3);
            if(a.getAcronimo().equals("LCT"))
                a.setMembros(grupo4);
            if(a.getAcronimo().equals("SSE"))
                a.setMembros(grupo5);
        }
    }
    /**
     * Esta funcao percorre um arraylist que contem todos os membros e conta quantos sao.
     * @param todos Recebe um ArrayList do tipo investigador todos que contem todos os membros.
     */
    public static void totalMembros(ArrayList<Investigador> todos){
        int count = 0;
        for(Investigador a : todos)
            count++;
        System.out.println("Total de membros: " + count);
    }
    /**
     * Esta funcao percorre o arraylist que contem todos os membros e verifica se sao membros efetivos ou estudantes contando os numero de ocorrencias de cada um.
     * @param todos Recebe um ArrayList do tipo investigador todos que contem todos os membros.
     */
    public static void membrosCategoria(ArrayList<Investigador> todos){
        int count1 = 0, count2 = 0;
        for(Investigador a : todos){
            if(a.check() == 1)
                count1++;
            else
                count2++;
        }
        System.out.println("Número de membros efetivos: " + count2);
        System.out.println("Número de estudantes: " + count1);
    }
    /**
     * Esta funcao percorre o arraylist que contem todas as publicacoes e conta o numero de publicacoes dos ultimos 5 anos.
     * @param publicacoes Recebe um ArrayList do tipo publicacao publicacoes que contem todas as publicacoes.
     */
    public static void publicacoes5(ArrayList<Publicacao> publicacoes){
        int count = 0;
        for(Publicacao a : publicacoes){
            if(a.getAno()>=2015)
                count++;
        }
        System.out.println("Número de publicações nos últimos 5 anos é: " + count);
    }
    /**
     * Esta funcao percorre todas as publicacoes e conta o numeros de publicacoes de cada tipo.
     * @param publicacoes Recebe um ArrayList do tipo publicacao publicacoes que contem todas as publicacoes.
     */
    public static void countpublicacoes(ArrayList<Publicacao> publicacoes){
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;
        for(Publicacao a : publicacoes){
            if(a.getTipo().equals("Livro"))
                count1++;
            if(a.getTipo().equals("CapituloLivro"))
                count2++;
            if(a.getTipo().equals("LivroArtigoConferencia"))
                count3++;
            if(a.getTipo().equals("ArtigoDeConferencia"))
                count4++;
            if(a.getTipo().equals("ArtigoDeRevista"))
                count5++;
        }
        System.out.println("Número de Livros: " + count1);
        System.out.println("Número de Capítulos de Livros: " + count2);
        System.out.println("Número de Livros de Artigos de Conferencia: " + count3);
        System.out.println("Números de Artigos de Conferencia: " + count4);
        System.out.println("Números de Artigos de Revista: " + count5);
    }
    /**
     * Esta funcao percorre todas as publicacoes e cria um novo arraylist do tipo publicacao com aqueles que foram feitas por um investigador do grupo cujo acronimo foi pedido.
     * De seguida este novo arraylist de publicacoes e organizado por ano, tipo e fator.
     * @param publicacoes Recebe um ArrayList do tipo publicacao publicacoes que contem todas as publicacoes.
     * @param grupos Recebe um ArrayList do tipo grupoDeInvestigacao grupos que contem todos os grupos.
     * @param acronimo Recebe uma string acronimo correspondente a um grupo de investigacao.
     */
    public static void agrupar2(ArrayList<Publicacao> publicacoes, ArrayList<GrupoDeInvestigacao> grupos, String acronimo){
        ArrayList<Publicacao> todo = new ArrayList<>();
        for(GrupoDeInvestigacao a : grupos){
            if(a.acronimo.equals(acronimo)){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015)
                                todo.add(c);
                    }
                }
            }
        }
        Comparator<Publicacao> comparateByYear = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.ano - o2.ano;
            }
        };
        Comparator<Publicacao> comparateByTipo = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.tipo.compareTo(o2.tipo);
            }
        };
        Comparator<Publicacao> comparateByImpacto = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.dimensao - o2.dimensao;
            }
        };
        Collections.sort(todo, comparateByImpacto);
        Collections.sort(todo, comparateByTipo);
        Collections.sort(todo, comparateByYear);
        for(Publicacao a : todo)
            System.out.println(a);
    }
    /**
     * Esta funcao percorre todos os investigadores e encontra aqueles que pertence ao grupo correspondente ao acronimo pedido ao utilizador.
     * De seguida verifica-se se esses investigadores sao membros efetivos ou estudantes separando-od em dois arraylists.
     * @param membros Recebe um ArrayList do tipo investigador membros que contem todos os membros.
     * @param acronimo Recebe uma string acronimo correspondente a um grupo de investigacao.
     */
    public static void agrupar3(ArrayList<Investigador> membros, String acronimo){
        ArrayList<Investigador> grupo = new ArrayList<>();
        ArrayList<Investigador> grupo1 = new ArrayList<>();
        ArrayList<Investigador> grupo2 = new ArrayList<>();
        for(Investigador a : membros){
            if(a.getGrupo().acronimo.equals(acronimo)){
                grupo.add(a);
            }
        }
        for(Investigador a : grupo){
            if(a.check() == 1){
                grupo1.add(a);
            }
            if(a.check() == 2){
                grupo2.add(a);
            }
        }
        System.out.println("Estudantes: ");
        for(Investigador a : grupo1)
            System.out.println(a);
        System.out.println("Membros Efetivos: ");
        for(Investigador a : grupo2)
            System.out.println(a);
    }
    /**
     * Esta funcao percorre todas as publicacoes e encontra aqueles que foram feitas pelo investigador pedido ao utilizador, guardando-as num arraylist do tipo publicacao.
     * De seguida esse arrylist e organizado por ano, tipo e fator.
     * @param publicacoes Recebe um ArrayList do tipo publicacao publicacoes que contem todas as publicacoes.
     * @param nome Recebe uma String nome que corresponde ao nome de um investigador.
     */
    public static void agrupar4(ArrayList<Publicacao> publicacoes, String nome){
        ArrayList<Publicacao> autor = new ArrayList<>();
        for(Publicacao a : publicacoes){
            if(a.getAutores().equals(nome)){
                autor.add(a);
            }
        }
        if(autor.size()==0)
            System.out.println("Investigador não existe ou não tem publicações.");
        Comparator<Publicacao> comparateByYear = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.ano - o2.ano;
            }
        };
        Comparator<Publicacao> comparateByTipo = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.tipo.compareTo(o2.tipo);
            }
        };
        Comparator<Publicacao> comparateByImpacto = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.dimensao - o2.dimensao;
            }
        };
        Collections.sort(autor, comparateByImpacto);
        Collections.sort(autor, comparateByTipo);
        Collections.sort(autor, comparateByYear);
        for(Publicacao a : autor)
            System.out.println(a);
    }
    /**
     * Esta funcao apresenta o numero total de membros, tambem como o numero de membros de cada categoria para cada grupo.
     * Apresenta tambem o numero de publicacoes dos ultimos 5 anos para cada grupo, e apresenta-as organizadas por ano, tipo e fator de impacto.
     * @param publicacoes Recebe um ArrayList do tipo publicacao publicacoes que contem todas as publicacoes.
     * @param grupos Recebe um ArrayList do tipo grupoDeInvestigacao grupos que contem todos os grupos.
     */
    public static void mostrar5(ArrayList<Publicacao> publicacoes, ArrayList<GrupoDeInvestigacao> grupos)  {
        int count = 0, count1 = 0, count2 = 0, countAC = 0, countCMS = 0, countECOS = 0, countIS = 0, countLCT = 0, countSSE = 0;
        ArrayList<Publicacao> ac = new ArrayList<>();
        ArrayList<Publicacao> cms = new ArrayList<>();
        ArrayList<Publicacao> ecos = new ArrayList<>();
        ArrayList<Publicacao> is = new ArrayList<>();
        ArrayList<Publicacao> lct = new ArrayList<>();
        ArrayList<Publicacao> sse = new ArrayList<>();
        for(GrupoDeInvestigacao a : grupos){
            if(a.acronimo.equals("AC")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015){
                                countAC++;
                                ac.add(c);
                            }
                    }
                }
            }
            if(a.acronimo.equals("CMS")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015){
                                countCMS++;
                                cms.add(c);
                            }
                    }
                }
            }
            if(a.acronimo.equals("ECOS")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015){
                                countECOS++;
                                ecos.add(c);
                            }
                    }
                }
            }
            if(a.acronimo.equals("IS")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015) {
                                countIS++;
                                is.add(c);
                            }
                    }
                }
            }
            if(a.acronimo.equals("LCT")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015) {
                                countLCT++;
                                lct.add(c);
                            }
                    }
                }
            }
            if(a.acronimo.equals("SSE")){
                for(Investigador b : a.membros){
                    for(Publicacao c : publicacoes){
                        if(c.getAutores().equals(b.nome))
                            if(c.getAno() >= 2015) {
                                countSSE++;
                                sse.add(c);
                            }
                    }
                }
            }
        }
        Comparator<Publicacao> comparateByYear = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.ano - o2.ano;
            }
        };
        Comparator<Publicacao> comparateByTipo = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.tipo.compareTo(o2.tipo);
            }
        };
        Comparator<Publicacao> comparateByImpacto = new Comparator<Publicacao>() {
            @Override
            public int compare(Publicacao o1, Publicacao o2) {
                return o1.dimensao - o2.dimensao;
            }
        };
        Collections.sort(ac, comparateByImpacto);
        Collections.sort(ac, comparateByTipo);
        Collections.sort(ac, comparateByYear);
        Collections.sort(cms, comparateByImpacto);
        Collections.sort(cms, comparateByTipo);
        Collections.sort(cms, comparateByYear);
        Collections.sort(ecos, comparateByImpacto);
        Collections.sort(ecos, comparateByTipo);
        Collections.sort(ecos, comparateByYear);
        Collections.sort(is, comparateByImpacto);
        Collections.sort(is, comparateByTipo);
        Collections.sort(is, comparateByYear);
        Collections.sort(lct, comparateByImpacto);
        Collections.sort(lct, comparateByTipo);
        Collections.sort(lct, comparateByYear);
        Collections.sort(sse, comparateByImpacto);
        Collections.sort(sse, comparateByTipo);
        Collections.sort(sse, comparateByYear);
        for(GrupoDeInvestigacao a : grupos){
            System.out.println(a.nome);
            for(Investigador b : a.membros) {
                if (b.check() == 1) {
                    count1++;
                }
                if (b.check() == 2) {
                    count2++;
                }
                count++;
            }
            System.out.println("Número de estudantes: " + count1);
            System.out.println("Número de membros efetivos: " + count2);
            if(a.acronimo.equals("AC")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countAC);
                System.out.println("Publicacoes: ");
                for(Publicacao b : ac)
                    System.out.println(b);
                System.out.println();
            }
            if(a.acronimo.equals("CMS")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countCMS);
                System.out.println("Publicacoes: ");
                for(Publicacao b : cms)
                    System.out.println(b);
                System.out.println();
            }
            if(a.acronimo.equals("ECOS")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countECOS);
                System.out.println("Publicacoes: ");
                for(Publicacao b : ecos)
                    System.out.println(b);
                System.out.println();
            }
            if(a.acronimo.equals("IS")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countIS);
                System.out.println("Publicacoes: ");
                for(Publicacao b : is)
                    System.out.println(b);
                System.out.println();
            }
            if(a.acronimo.equals("LCT")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countLCT);
                System.out.println("Publicacoes: ");
                for(Publicacao b : lct)
                    System.out.println(b);
                System.out.println();
            }
            if(a.acronimo.equals("SSE")){
                System.out.println("Número de publicacoes nos últimos 5 anos: " + countSSE);
                System.out.println("Publicacoes: ");
                for(Publicacao b : sse)
                    System.out.println(b);
                System.out.println();
            }
            count1 = 0;
            count2 = 0;
        }
        System.out.println("Número total de membros: " + count);
    }
    /**
     * Esta funcao da print na consola da interface.
     */
    public static void menu(){
        System.out.println("Escolha a ação que pretende realizar: ");
        System.out.println("1-Indicadores gerais do Cisuc");;
        System.out.println("2-Listar as publicações de um grupo de investigação, dos últimos 5 anos, organizadas por ano, por tipo de publicação e por fator de impacto");
        System.out.println("3-Listar os membros de um grupo de investigação agrupados por categoria");
        System.out.println("4-Listar as publicações de um investigador agrupadas por ano, tipo de publicação e fator de impacto");
        System.out.println("5-Listar todos os grupos de investigação, apresentado para cada grupo: o total de membros, numero de grupos de cada categoria, total de publicacoes nos últimos 5 anos, número de publicações, nos últimos 5 anos, agrupadas por ano, tipo de publicação e fator de impacto");
        System.out.println("6-Sair");
    }
    /**
     * Esta funcao vai imprimindo o menu na consola e chama outras funcoes de acordo com as informacoes dadas pelo utilizador.
     */
    public static void menuInterativo(){
        ArrayList<Publicacao> publicacoes;
        ArrayList<GrupoDeInvestigacao> grupos;
        ArrayList<Investigador> membros;
        grupos = lerGrupos();
        membros = lermembros(grupos);
        publicacoes = lerpublicacoes();
        setDosMembros(grupos, membros);
        escrever1(grupos);
        escrever2(membros);
        escrever3(publicacoes);
        Scanner sc = new Scanner(System.in);
        Scanner le = new Scanner(System.in);
        int a;
        do{
            menu();
            a = sc.nextInt();
            if(a == 1){
                totalMembros(membros);
                membrosCategoria(membros);
                publicacoes5(publicacoes);
                countpublicacoes(publicacoes);
            }
            if(a == 2) {
                System.out.println("Escreva o acrónimo do grupo de investigação que pretende: ");
                String b = le.nextLine();
                agrupar2(publicacoes, grupos, b);
            }
            if(a == 3){
                System.out.println("Escreva o acrónimo do grupo de investigação que pretende: ");
                String b = le.nextLine();
                agrupar3(membros, b);
            }
            if(a == 4){
                System.out.println("Escreva o nome do investigador que pretende: ");
                String b = le.nextLine();
                agrupar4(publicacoes, b);
            }
            if(a == 5){
                mostrar5(publicacoes, grupos);
            }
        }while(a !=6);
    }
}