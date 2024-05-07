package utilitarios;

import java.util.ArrayList;
import java.util.List;

public class GrafoMatrizAdj {
    private int matriz[][];
    private int numVertices;

    //Construtor
    public GrafoMatrizAdj(int numVertices) {
        this.matriz = new int[numVertices][numVertices];
        this.numVertices = numVertices;
    }

    //Adiciona aresta nao direcionado
    public void addAresta(int i, int j) {
        //Desconsiderar a linha e coluna 0
        i--;
        j--;

        if (i < 0 || j < 0 || i >= numVertices || j >=numVertices) {
            System.out.println("Vértices inválidos");
            return;
        } else {
            matriz[i][j] = 1;
            matriz[j][i] = 1;
        }
    }

    //Adiciona aresta nao direcionado
    public void addArestaDir(int destino, int origem) {
        //Desconsiderar a linha e coluna 0
        destino--;
        origem--;

        if (destino < 0 || origem < 0 || destino >= numVertices || origem >= numVertices) {
            System.out.println("Vértices inválidos");
            return;
        } else {
            matriz[origem][destino] = -1;
            matriz[destino][origem] = 1;
        }
    }

    //Remove aresta 
    public void removeAresta(int i, int j) {
        i--;
        j--;

        if( i >= numVertices || j >=numVertices ||matriz[i][j]==0){
            System.out.println("Essa aresta não existe\n");
            System.out.println("\nDe enter para continuar");
            new java.util.Scanner(System.in).nextLine(); //Pausa ate o enter
        }
        else{
            matriz[i][j] = 0;
            matriz[j][i] = 0;
        }
        
    }
    
    public boolean isAresta(int i, int j) {
        return matriz[i][j] == 1; 
    }

    // Mostra a representação da matriz 
     public void imprimizrMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //retorna os sucessores
    public List<Integer> getSucessores(int v) {
    List<Integer> sucessores = new ArrayList<>();
    for (int i = 0; i < numVertices; i++) {
        if (matriz[v][i] == 1) {
            sucessores.add(i);
        }
    }
    return sucessores;
    }
    //retorna os predecessores
    public List<Integer> getPredecessores(int v) {
    List<Integer> predecessores = new ArrayList<>();
    for (int i = 0; i < numVertices; i++) {
        if (matriz[i][v] == 1) {
            predecessores.add(i);
        }
    }
    return predecessores;
}
    
}
