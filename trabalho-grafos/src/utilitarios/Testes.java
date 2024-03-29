package utilitarios;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Testes {
    
    private Map<Integer, List<Integer>> adjListMap;

    //Construtor 
    public Testes(int vertices) {
        adjListMap = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i <= vertices ; i++) {
            adjListMap.put(i, new LinkedList<Integer>());
        }
    }
    
    public boolean isGrafoSimples() {
    // Verifica laços
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            int vertice = entry.getKey();
            List<Integer> vizinhos = entry.getValue();
            if (vizinhos.contains(vertice)) {
                return false;
            }
        }

        // Verifica arestas paralelas
        for (Map.Entry<Integer, List<Integer>> entry : adjListMap.entrySet()) {
            int vertice = entry.getKey();
            List<Integer> vizinhos = entry.getValue();
            for (int vizinho : vizinhos) {
                if (adjListMap.containsKey(vizinho)) {
                    List<Integer> vizinhosVizinho = adjListMap.get(vizinho);
                    if (vizinhosVizinho.contains(vertice)) {
                        return false;
                    }
                }
            }
        }

        return true; // O grafo é simples
    }
    
public boolean isGrafoRegular(GrafoListaAdj grafo) {
        int grauReferencia = grafo.grauVertice(1); // Obtemos o grau do primeiro vértice como referência
        for (int vertice = 2; vertice <= grafo.getNumVertices(); vertice++) {
            if (grafo.grauVertice(vertice) != grauReferencia) {
                return false; // Se algum vértice tem um grau diferente, o grafo não é regular
            }
        }
        return true; // Se chegarmos até aqui, todos os vértices têm o mesmo grau
    }
}