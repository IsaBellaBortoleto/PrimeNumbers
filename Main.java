/**
 * Função principal que executa a busca de números primos em paralelo.
 * 
 * @author Isabela Bella Bortoleto
 * @version 1.2
 */

public class Main {
    public static void main(String[] args) {
        int limite = 100_000;
        int passo = 1000;
        Thread[] threads = new Thread[limite / passo];

        for (int i = 0; i < threads.length; i++) {
            int inicio = i * passo;
            int fim = Math.min(inicio + passo, limite);
            BuscaPrimos buscaPrimos = new BuscaPrimos(inicio, fim);
            threads[i] = new Thread(buscaPrimos);
            threads[i].start();
        }

        // Aguarda todas as threads terminarem
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread foi interrompida", e);
            }
        }

        System.out.println("Busca de primos concluída.");
    }
}
