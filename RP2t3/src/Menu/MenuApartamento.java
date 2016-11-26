/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Apartamento.Apartamento;
import static Imovel.EntradasTeclado.div;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.Imovel;
import Imovel.TipoDeImovel;
import ListaImoveis.ListaDuplamenteEncadeada;
import ListaImoveis.ListaDeImoveis;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda Gobus
 */
public class MenuApartamento {

    Apartamento apartamento;
    ListaDeImoveis lista;
    private List<Imovel> ListaOrdenada;
    private int codigoImovel, codigo;
    Scanner entrada = new Scanner(System.in);
    
    public MenuApartamento(){
        TipoDeImovel tipo;
        tipo = TipoDeImovel.APARTAMENTO;
        String caminho = System.getProperty("user.dir") + System.getProperty("file.separator") + tipo + ".csv";
        lista = new ListaDeImoveis(caminho, tipo);
        
        if (lista.lerApartamentoBin() == true) {
            System.out.println("Arquivos carregados");
        } else {
            System.out.println("Arquivo não iniciados");
        }

    }

    //<editor-fold defaultstate="collapsed" desc="menuInicial">
    

    /**
     * Método chamado menu, que exibe as opções Novo Imóvel e Consultar
     */
    public void menuInicial() {
        int opcao = -1;
        do {
            System.out.println(" \n");
            System.out.println("***** APARTAMENTO *****\n");
            System.out.println("1) Novo Imóvel APARTAMENTO ");
            System.out.println("2) Consultar");
            System.out.println("3) Editar ");
            System.out.println("4) Excluir");
            System.out.println("5) Ordenar");
            System.out.println("6) Pesquisar");
            System.out.println("0) Sair ");
            System.out.println(" ");

            opcao = inInt("Opção: ");

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    IncluirImovel();
                    break;
                case 2:
                    Consultar();
                    break;
                case 3:
                    Editar();
                    break;
                case 4:
                    Excluir();
                    break;
                case 5:
                    ordenar();
                    break;
                case 6:
                    MenuApartamento.menu2();
                    opcao = inInt("Opção: ");
                    switch (opcao) {
                        case 1:
                            String s = inString("Informe o Bairro: ");
                            List imovel = lista.pesquisaBairro(s);
                            System.out.println(imovel.toString());
                            break;
                        case 2:
                            double d = inDouble("Informe o Valor: ");
                            List imo = lista.pesquisaValor(d);
                            System.out.println(imo.toString());
                            break;

                    }
                    break;
            }
        } while (opcao != 0);

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Menu2">
    public static void menu2() {
        System.out.println("=================================================");
        System.out.println("===============SELECIONE UMA OPÇÃO===============");
        System.out.println("  1)Bairro  ");
        System.out.println("  2)Valor");
        System.out.println("");

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="IncluirImovel">
    /**
     * Método de Incluir um novo Imóvel
     */
    public void IncluirImovel() {
        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;

        String nomeEdificio;
        int numeroQuartos;
        int numeroVagas;
        int anoDeConstrucao;
        int numeroDoApartamento;
        int andar;
        double valorCondominio;

        System.out.println("=======================================");

        logradouro = inString("Digite o Logradouro:  ");

        numero = inInt("Digite o numero: ");

        bairro = inString("Digite o Bairro:  ");

        cidade = inString("Digite a Cidade:  ");

        descricao = inString("Digite Uma Descrição:  ");

        areaTotal = inDouble("Digite a Área Total:  ");

        valor = inDouble("Digite o Valor do Imóvel:  ");

        nomeEdificio = inString("Digite o Nome do Edifício:  ");

        numeroQuartos = inInt("Digite o Número de Quartos:  ");

        numeroVagas = inInt("Digite o Número de Vagas na garagem:  ");

        anoDeConstrucao = inInt("Digite o Ano de Construção:  ");

        numeroDoApartamento = inInt("Digite o Número do Apartamento:  ");

        andar = inInt("Digite o Número do Andar:  ");

        valorCondominio = inDouble("Digite o Valor do Condominio:  ");

        System.out.println("=======================================");

        Imovel apartamento = new Apartamento(logradouro, numero, bairro,
                cidade, descricao, areaTotal, valor, nomeEdificio, andar,
                valorCondominio, numeroDoApartamento, anoDeConstrucao,
                numeroVagas, numeroQuartos);

        boolean objeto = lista.incluir(apartamento);
        try {
            lista.escreverArquivoBin();
        } catch (Exception ex) {
            Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\n\n");
        if (objeto == true) {
            System.out.println("Imóvel incluido com sucesso.");
        } else {
            System.out.println("Imóvel não foi incluido.");
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Consultar">
    /**
     * Método que consulta o imóvel por código
     */
    public void Consultar() {

        
        lista.mostrarLista();
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Apartamento)) {
            System.out.println("=======================================");
            System.out.println("*******INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");

        } else {
            System.out.println("Imóvel Não Cadastrado.");
        }

    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="mostrarLista">
     private int mostrarLista(List<Imovel> lista) {
        int imovelCod;
        div();
        for (Imovel imovel : lista) {
            System.out.println(imovel.getCodigo() + " Logradouro: " + imovel.getLogradouro() + " Valor:" + imovel.getValor());
        }
        div();
        return inInt("Digite o código do imóvel: ");
    }
    //</editor-fold>
   
    //<editor-fold defaultstate="collapsed" desc="Ordenar">
    /**
     * Método de ordenar
     */
    private void ordenar() {
        System.out.println("============================================");
        System.out.println("1)Ordenar por código");
        System.out.println("2)Ordenar por valor");
        System.out.println("3)Ordenar por área ");
        System.out.println("--------------------------------------------");
        int opcao = inInt("Digite a opção: ");
        switch (opcao) {
            case 1:
                this.ListaOrdenada = this.lista.ordenarCodigo();
                int imovelCod = this.mostrarLista(ListaOrdenada);
                System.out.println("==========================================");
                System.out.println(lista.consultar(imovelCod).toString());
                System.out.println("==========================================");
                break;
            case 2:
                this.ListaOrdenada = this.lista.ordenarValor();
                imovelCod = this.mostrarLista(ListaOrdenada);
                System.out.println("==========================================");
                System.out.println(lista.consultar(imovelCod).toString());
                System.out.println("==========================================");
                break;
            case 3:
                this.ListaOrdenada = this.lista.ordenarArea();
                imovelCod = this.mostrarLista(ListaOrdenada);
                System.out.println("==========================================");
                System.out.println(lista.consultar(imovelCod).toString());
                System.out.println("==========================================");
                break;
            default:
                System.out.println("Opção Inválida ");
        }
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Editar">
    /**
     * Método que Edita um imóvel utilizando o codigo
     */
    public void Editar() {
        System.out.println("Qual o código do imóvel você quer editar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        apartamento = (Apartamento) lista.consultar(codigo);
        if (apartamento != null) {
            System.out.println(apartamento.toString());
            System.out.print("Qual atributo você quer editar: ");
            String atributo = entrada.nextLine();

            switch (atributo) {
                case "logradouro":

                    apartamento.setLogradouro(inString(" Digite o  logradouro:"));

                    break;
                case "numero":

                    apartamento.setNumero(inInt("Digite o número: "));

                    break;
                case "bairro":

                    apartamento.setBairro(inString("Digite o número: "));

                    break;
                case "cidade":

                    apartamento.setCidade(inString("Digite a Cidade: "));

                    break;
                case "descricao":

                    apartamento.setDescricao(inString("Digite a Descrição: "));

                    break;
                case "area total":
                    apartamento.setAreaTotal(inDouble("Digite a Área Total: "));

                    break;
                case "valor":
                    apartamento.setValor(inDouble("Digite o valor do Imóvel: "));

                    break;

                case "nome do edificio":
                    apartamento.setNomeEdificio(inString("Digite o Nome do Edifício"));
                    break;

                case "numero de quartos":

                    apartamento.setNumeroQuartos(inInt("Digite o Número de Quartos: "));

                    break;

                case "numero de vagas":

                    apartamento.setNumeroVagas(inInt("Digite o Número de vagas na garagem: "));

                    break;

                case "ano de construcao":

                    apartamento.setAnoDeConstrucao(inInt("Digite o ano de Construção: "));

                    break;

                case "numero do apartamento":

                    apartamento.setNumeroDoApartamento(inInt("Digite o número do apartamento: "));

                    break;

                case " andar:":
                    apartamento.setAndar(inInt("Digite o Número do Andar: "));

                    break;

                case "valor do condominio":
                    apartamento.setValorCondominio(inDouble("Digite o Valor do Condominio:  "));
                    break;

            }
            
            lista.editar(codigo, apartamento);
            try {
                lista.escreverArquivoBin();
            } catch (Exception ex) {
                Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\n IMÓVEL NÃO ENCONTRADO ");
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Excluir">
    /**
     * Método que exclui por código
     */
    public void Excluir() {
         System.out.println(" DIGITE O CODIGO DO IMÓVEL: ");
        boolean objeto = lista.excluir(entrada.nextInt());
        if (objeto == true) {

            System.out.println("IMÓVEL EXCLUIDO");
            lista.escreverArquivoBin();
        } else {

            System.out.println("IMÓVEL NÃO ENCONTRADO");
        }
    }
    //</editor-fold>
   
}
