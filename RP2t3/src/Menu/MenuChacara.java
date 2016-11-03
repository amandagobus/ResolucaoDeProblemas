/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Imovel.Imovel;
import ListaImoveis.ListaDeImoveis;
import Chacara.Chacara;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.TipoDeImovel;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 **
 * @author Wilson
 */
public class MenuChacara {

    ListaDeImoveis lista;
    Scanner entrada = new Scanner(System.in);

    public MenuChacara() {
        TipoDeImovel tipo;
        tipo = TipoDeImovel.CHACARA;
        String caminho = System.getProperty("user.dir") + System.getProperty("file.separator") + tipo + ".csv";
        lista = new ListaDeImoveis(caminho, tipo);

        if (lista.lerArquivo() == true) {
            System.out.println("Arquivos carregados.");
        } else {
            System.out.println("Arquivo não iniciados.");
        }

    }

    /**
     * Este método faz as interações com o usuário, de modo que quando este
     * escolhe a opção é chamado outro método para realizar a ação
     */
    public static void menu() {
        System.out.println(" \n");
        System.out.println("***** MENU *****\n");
        System.out.println("1) NOVO IMÓVEL CHACARA");
        System.out.println("2) CONSULTAR");
        System.out.println("3) EDITAR ");
        System.out.println("4) EXCLUIR");
        System.out.println("5) PESQUISAR");
        System.out.println("6) ORDENANAR");
        System.out.println("0) VOLTAR ");
        System.out.println(" ");
        System.out.print("OPÇÃO:    ");

    }

    public static void menu2() {
        System.out.println("=================================================");
        System.out.println("===============SELECIONE UMA OPÇÃO===============");
        System.out.println("1) CÓDIGO  ");
        System.out.println("0) VOLTAR ");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");
    }
    
    public static void menu3() {
        System.out.println("*************** MENU DE PESQUISA *****************");
        System.out.println(" \n");
        System.out.println("1) BAIRRO ");
        System.out.println("2) VALOR ");
        System.out.println("0) VOLTAR");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");

    }
    
