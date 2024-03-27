package aplicacao;
import java.util.Scanner;

import utilitarios.GrafoListaAdj;
import utilitarios.GrafoMatrizAdj;
import utilitarios.LimparTela;


public class main {
    public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

        //Definição numero de vertices do grafo
		    Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de vértices:");
        int numVertices = scanner.nextInt();
        int num;

        // Criação de um grafo por Matriz e lista de Adjacência
        GrafoMatrizAdj grafoMatrizAdj = new GrafoMatrizAdj(numVertices);
        GrafoListaAdj grafoListaAdj = new GrafoListaAdj(numVertices);

        //Definição de tipo
        System.out.println("\nDigite 1 para criar um garfo nao direcionado\nDigite 2 para criar um garfo direcionado");
        int EDirecionado = scanner.nextInt();



        switch (EDirecionado) {
          case 1: //NAO DERECIONADO
          LimparTela.limpar_console();
          System.out.println("Um grafo com " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n" );

          do{
            System.out.println("\nDigite 1 para CRIAR ARESTAS\nDigite 2 para REMOVER ARESTAS\nDigite 3 para IDENTIFICAR A VIZINHANÇA DE UM VÉRTICE\nDigite 4 para IDENTIFICAR O GRAU DE UM VÉRTICE\nDigite 5 para TESTAR O GRAFO\nDigite 6 para REPRESENTAÇÃO EM MATRIZ\nDigite 7 para REPRESENTAÇÃO EM LISTA\nDigite 0 para SAIR " );
            num = scanner.nextInt();

            switch (num) {
              case 1:
                
                break;
            
              default:
        
                break;
            }
           LimparTela.limpar_console();
          } while (num!=0);


          break;

          case 2:// DIRECIONADO 
          LimparTela.limpar_console();
          System.out.println("Um grafo direcionado com " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n"); 
          
          do{
            System.out.println("\nDigite 1 para CRIAR ARESTAS\nDigite 2 para REMOVER ARESTAS\nDigite 3 para IDENTIFICAR OS SUCESSORES E PREDECESSORRES DE UM VÉRTICE\nDigite 4 para IDENTIFICAR O GRAU DE UM VÉRTICE\nDigite 5 para TESTAR O GRAFO\nDigite 6 para REPRESENTAÇÃO EM MATRIZ\nDigite 7 para REPRESENTAÇÃO EM LISTA\nDigite 0 para SAIR" );
            num = scanner.nextInt();

            switch (num) {
              case 1:
                
                break;
            
              default:
        
                break;
            }
            LimparTela.limpar_console();
          } while (num !=0);

            break;
        
          default:
            break;
        }    
	}
   
}
