public class AppCarga {
    public static void main(String[] args) {

        if (args.length < 3) {
            System.err.println("AppCarga [inicial] [final] [peso do caminhão]");
            System.exit(1);
        }
        String ini = args[0];
        String fim = args[1];
        double pesoCaminhao = Double.parseDouble(args[2]);

        // A ideia é: cria o grafo, mas omite as arestas
        // por onde o caminhão não pode passar

        EdgeWeightedDigraph g = new EdgeWeightedDigraph();
        In arq = new In("exemplos/carga.txt");
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(" ");
            String v = dados[0];
            String w = dados[1];
            double peso = Double.parseDouble(dados[2]);
            double limitePeso = Double.parseDouble(dados[3]);
            // System.out.println(v+" "+w+" "+peso);
            if (pesoCaminhao <= limitePeso)
                g.addEdge(v, w, peso);
        }

        // Neste ponto o grafo está montado
        // System.out.println(g.toDot());
        System.out.println("Total arestas: " + g.getTotalEdges());

        DijkstraSP dij = new DijkstraSP(g, ini);
        if (!dij.hasPathTo(fim))
            System.out.println("Sem caminho para " + fim + "!");
        else {
            for (Edge e : dij.pathTo(fim)) {
                System.out.println(e);
                e.setColor("color=red penwidth=3");
            }
            System.out.println("Tempo total: " + dij.distTo(fim));
        }
        Out saida = new Out("caminho.dot");
        saida.print(g.toDot());
        saida.close();
    }
}
