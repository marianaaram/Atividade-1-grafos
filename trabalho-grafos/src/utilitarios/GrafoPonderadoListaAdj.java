package utilitarios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GrafoPonderadoListaAdj {

    private Map<Integer, List<Pair<Integer, Integer>>> adjListMap;

    public GrafoPonderadoListaAdj(int numVertices) {
        adjListMap = new HashMap<>();
        for (int i = 1; i <= numVertices; i++) {
            adjListMap.put(i, new ArrayList<>());
        }
    }

    // Adicionar aresta ponderada direcionada
    public void addArestaDirecionadaPonderada(int origem, int destino, int peso) {
        if (origem <= 0 || destino <= 0 || origem > adjListMap.size() || destino > adjListMap.size()) {
            return;
        }
        List<Pair<Integer, Integer>> srcList = adjListMap.get(origem);
        srcList.add(new Pair<>(destino, peso));
    }

    public boolean isAresta(int origem, int destino) {
        List<Pair<Integer, Integer>> vizinhos = adjListMap.get(origem);
        for (Pair<Integer, Integer> vizinho : vizinhos) {
            if (vizinho.getKey() == destino) {
                return true; // Aresta encontrada
            }
        }
        return false; // Aresta não encontrada
    }
    
    public boolean isGrafoCompleto() {
        // Verifica se cada vértice está conectado a todos os outros vértices
        for (int i = 1; i <= adjListMap.size(); i++) {
            for (int j = 1; j <= adjListMap.size(); j++) {
                if (i != j && !isAresta(i, j)) {
                    return false; // Se não houver uma aresta entre dois vértices diferentes, o grafo não é completo
                }
            }
        }
        return true; // Se passar por todos os pares de vértices e houver uma aresta entre eles, o grafo é completo
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}