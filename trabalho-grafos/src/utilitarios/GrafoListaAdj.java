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

    //Adicionar aresta 
    public void addAresta(int i, int j) {
        if (i > adjListMap.size() || j > adjListMap.size()) {
            return;
        }
        List<Integer> srcList = adjListMap.get(i);
        srcList.add(j);
        List<Integer> destList = adjListMap.get(j);
        destList.add(i);
    }

    //Remover aresta 
    public void removeAresta(int i, int j) {
        if (i > adjListMap.size() || j > adjListMap.size()) {
            return;
        }
        List<Integer> srcList = adjListMap.get(i);
        srcList.remove(j);
        List<Integer> destList = adjListMap.get(j);
        destList.remove(i);
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


    
}
