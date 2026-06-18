public class AppCaminhoCritico {

    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph();

        In arq = new In("exemplos/jobsPC.txt");

        // Formato:
        // total_tarefas
        // duração total_deps [dep1 dep2 ...]
        // duração total_deps [dep1 dep2 ...]
        // duração total_deps [dep1 dep2 ...]
        // ...
        // Ex:
        // 10
        // 41.0 3 1 7 9
        // ...
        int totalTarefas = arq.readInt();
        arq.readLine(); // pula para próxima linha
        // System.out.println("Total de tarefas: " + totalTarefas);

        int vertAtual = 0;
        while (arq.hasNextLine()) {
            String linha = arq.readLine();
            String[] dados = linha.split(" ");

            double dur = Double.parseDouble(dados[0]);
            int totalDeps = Integer.parseInt(dados[1]);

            // Cria tarefa (2 vértices)
            g.addEdge(vertAtual + "", vertAtual + "e", dur);

            // Cria aresta do START para o início da tarefa com peso 0
            g.addEdge("START", vertAtual + "", 0);

            // Cria aresta do final da tarefa para o END com peso 0
            g.addEdge(vertAtual + "e", "END", 0);

            // Cria arestas para o início de cada dependente com peso 0
            for (int d = 0; d < totalDeps; d++) {
                g.addEdge(vertAtual + "e", dados[2 + d], 0);
            }
            vertAtual++;
        }
        System.out.println(g.toDot());
    }
}