    public static void menu4() {
        System.out.println("*************** MENU DE ORDENAÇÃO*****************");
        System.out.println(" \n");
        System.out.println("1) ARÉA ");
        System.out.println("2) CODIGO ");
        System.out.println("3) VALOR");
        System.out.println("0) VOLTAR");
        System.out.println("\n ");
        System.out.print("OPÇÃO:     ");
    }
    /**
     * Esse método recebe informações do usuário e passa para o construtor
     * (parâmetros)
     */
    public void IncluirImovel() {

        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;
        double areaConstruida;
        int numeroQuartos;
        int anoConstrucao;
        double distCidade;

        logradouro = inString("Digite o Logradouro:  ");
        numero = inInt("Digite o numero: ");
        bairro = inString("Digite o Bairro:  ");
        cidade = inString("Digite a Cidade:  ");
        descricao = inString("Digite Uma Descrição:  ");
        areaTotal = inDouble("Digite a Área Total:  ");
        valor = inDouble("Digite o Valor do Imóvel:  ");
        areaConstruida = inDouble("Digite a Área Construída:");
        numeroQuartos = inInt("Digite o Número de Quartos:  ");
        anoConstrucao = inInt("Digite o Ano da Construção: ");
        distCidade = inDouble("Digite a Distância da Cidade:  ");

        Imovel chacara = new Chacara(distCidade, logradouro, numero, bairro, cidade,
                descricao, areaTotal, valor, areaConstruida, numeroQuartos, anoConstrucao);

        boolean objeto = lista.incluir(chacara);

        System.out.println("\n");

        if (objeto == true) {
            System.out.println("Imóvel incluido com sucesso!");
        } else {
            System.out.println("Imóvel não foi incluido!");
        }
        try {
            lista.escreverArquivo();
        } catch (Exception ex) {
            Logger.getLogger(MenuChacara.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Consulta pela entrada do usuário (inteiro - código)
     */
    public void Consultar() {
        
        System.out.println("===== IMÓVEIS DISPONÍVEIS =====");
        lista.mostrarLista();
        System.out.println("\n");
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Chacara)) {
            System.out.println("=======================================");
            System.out.println("*******INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");

        } else if (Imo == null) {
            System.out.println("Imóvel Não Cadastrado;");
        }

    }
    
    public void excluirControle() {
        System.out.println(" DIGITE O CODIGO DO IMÓVEL: ");
        boolean objeto = lista.excluir(entrada.nextInt());
        if (objeto == true) {

            System.out.println("IMÓVEL EXCUIDO");
            lista.escreverArquivo();
        } else {

            System.out.println("IMÓVEL NÂO ENCONTRADO");
        }

    }
    
    public void editarControle() {

        System.out.println("\n");
        System.out.println("***********  MENU EDITAR ************ ");
        System.out.println("\n ");
        System.out.println("DIGITE O CODIGO DO IMOVÉL QUE DESEJA EDITAR:");
        int codigoConsulta = entrada.nextInt();

        entrada.nextLine();

        Imovel editarLista = lista.consultar(codigoConsulta);
        entrada.nextLine();

        int i;
        double d;
        String st;
        
        int k = 1;

        if (editarLista != null) {

            while (k != 0) {
                System.out.println(" \n");
                System.out.println("QUAL INFORMAÇÂO DESEJA EDITAR: ");
                System.out.println(" \n");
                System.out.println("0)  VOLTAR AO MENU ANTERIOR ");
                System.out.println("1)  LOGRADOURO ");
                System.out.println("2)  NÚMERO ");
                System.out.println("3)  BAIRRO ");
                System.out.println("4)  CIDADE ");
                System.out.println("5)  DESCRIÇÃO ");
                System.out.println("6)  ARÉA TOTAL ");
                System.out.println("7)  VALOR ");
                System.out.println("8)  ÁREA CONSTRUÍDA ");
                System.out.println("9)  NÚMERO DE QUARTOS ");
                System.out.println("10) ANO DE CONSTRUÇÃO ");
                System.out.println("11) DISTÂNCIA DA CIDADE ");
                System.out.println(" \n");
                System.out.print("OPÇÃO:    ");
                k = entrada.nextInt();
                entrada.nextLine();

                switch (k) {
                    case 1:
                        System.out.print("\n ");
                        st = inString("DIGITE O NOVO LOGRADOURO: ");
                        editarLista.setLogradouro(st);
                        break;
                    case 2:

                        System.out.print("\n");
                        i = inInt("DIGITE O NÚEMRO:  ");
                        editarLista.setNumero(i);

                        break;

                    case 3:

                        System.out.print("\n");
                        st = inString("DIGITE O BAIRRO:  ");
                        editarLista.setBairro(st);

                        break;

                    case 4:

                        System.out.print("\n");
                        st = inString("DIGITE A CIDADE:  ");
                        editarLista.setCidade(st);

                        break;

                    case 5:

                        System.out.print("\n");
                        st = inString("DIGITE A DESCRIÇÂO: ");
                        editarLista.setCidade(st);

                        break;

                    case 6:

                        System.out.print("\n");
                        d = inDouble("DIGITE A ARÉA TOTAL:  ");
                        editarLista.setAreaTotal(d);
                        entrada.nextLine();

                        break;

                    case 7:
                        System.out.print("\n");
                        d = inDouble("DIGITE O VALOR:  ");
                        editarLista.setValor(d);

                        break;

                    case 8:
                        System.out.print("\n");
                         d = inDouble("DIGITE A ÁREA CONSTRUÍDA:");
                        editarLista.setAreaConstruida(d);
                        break;

                    case 9:

                        System.out.print("\n");
                        i = inInt("DIGITE O NÚMERO DE QUARTOS:");
                        editarLista.setNumeroQuartos(i);

                        break;

                    case 10:

                        System.out.print("\n");
                        i = inInt("DIGITE O ANO DA CONSTRUÇÃO:");
                        editarLista.setAnoConstrucao(i);
                        break;

                    case 11:

                        System.out.print("\n");
                        d = inDouble("DIGITE A DISTÂNCIA DA CIDADE:");
                        editarLista.setDistCidade(d);
                        break;

                }

            }

            lista.editar(codigoConsulta, editarLista);
            System.out.println(" --- ");
            try {
                lista.escreverArquivo();
            } catch (Exception ex) {
                Logger.getLogger(Chacara.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println(" \nImóvel Não Encotrado!");
        }

    }

    public void menuInicial() {
        int i;

        do {
            MenuChacara.menu();
            i = entrada.nextInt();
            entrada.nextLine();

            switch (i) {
                case 1:
                    System.out.println("\n");
                    System.out.println("*********** Incluir Imóvel ************");
                    System.out.println("\n");
                    IncluirImovel();
                    break;

                case 2:
                    MenuChacara.menu2();
                    int opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            Consultar();
                            break;

                        default:
                            break;

                    }
                    break;

                case 3:
                    editarControle();
                    break;

                case 4:
                    System.out.println("\n");
                    System.out.println("******** EXCLUIR IMÓVEL ********");
                    System.out.println("\n");
                    excluirControle();
                    break;

                case 5:
                    MenuChacara.menu3();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            String s = inString("INFORME O BAIRRO  ");
                            List imovel =lista.pesquisaBairro(s);
                            System.out.println(imovel.toString());
                            break;
                            
                        case 2:
                            double d = inDouble("INFORME O VALOR  ");
                            List imo =lista.pesquisaValor(d);
                            System.out.println(imo.toString());
                            
                            break;

                        default:
                            break;

                    }
                   break;
                   
                case 6:
                    List<Imovel> aux;
                    MenuChacara.menu4();
                    opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            aux= lista.ordenarArea();
                            System.out.println(aux.toString());
                            
                            break;
                            
                        case 2:
                            aux= lista.ordenarCodigo();
                            System.out.println(aux.toString());                           
                            break;
                        case 3:
                            aux = lista.ordenarValor();
                            System.out.println(aux.toString());
                            
                            break;
                        default:
                            break;

                    }

                default:
                    break;
            }

        } while (i != 0);

    }
}
