/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Imovel.Imovel;
import ListaImoveis.ListaDeImoveis;
import java.util.Scanner;
import Casa.Casa;
import static Imovel.EntradasTeclado.inDouble;
import static Imovel.EntradasTeclado.inInt;
import static Imovel.EntradasTeclado.inString;
import Imovel.Tipo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amanda Gobus
 */
public class MenuCasa {

    Casa casa;
    ListaDeImoveis lista = new ListaDeImoveis();
    Scanner entrada = new Scanner(System.in);

    /**
     * Método chamado menu, que exibe as opções Novo Imóvel e Consultar
     */
    public void menuInicial() {
        int opcao = -1;
        do {
            System.out.println(" \n");
            System.out.println("***** CASA *****\n");
            System.out.println("1) Novo Imóvel CASA ");
            System.out.println("2) Consultar");
            System.out.println("3) Editar ");
            System.out.println("4) Excluir");
            System.out.println("0) Sair ");
            System.out.println(" ");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
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
            }
        } while (opcao != 0);

    }

    public void Carregar() {

        try {
            lista.lerCasa();
        } catch (IOException ex) {
            Logger.getLogger(MenuApartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

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

        int tipo;
        double areaConstruida;
        int numeroQuartos;
        int anoConstrucao;

        int numeroDeVagas;
        System.out.println("=======================================");
        logradouro = inString("Digite o Logradouro:  ");
        numero = inInt("Digite o Número:  ");

        bairro = inString("Digite o Bairro:  ");
        
        cidade = inString("Digite a Cidade:  ");
        
        descricao = inString("Digite Uma Descrição:  ");

        areaTotal = inDouble("Digite a Área Total:  ");

        valor = inDouble("Digite o Valor do Imóvel:  ");

        areaConstruida = inDouble("Digite a Área Construída:  ");

        numeroQuartos = inInt("Digite o Número de Quartos:  ");

        numeroDeVagas = inInt("Digite o Número de Vagas na garagem:  ");

        anoConstrucao = inInt("Digite o Ano de Construção:  ");

        System.out.println("Digite o Tipo do Imóvel: ");
        System.out.println("  1) RESIDENCIAL       2)COMERCIAL ");
        tipo = entrada.nextInt();
        Tipo t = Tipo.CasaTipo(tipo);
        Imovel casa = new Casa(logradouro, numero, bairro, cidade, descricao,
                numero, valor, areaConstruida, numeroQuartos, anoConstrucao,
                t, numeroDeVagas);
        System.out.println("=======================================");

        boolean objeto = lista.incluir(casa);
        try {
            lista.gravarCasa();
        } catch (Exception ex) {
            Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("\n\n");
        if (objeto == true) {
            System.out.println("Imóvel incluido com sucesso.");
        } else {
            System.out.println("Imóvel não foi incluido.");
        }
    }

    /**
     * Método de consultar por código
     */
    public void Consultar() {
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null) && (Imo instanceof Casa)) {
            System.out.println("=======================================");
            System.out.println("*****INFORMAÇÕES DO IMÓVEL *****\n");
            System.out.println(Imo.toString());
            System.out.println("=======================================");
        } else {
            System.out.println("Imóvel Não Cadastrado.");
        }

    }

    /**
     * Método que exclui um imóvel pelo codigo
     */
    public void Excluir() {
        System.out.println("Digite o código do imóvel que você deseja excluir: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        lista.excluir(codigo);

    }

    /**
     * Método que edita atributos de um imóvel
     */
    public void Editar() {
        System.out.println("Qual o código do imóvel você quer editar: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();
        casa = (Casa) lista.consultar(codigo);
        if (casa != null) {
            System.out.println(casa.toString());
            System.out.print("Qual atributo você quer editar: ");
            String atributo = entrada.nextLine();

            switch (atributo) {
                case "logradouro":
                    System.out.print("Digite o  logradouro: ");
                    casa.setLogradouro(entrada.nextLine());

                    break;
                case "numero":
                    System.out.print("Digite o número: ");
                    casa.setNumero(entrada.nextInt());
                    entrada.nextLine();

                    break;
                case "bairro":
                    System.out.print("Digite o Bairro: ");
                    casa.setBairro(entrada.nextLine());

                    break;
                case "cidade":
                    System.out.print("Digite a Cidade: ");
                    casa.setCidade(entrada.nextLine());

                    break;
                case "descricao":
                    System.out.print("Digite a Descrição: ");
                    casa.setDescricao(entrada.nextLine());

                    break;
                case "area total":
                    System.out.println("Digite a Área Total: ");
                    casa.setAreaTotal(entrada.nextDouble());
                    entrada.nextLine();

                    break;
                case "valor do imovel":
                    System.out.print("Digite o valor do Imóvel: ");
                    casa.setValor(entrada.nextDouble());
                    entrada.nextLine();

                    break;
                case "area Construida":
                    System.out.print("Digite a Área Construída: ");
                    casa.setAreaConstruida(entrada.nextDouble());
                    entrada.nextLine();
                    break;
                case "numero de quartos":
                    System.out.print("Digite o Número de Quartos: ");
                    casa.setNumeroQuartos(entrada.nextInt());
                    entrada.nextLine();
                    break;
                case "numero de vagas":
                    System.out.print("Digite o Número de vagas na garagem: ");
                    casa.setNumeroDeVagas(entrada.nextInt());
                    entrada.nextLine();
                    break;

                case "ano de construcao":
                    System.out.print("Digite o ano de Construção: ");
                    casa.setAnoConstrucao(entrada.nextInt());
                    entrada.nextLine();
                    break;

                case "tipo":
                    System.out.println("Digite o Tipo do Imóvel: ");
                    System.out.println("  1) RESIDENCIAL       2)COMERCIAL ");
                    int tipo = entrada.nextInt();
                    Tipo novotipo = Tipo.CasaTipo(tipo);
                    casa.setTipo(novotipo);

                    break;

            }
            lista.editar(codigo, casa);
            try {
                lista.gravarCasa();
            } catch (Exception ex) {
                Logger.getLogger(MenuSalaComercial.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
