public class AppCompara {
   public static void main(String[] args) {
    In arq = new In("DomCasmurro_utf8.txt");
    SeparateChainingHashST<String, Integer> dic = new SeparateChainingHashST<>();
    while(arq.hasNextLine()) {
        String linha = arq.readLine();
        for(String pal: linha.split(" ")) {
            pal = pal.toLowerCase();
            //System.out.println(pal);
        }
    }
   } 
}
