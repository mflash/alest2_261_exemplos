import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloNaoDirigido {
    private Set<String> marked; // vértices já visitados
    private Map<String, String> edgeTo; // antecessores de cada vértice na árvore de caminhos
    private boolean hasCycle; // true se encontrar ciclo

    public CicloNaoDirigido(Graph g) {
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        for (String start : g.getVerts()) {
            if (!marked.contains(start)) {
                System.out.println("Iniciando DFS em " + start);
                if (dfs(g, start) == true) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(Graph g, String s) {
        // System.out.println(">>> Entrando em " + s);
        marked.add(s); // "marca" como visitado
        // Para cada vizinho w de s...
        for (String w : g.getAdj(s)) {
            // Se não estiver marcado...
            if (!marked.contains(w)) {
                // System.out.println(">>> Vou visitar " + w + " a partir de " + s);
                edgeTo.put(w, s); // indica que para chegar em w, viemos de s
                if (dfs(g, w) == true)
                    return true;
            } else {
                if (edgeTo.get(s) == null || !edgeTo.get(s).equals(w)) {
                    System.out.println("Ciclo detectado em " + s + "-" + w);
                    return true;
                }
            }
        }
        return false;
        // System.out.println(">>> Saindo de " + s);
    }

    // Retorna true se há ciclo
    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Graph g = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "E");
        g.addEdge("C", "D");
        // g.addEdge("D", "A");
        g.addEdge("F", "G");
        g.addEdge("G", "H");
        g.addEdge("H", "F");
        CicloNaoDirigido c = new CicloNaoDirigido(g);

        if (c.hasCycle())
            System.out.println("Tem ciclo!");
        else
            System.out.println("Não tem ciclo...");
    }
}
