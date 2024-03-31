package utilitarios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GrafoListaAdj {

    private int numVertices;
    private Map<Integer, List<Integer>> adjListMap;

    //Construtor 
    public GrafoListaAdj(int vertices) {
        numVertices = vertices;
        adjListMap = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= vertices ; i++) {
            adjListMap.put(i, new LinkedList<Integer>());
        }
    }

    //Adicionar aresta nao direcionada
    public void addAresta(int i, int j) {
        if (i > adjListMap.size() || j > adjListMap.size()) {
            return;
        }
        List<Integer> srcList = adjListMap.get(i);
        srcList.add(j);
        List<Integer> destList = adjListMap.get(j);
        destList.add(i);
    }

    //Adicionar aresta direcionada 
    public void addArestaDirecionada(int origem, int destino) {
        if (origem > adjListMap.size() || destino > adjListMap.size()) {
            return;
        }
        List<Integer> srcList = adjListMap.get(origem);
        srcList.add(destino);
    }


    //Remover aresta 
    public void removeAresta(int i, int j) {
        if (i > adjListMap.size() || j > adjListMap.size()) {
           return;
        }

        List<Integer> srcList = adjListMap.get(i);
        srcList.remove(Integer.valueOf(j)); // Remove o vértice j da lista de adjacência do vértice i
        List<Integer> destList = adjListMap.get(j);
        destList.remove(Integer.valueOf(i)); // Remove o vértice i da lista de adjacência do vértice j

    }

    //?
    public boolean isAresta(int i, int j) {
        if (i > adjListMap.size() || j > adjListMap.size()) {
            return false;
        }
        List<Integer> srcList = adjListMap.get(i);
        return srcList.contains(j);
    }

    //Imprime a lista
    public void imprimirLista() {
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            int vertice = entry.getKey();
            List<Integer> vizinhos = entry.getValue();
            System.out.print("Vértice " + vertice + " está conectado a: ");
            for (int vizinho : vizinhos) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }

    //Obter a vizinhança de um vértice
    public List<Integer> vizinhanca(int vertice) {
        if (!adjListMap.containsKey(vertice)) {
            return new LinkedList<Integer>(); // Retorna uma lista vazia se o vértice não existir
        }
        return adjListMap.get(vertice);
    }

    //Obter o grau de um vértice nao direcionado
    public int grauVertice(int vertice) {
        if (!adjListMap.containsKey(vertice)) {
            return 0; // Retorna 0 se o vértice não existir
        }
        return adjListMap.get(vertice).size(); //Grau de saida
    }

    // Método para verificar se há uma aresta direcionada do vértice origem para o vértice destino
    public boolean isArestaDirecionada(int origem, int destino) {
        if (origem > adjListMap.size() || destino > adjListMap.size()) {
            return false;
        }
        List<Integer> srcList = adjListMap.get(origem);
        return srcList.contains(destino);
    }

    // Método para obter o grau de saída de um vértice em um grafo direcionado
    public int grauSaida(int vertice) {
        if (!adjListMap.containsKey(vertice)) {
            return 0; // Retorna 0 se o vértice não existir
        }
        return adjListMap.get(vertice).size(); // Grau de saída é o número de arestas saindo do vértice
    }

    // Método para obter o grau de entrada de um vértice em um grafo direcionado
    public int grauEntrada(int vertice) {
        if (!adjListMap.containsKey(vertice)) {
            return 0; // Retorna 0 se o vértice não existir
        }
        int grauEntrada = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            List<Integer> vizinhos = entry.getValue();
            if (vizinhos.contains(vertice)) {
                grauEntrada++; // Incrementa o grau de entrada para cada vértice que tem uma aresta entrando nele
            }
        }
        return grauEntrada;
    }

    public boolean isGrafoSimples() {
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            int vertice = entry.getKey();
            List<Integer> vizinhos = entry.getValue();
            // Verificar se há laços
            if (vizinhos.contains(vertice)) {
                return false;
            }
            // Verificar se há múltiplas arestas
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int vizinho : vizinhos) {
                countMap.put(vizinho, countMap.getOrDefault(vizinho, 0) + 1);
            }
            for (int count : countMap.values()) {
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Método para verificar se o grafo é regular
    public boolean isGrafoRegular() {
        int grauReferencia = grauVertice(1); // Obtemos o grau do primeiro vértice como referência
        for (int vertice = 2; vertice <= numVertices; vertice++) {
            if (grauVertice(vertice) != grauReferencia) {
                return false; // Se algum vértice tem um grau diferente, o grafo não é regular
            }
        }
        return true; // Se chegarmos até aqui, todos os vértices têm o mesmo grau
    }

    // Método para verificar se o grafo é completo
    public boolean isGrafoCompleto() {
        // Verifica se cada vértice está conectado a todos os outros vértices
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= numVertices; j++) {
                if (i != j && !isAresta(i, j)) {
                    return false; // Se não houver uma aresta entre dois vértices diferentes, o grafo não é completo
                }
            }
        }
        return true; // Se passar por todos os pares de vértices e houver uma aresta entre eles, o grafo é completo
    }

    // Método para verificar se um grafo não direcionado é bipartido
    public boolean isGrafoBipartido() {
        // Inicializa o array para armazenar as cores dos vértices
        int[] cores = new int[numVertices + 1];
        // Inicializa a fila para o algoritmo BFS
        Queue<Integer> fila = new LinkedList<>();

        // Inicializa o primeiro vértice com a cor 1 e o adiciona à fila
        cores[1] = 1;
        fila.add(1);

        // Executa o algoritmo BFS
        while (!fila.isEmpty()) {
            int vertice = fila.poll();
            // Percorre os vizinhos do vértice atual
            for (int vizinho : adjListMap.get(vertice)) {
                // Se o vizinho não estiver colorido, atribui a cor oposta ao vértice atual
                if (cores[vizinho] == 0) {
                    cores[vizinho] = -cores[vertice];
                    fila.add(vizinho);
                }
                // Se o vizinho estiver colorido com a mesma cor do vértice atual, o grafo não é bipartido
                else if (cores[vizinho] == cores[vertice]) {
                    return false;
                }
            }
        }
        // Se chegarmos até aqui, o grafo é bipartido
        return true;
    }

    // Método para verificar se o grafo direcionado é regular
    public boolean isGrafoRegularDirecionado() {
        int grauSaidaReferencia = grauSaida(1); // Obtemos o grau de saída do primeiro vértice como referência
        int grauEntradaReferencia = grauEntrada(1); // Obtemos o grau de entrada do primeiro vértice como referência
        for (int vertice = 2; vertice <= numVertices; vertice++) {
            if (grauSaida(vertice) != grauSaidaReferencia || grauEntrada(vertice) != grauEntradaReferencia) {
                return false; // Se algum vértice tem um grau de saída ou de entrada diferente, o grafo não é regular
            }
        }
        return true; // Se chegarmos até aqui, todos os vértices têm o mesmo grau de saída e de entrada
    }

    // Método para verificar se o grafo direcionado é completo
    public boolean isGrafoCompletoDirecionado() {
        // Verifica se cada par de vértices distintos possui uma aresta direcionada
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= numVertices; j++) {
                if (i != j && !isArestaDirecionada(i, j)) {
                    return false; // Se não houver uma aresta direcionada de i para j, o grafo não é completo
                }
            }
        }
        return true; // Se passar por todos os pares de vértices e houver uma aresta direcionada de i para j, o grafo é completo
    }

    // Método para verificar se um grafo direcionado é bipartido
    public boolean isGrafoBipartidoDirecionado() {
        // Inicializa o array para armazenar os conjuntos de vértices
        int[] conjuntos = new int[numVertices + 1];
        
        // Executa a busca em profundidade (DFS) para atribuir os conjuntos aos vértices
        for (int i = 1; i <= numVertices; i++) {
            if (conjuntos[i] == 0 && !dfsBipartidoDirecionado(i, 1, conjuntos)) {
                return false; // Se um conjunto inválido for encontrado, o grafo não é bipartido
            }
        }
        // Se chegarmos até aqui, o grafo é bipartido
        return true;
    }

    // Função auxiliar para a busca em profundidade (DFS) em um grafo direcionado bipartido
    private boolean dfsBipartidoDirecionado(int vertice, int conjunto, int[] conjuntos) {
        // Atribui o conjunto atual ao vértice
        conjuntos[vertice] = conjunto;
        
        // Percorre os vizinhos do vértice
        for (int vizinho : adjListMap.get(vertice)) {
            // Se o vizinho já estiver no mesmo conjunto, o grafo não é bipartido
            if (conjuntos[vizinho] == conjunto) {
                return false;
            }
            // Se o vizinho ainda não tiver conjunto atribuído, chama recursivamente a DFS com o conjunto oposto
            else if (conjuntos[vizinho] == 0 && !dfsBipartidoDirecionado(vizinho, -conjunto, conjuntos)) {
                return false;
            }
        }
        return true;
    }

}
