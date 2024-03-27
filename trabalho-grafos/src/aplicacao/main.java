package aplicacao;
import java.util.Scanner;

import utilitarios.GrafoListaAdj;
import utilitarios.GrafoMatrizAdj;


public class main {
    public static void main(String[] args) {
		// TODO Auto-generated method stub

       //Definição numero de vertices do grafo
		    Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de vértices:");
        int numVertices = scanner.nextInt();

        // Criação de um grafo por Matriz e lista de Adjacência
         GrafoMatrizAdj grafoMatrizAdj = new GrafoMatrizAdj(numVertices);
         GrafoListaAdj grafoListaAdj = new GrafoListaAdj(numVertices);

        //Definição de tipo
        System.out.println("digite 1 para criar um garfo nao direcionado");
        System.out.println("digite 2 para criar um garfo direcionado");
        int EDirecionado = scanner.nextInt();

        switch (EDirecionado) {
          case 1:
          System.out.println("Um grafo com " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n" );
            break;

          case 2:
          System.out.println("Um grafo nãoc om " + numVertices + " vértices foi criado usando Matriz e Lista de Adjacência.\n");  

            break;
        
          default:
            break;
        }

        
       

      

	}

    
}
