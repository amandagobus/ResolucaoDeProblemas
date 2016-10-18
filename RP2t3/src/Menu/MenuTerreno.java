/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import java.util.Scanner;
import Imovel.Imovel;
import ListaImoveis.ListaDeImoveis;
import Terreno.Terreno;

/**
 * Classe que reune os principais metodos de funcionabilidade dos objetos salvos no sistema.
 * 
 * @author Julielen
 */
public class MenuTerreno {
    
    ListaDeImoveis lista = new ListaDeImoveis();
    Scanner entrada = new Scanner(System.in);
    
    public static void menu() {
        
        System.out.println(" \n");
        System.out.println("***** Menu *****\n");
        System.out.println("[1] Novo Imóvel Terreno ");
        System.out.println("[2] Consultar");
        //System.out.println("[3] Editar ");
        //System.out.println("[4] Excluir");
        System.out.println("[0] Voltar ");
        System.out.println(" ");
        System.out.print("Opção:    ");
        }
        
 
    public static void menu2() {
        System.out.println(" \n");
        System.out.println("*************** MENU DE CONSULTA *****************");
        System.out.println(" \n");
        System.out.println("[1] Código  ");
        System.out.println("[0] Voltar ");
        System.out.println("\n ");
        System.out.print("Opção:     ");

    }
    
    /**
     * Metodo que faz a interação com o usuário
     */
    public void IncluirImovel() {

        String logradouro;
        int numero;
        String bairro;
        String cidade;
        String descricao;
        double areaTotal;
        double valor;
        double dimensaoFrente;
        double dimensaoLado;
        
        System.out.println("Digite o Logradouro:  ");
        logradouro = entrada.nextLine();

        System.out.println("Digite o Número:  ");
        numero = entrada.nextInt();
        entrada.nextLine();

        System.out.println("Digite o Bairro:  ");
        bairro = entrada.nextLine();

        System.out.println("Digite a Cidade:  ");
        cidade = entrada.nextLine();

        System.out.println("Digite Uma Descrição:  ");
        descricao = entrada.nextLine();

        System.out.println("Digite a Aréa Total:  ");
        areaTotal = entrada.nextDouble();
        entrada.nextLine();

        System.out.println("Digite o Valor do Imovél:  ");
        valor = entrada.nextDouble();
        entrada.nextLine();
        
        System.out.println("Digite a Dimensão Frente:  ");
        dimensaoFrente = entrada.nextDouble();
        entrada.nextLine();
        
        System.out.println("Digite a Dimensão Lado:  ");
        dimensaoLado = entrada.nextDouble();
        entrada.nextLine();
        
        Imovel Terreno = new Terreno(logradouro, numero, bairro, cidade,
                descricao, areaTotal, valor, dimensaoFrente, dimensaoLado);
        
        boolean objeto = lista.incluir(Terreno);
        
        if(objeto == true){
            System.out.println("Imóvel incluído com sucesso.");
        }else{
            System.out.println("Imóvel não foi incluído.");     
        }
    }
    
    /**
     * Método que recebe uma informação do usuario, e consulta por código se o objeto esta
     * na listaImoveis.
     */
    public void Consultar() {
        System.out.println("Digite o Código Que Deseja Consultar: ");
        Imovel Imo = lista.consultar(entrada.nextInt());
        entrada.nextLine();

        if ((Imo != null)&&(Imo instanceof Terreno) ) {
            System.out.println("=======================================");
            System.out.println(Imo.toString());

        } else if (Imo == null) {
            System.out.println("Imovél Não Cadastrado;");
            
            
        }
    }
    
    public void menuInicial() {
        int i;

        do {
            MenuTerreno.menu();
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
                    MenuTerreno.menu2();
                    int opcao = entrada.nextInt();
                    entrada.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("\n");
                            System.out.println("******** Consultar Imóvel Por Codigo ********");
                            System.out.println("\n\n");
                            Consultar();
                            break;

                        default:
                            break;

                    }
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

            }

        } while (i != 0);

        }
        
    }
