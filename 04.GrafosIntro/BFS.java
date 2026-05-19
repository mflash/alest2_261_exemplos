import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {
    private Set<String> marked; // vértices já visitados
    private Map<String, String> edgeTo; // antecessores de cada vértice na árvore de caminhos
    private Map<String, Integer> distTo; // distância em arestas do start até cada vértice
    private String start; // vértice inicial

    public BFS(Graph g, String start) {
        this.start = start;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        bfs(g, start);
    }

    private void bfs(Graph g, String s) {
        LinkedList<String> fila = new LinkedList<>();
        // System.out.println(">>> Entrando em " + s);
        marked.add(s); // "marca" como visitado
        // Para cada vizinho w de s...
        for (String w : g.getAdj(s)) {
            // Se não estiver marcado...
            if (!marked.contains(w)) {
                // System.out.println(">>> Vou visitar " + w + " a partir de " + s);
                // edgeTo.put(w, s); // indica que para chegar em w, viemos de s
                // dfs(g, w);
            } else {
                // System.out.println("!!! Não visito " + w + " pois já está marcado");
            }
        }
        // System.out.println(">>> Saindo de " + s);
    }

    // Retorna true se há caminho a partir de start até v
    public boolean hasPathTo(String v) {
        if (marked.contains(v))
            return true;
        return false;
    }

    // Retorna o caminho de start até v
    public List<String> pathTo(String v) {
        LinkedList<String> caminho = new LinkedList<>();
        if (!hasPathTo(v))
            return caminho; // retorna lista vazia se não houver caminho
        while (!v.equals(start)) {
            caminho.addFirst(v);
            v = edgeTo.get(v);
        }
        caminho.addFirst(start); // ou v
        return caminho;
    }

    public static void main(String[] args) {
        Graph g = new Graph("exemplos/tinyG.txt");
        BFS bfs = new BFS(g, "0");

        // Mostra todos os caminhos encontrados
        for (String v : g.getVerts()) {
            System.out.print(v + ": ");
            if (bfs.hasPathTo(v)) {
                for (String w : bfs.pathTo(v)) {
                    System.out.print(w + " ");
                }
                System.out.println();
            } else
                System.out.println("não tem caminho...");
        }
    }
}
