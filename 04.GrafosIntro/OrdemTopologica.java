import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class OrdemTopologica {
    private Set<String> marked; // vértices já visitados
    private List<String> ordemTopo; // lista com os vértices em ordem topológica

    public OrdemTopologica(Digraph g) {
        marked = new HashSet<>();
        ordemTopo = new LinkedList<>();
        for(String start: g.getVerts().stream().sorted().toList()) {
            if(!marked.contains(start))
                dfs(g, start);
        }
    }

    private void dfs(Digraph g, String s) {
        // System.out.println(">>> Entrando em " + s);
        marked.add(s); // "marca" como visitado
        // Para cada vizinho w de s...
        for (String w : g.getAdj(s)) {
            // Se não estiver marcado...
            if (!marked.contains(w)) {
                // System.out.println(">>> Vou visitar " + w + " a partir de " + s);
                dfs(g, w);
            } else {
                // System.out.println("!!! Não visito " + w + " pois já está marcado");
            }
        }
        // System.out.println(">>> Saindo de " + s);
        // Pós-ordem!
        // ordemTopo.add(s);
        // Pós-ordem invertida
        ordemTopo.addFirst(s);
    }

    public Iterable<String> getOrdemTopo() {
        return ordemTopo;
    }

    public static void main(String[] args) {
        Digraph g = new Digraph("exemplos/tinyG.txt");
        OrdemTopologica ot = new OrdemTopologica(g);

        for(String v: ot.getOrdemTopo())
            System.out.println(">>> "+v);

        System.out.println(g.toDot());
    }
}
