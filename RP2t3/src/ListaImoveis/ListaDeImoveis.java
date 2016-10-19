/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaImoveis;

import Apartamento.Apartamento;
import Chacara.Chacara;
import Imovel.Imovel;
import SalaComercial.SalaComercial;
import java.util.ArrayList;
import java.util.List;
import Imovel.ListaImoveis;
import Imovel.TipoDeImovel;
import Menu.MenuSalaComercial;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arcano
 */
public class ListaDeImoveis implements ListaImoveis {

    List<Imovel> lista = new ArrayList<>();
     private TipoDeImovel tipo;
     
       
     
    
  public void ListaDeImoveis(TipoDeImovel tipo){
  this.tipo = tipo;
  
  }
    public TipoDeImovel getTipo(){
    return tipo;
    
    }
    @Override
    public boolean incluir(Imovel im) {
        lista.add(im);
        return true;
    }

    @Override
    public Imovel consultar(int codigo) {

        for (Imovel imovel : lista) {
            if (codigo == imovel.getCodigo()) {
                return imovel;
            }
        }
        return null;

    }

    @Override
    public boolean editar(int codigo, Imovel imo) {

        for (Imovel imovel : lista) {
            if (imovel.getCodigo() == codigo) {
                int indice = this.lista.indexOf(imovel);
                this.lista.set(indice, imo);
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean excluir(int codigo) {
        Imovel imo = this.consultar(codigo);
        if (imo != null) {
            lista.remove(imo);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Imovel> ordenarCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> ordenarValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Imovel> ordenarArea() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Metodo que pesquisa um Imovel pelo valor
     *
     * @param bairro, informado pelo usuario
     * @return uma lista de Imóvel, cujo valor seja menor ou igual ao valor
     * informado
     */
    @Override
    public List<Imovel> pesquisaValor(double valor) {
        List<Imovel> l = new ArrayList<>();
        for (Imovel imovel : lista) {
            if (imovel.getValor() <= valor) {
                l.add(imovel);
            }
        }
        return l;
    }

    /**
     * Metodo que pesquisa um Imovel pelo bairro
     *
     * @param bairro, inoformado pelo usuario
     * @return uma lista de Imóvel
     */
    @Override
    public List<Imovel> pesquisaBairro(String bairro) {
        List<Imovel> l = new ArrayList<>();
        for (Imovel imovel : lista) {
            if (imovel.getBairro().contains(bairro)) {
                l.add(imovel);
            }
        }
        return l;

    }

    @Override
    public boolean lerArquivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean escreverArquivo() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") +
                    System.getProperty("file.separator") + this.tipo+".csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public boolean ler() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Sala.csv");

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao, nomeEdificio;
            int codigo, numero, andar, numeroSala, NumeroBanheiro;
            double areaTotal, valor, valorCondominio;
            Imovel sala;
            arquivo = new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + this.tipo+".csv"));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            linha = ler.readLine();
            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);
                nomeEdificio = parte[8];
                andar = Integer.parseInt(parte[9]);
                valorCondominio = Double.parseDouble(parte[10]);
                numeroSala = Integer.parseInt(parte[11]);
                NumeroBanheiro = Integer.parseInt(parte[12]);

                sala = new SalaComercial(logradouro, numero, bairro, cidade,
                        descricao, areaTotal, valor, nomeEdificio, andar,
                        valorCondominio, NumeroBanheiro, numeroSala);
                incluir(sala);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }

    /*public void gravar() throws Exception {

        //verificar se o arquivo existe, se não existeir criar (o ato de recriar o mesmo arquivo ja resolve por se só?)
        FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Sala.csv"));
        BufferedWriter escrever = new BufferedWriter(outFile);

        escrever.write("CODIGO,LOGRADOURO,NÚMERO,BAIRRO,CIDADE,DESCRIÇÃO,AREA TOTAL,VALOR,NOME DO EDIFICIO,ANDAR,VALOR DO CONDOMINIO,"
                + "NÚMERO DE SALAS,NÚMERO DE BANHEIROS\r\n");

        // criar um metodo nas class abstratas Filewhite. 
        for (Imovel imovel : lista) {
            escrever.write(imovel.getCodigo() + "," + imovel.getLogradouro() + "," + imovel.getNumero()
                    + "," + imovel.getBairro() + "," + imovel.getCidade() + "," + imovel.getDescricao() + "," + imovel.getAreaTotal()
                    + "," + imovel.getValor() + "," + imovel.getNomeEdificio() + "," + imovel.getAndar() + "," + imovel.getValorCondominio()
                    + "," + imovel.getNumeroDaSala() + "," + imovel.getNumeroDeBanheiros());
            escrever.write("\r\n");

        }
        escrever.close();
        outFile.close();

    }
   

    public boolean ler() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Sala.csv");

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao, nomeEdificio;
            int codigo, numero, andar, numeroSala, NumeroBanheiro;
            double areaTotal, valor, valorCondominio;
            Imovel sala;
            arquivo = new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Sala.csv"));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            linha = ler.readLine();
            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);
                nomeEdificio = parte[8];
                andar = Integer.parseInt(parte[9]);
                valorCondominio = Double.parseDouble(parte[10]);
                numeroSala = Integer.parseInt(parte[11]);
                NumeroBanheiro = Integer.parseInt(parte[12]);

                sala = new SalaComercial(logradouro, numero, bairro, cidade,
                        descricao, areaTotal, valor, nomeEdificio, andar,
                        valorCondominio, NumeroBanheiro, numeroSala);
                incluir(sala);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }
     */
    public void gravarChacara() throws Exception {

        //verificar se o arquivo existe, se não existeir criar (o ato de recriar o mesmo arquivo ja resolve por se só?)
        FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Chacara.csv"));
        BufferedWriter escrever = new BufferedWriter(outFile);

        escrever.write("CODIGO,LOGRADOURO,NÚMERO,BAIRRO,CIDADE,DESCRIÇÃO,AREA TOTAL,VALOR,ÁREA CONSTRUIDA,NÚMERO DE QUARTOS,ANO DE CONSTRUÇÃO,"
                + "DISTÂNCIA DA CIDADE\r\n");

        // criar um metodo nas class abstratas Filewhite. 
        for (Imovel imovel : lista) {
            escrever.write(imovel.getCodigo() + "," + imovel.getLogradouro() + "," + imovel.getNumero()
                    + "," + imovel.getBairro() + "," + imovel.getCidade() + "," + imovel.getDescricao() + "," + imovel.getAreaTotal() + "," + imovel.getValor()
                    + "," + imovel.getAreaConstruida() + "," + imovel.getNumeroQuartos() + "," + imovel.getAnoConstrucao()
                    + "," + imovel.getDistCidade());
            escrever.write("\r\n");

        }
        escrever.close();
        outFile.close();

    }

