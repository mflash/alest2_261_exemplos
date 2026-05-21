import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CicloDirigido {
    private enum Estado {
        WHITE, BLACK, GRAY
    }

    private Map<String, Estado> marked; // vértices já visitados, não visitados ou em processamento
    private Map<String, String> edgeTo; // antecessores de cada vértice na árvore de caminhos
    private boolean hasCycle; // true se encontrar ciclo

    public CicloDirigido(Digraph g) {
        marked = new HashMap<>();
        edgeTo = new HashMap<>();
        for (String v : g.getVerts())
            marked.put(v, Estado.WHITE);
        for (String start : g.getVerts()) {
            if (marked.get(start) == Estado.WHITE) {
                System.out.println("Iniciando DFS em " + start);
                if (dfs(g, start) == true) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(Digraph g, String s) {
        // System.out.println(">>> Entrando em " + s);
        marked.put(s, Estado.GRAY); // indica que está em processamento
        // Para cada vizinho w de s...
        for (String w : g.getAdj(s)) {
            // Se não tiver sido visitado...
            if (marked.get(w) == Estado.WHITE) {
                // System.out.println(">>> Vou visitar " + w + " a partir de " + s);
                edgeTo.put(w, s); // indica que para chegar em w, viemos de s
                if (dfs(g, w) == true)
                    return true;
            } else {
                if (marked.get(w) == Estado.GRAY) {
                    System.out.println("Ciclo detectado em " + s + "->" + w);
                    return true;
                }
            }
        }
        marked.put(s, Estado.BLACK); // indica que terminou
        return false;

        // System.out.println(">>> Saindo de " + s);
    }

    // Retorna true se há ciclo
    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        // Graph g = new Graph("exemplos/tinyG.txt");
        Digraph g = new Digraph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("C", "E");
        g.addEdge("C", "D");
        // g.addEdge("D", "A");
        g.addEdge("F", "G");
        g.addEdge("G", "H");
        g.addEdge("H", "F");
        CicloDirigido c = new CicloDirigido(g);

        if (c.hasCycle())
            System.out.println("Tem ciclo!");
        else
            System.out.println("Não tem ciclo...");
    }
}
