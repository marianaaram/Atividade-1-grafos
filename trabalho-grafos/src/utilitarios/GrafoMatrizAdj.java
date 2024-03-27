package utilitarios;

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
        if (i < 0 || j < 0 || i >= numVertices || j >= numVertices) {
            System.out.println("Vértices inválidos");
            System.exit(0);
        } else {
            matriz[i][j] = 1;
            matriz[j][i] = 1;
        }
    }

    //Adiciona aresta nao direcionado
    public void addArestaDir(int i, int j) {
        matriz[i][j] = 1;
        matriz[j][i] = 1;
    }

    //Remove aresta 
    public void removeAresta(int i, int j) {
        matriz[i][j] = 0;
        matriz[j][i] = 0;
    }
    //?
    public boolean isAresta(int i, int j) {
        return matriz[i][j] == 1; //ERRO
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

    
}