    public boolean lerChacara() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Chacara.csv");

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao;
            int codigo, numero, andar, numeroQuartos, anoConstrucao;
            double areaTotal, valor, areaConstruida, distCidade;
            Imovel chacara;
            arquivo = new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Chacara.csv"));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            linha = ler.readLine();
            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);
                areaConstruida = Double.parseDouble(parte[8]);
                numeroQuartos = Integer.parseInt(parte[9]);
                anoConstrucao = Integer.parseInt(parte[10]);
                distCidade = Double.parseDouble(parte[11]);

                chacara = new Chacara(distCidade, logradouro, numero, bairro, cidade,
                        descricao, areaTotal, valor, areaConstruida, numeroQuartos, anoConstrucao);

                incluir(chacara);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }

    public boolean lerApartamento() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Apartamento.csv");

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao, nomeEdificio;
            int codigo, numero, andar;
            double areaTotal, valor, valorCondominio;
            int numeroQuartos;
            int numeroVagas;
            int anoDeConstrucao;
            int numeroDoApartamento;

            Imovel sala;
            arquivo = new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Sala.csv"));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            linha = ler.readLine();
            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);

                nomeEdificio = parte[8];
                andar = Integer.parseInt(parte[9]);
                valorCondominio = Double.parseDouble(parte[10]);

                numeroQuartos = Integer.parseInt(parte[11]);
                numeroVagas = Integer.parseInt(parte[12]);
                anoDeConstrucao = Integer.parseInt(parte[13]);
                numeroDoApartamento = Integer.parseInt(parte[14]);

                Apartamento ap = new Apartamento(logradouro, numero, bairro, cidade,
                        descricao, areaTotal, valor, nomeEdificio, andar,
                        valorCondominio, numeroQuartos, numeroVagas, anoDeConstrucao, numeroDoApartamento);
                incluir(ap);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }

    public boolean gravarApartamento() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Apartamento.csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public boolean gravarCasa() {

        try {
            FileWriter outFile = new FileWriter(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Casa.csv"));
            BufferedWriter escrever = new BufferedWriter(outFile);
            Imovel mo = lista.get(0);
            escrever.write(mo.toFileTitulo());
            escrever.write("\r\n");

            for (Imovel imovel : lista) {
                escrever.write(imovel.toFile());
                escrever.write("\r\n");
            }
            escrever.close();
            outFile.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public boolean lerCasa() throws FileNotFoundException, IOException {

        File file = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Casa.csv");

        if (file.exists()) {
            FileInputStream arquivo;
            BufferedReader ler;
            String linha, logradouro, bairro, cidade, descricao;
            int codigo, numero;
            double areaTotal, valor;

            int tipo;
            double areaConstruida;
            int numeroQuartos;
            int anoConstrucao;

            int numeroDeVagas;

            Imovel sala;
            arquivo = new FileInputStream(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "Casa.csv"));
            ler = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));

            linha = ler.readLine();
            while ((linha = ler.readLine()) != null) {
                String parte[] = linha.split(",");
                codigo = Integer.parseInt(parte[0]);
                logradouro = parte[1];
                numero = Integer.parseInt(parte[2]);
                bairro = parte[3];
                cidade = parte[4];
                descricao = parte[5];
                areaTotal = Double.parseDouble(parte[6]);
                valor = Double.parseDouble(parte[7]);
                areaConstruida = Double.parseDouble(parte[8]);
                numeroQuartos = Integer.parseInt(parte[9]);
                anoConstrucao = Integer.parseInt(parte[10]);
                numeroDeVagas = Integer.parseInt(parte[11]);
                tipo = parseInt(parte[12]);

                Apartamento ap = new Apartamento(logradouro, numero, bairro, cidade, descricao, areaTotal, valor, descricao, tipo, valor, numeroDeVagas, anoConstrucao, numeroDeVagas, numeroQuartos);
                incluir(ap);

            }
            ler.close();
            arquivo.close();
            return true;

        }
        return false;
    }

}
