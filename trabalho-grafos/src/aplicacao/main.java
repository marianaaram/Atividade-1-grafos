package aplicacao;
import java.util.Scanner;

import utilitarios.GrafoListaAdj;
import utilitarios.GrafoMatrizAdj;


public class main {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número de vértices:");
        int numVertices = scanner.nextInt();

        // Criação de um grafo com Matriz de Adjacência
        GrafoMatrizAdj grafoMatrizAdj = new GrafoMatrizAdj(numVertices);
        System.out.println("Um grafo com " + numVertices + " vértices foi criado usando Matriz de Adjacência.");

       //TESTE VISUALIZAR MATRIZ
        grafoMatrizAdj.imprimizrMatriz();

        // Criação de um grafo com Lista de Adjacência
        GrafoListaAdj grafoListaAdj = new GrafoListaAdj(numVertices);
        System.out.println("Um grafo com " + numVertices + " vértices foi criado usando Lista de Adjacência.");

        //TESTE VISUALIZAR LISTA
        grafoListaAdj.imprimirLista();

	}

    
}
