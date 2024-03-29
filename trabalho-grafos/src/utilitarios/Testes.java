package utilitarios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Set<Integer> vertices = adjListMap.keySet();
    
        // Verifica laços
        for (int vertice : vertices) {
            List<Integer> vizinhos = adjListMap.get(vertice);
            if (vizinhos.contains(vertice)) {
                return false;
            }
        }
    
        // Verifica arestas paralelas
        Set<String> arestas = new HashSet<>();
        for (int vertice : vertices) {
            List<Integer> vizinhos = adjListMap.get(vertice);
            for (int vizinho : vizinhos) {
                String aresta = String.format("%d-%d", Math.min(vertice, vizinho), Math.max(vertice, vizinho));
                if (!arestas.add(aresta)) {
                    return false;
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

    public boolean isGrafoCompleto(GrafoListaAdj grafo) {
        int numVertices = grafo.getNumVertices();

        // Verifica se cada vértice está conectado a todos os outros vértices
        for (int i = 1; i <= numVertices; i++) {
            for (int j = 1; j <= numVertices; j++) {
                if (i != j && !grafo.isAresta(i, j)) {
                    return false; // Se não houver uma aresta entre dois vértices diferentes, o grafo não é completo
                }
            }
        }
        return true; // Se passar por todos os pares de vértices e houver uma aresta entre eles, o grafo é completo
    }
}