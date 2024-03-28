package utilitarios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GrafoListaAdj {

    private Map<Integer, List<Integer>> adjListMap;

    //Construtor 
    public GrafoListaAdj(int vertices) {
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

    //Obter o grau de entrada de um vertice direcionado
    public int grauEntrada(int vertice) {
        if (!adjListMap.containsKey(vertice)) {
            return 0; // Retorna 0 se o vértice não existir
        }
        int grauEntrada = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            List<Integer> vizinhos = entry.getValue();
            if (vizinhos.contains(vertice)) {
                grauEntrada++;
            }
        }
        return grauEntrada;
    }

    
}
