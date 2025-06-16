import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Prime{

     public static void main(String[] args) {
        // Define os limites e tamanho das faixas
        final int LIMITE_INFERIOR = 0;
        final int LIMITE_SUPERIOR = 100000; // 0 a 99999
        final int TAMANHO_FAIXA = 1000;
        final int NUMERO_FAIXAS = (LIMITE_SUPERIOR - LIMITE_INFERIOR) / TAMANHO_FAIXA;

        // Cria um pool de threads com 10 threads (ajuste conforme necessidade)
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Submete as tarefas para cada faixa
        for (int i = 0; i < NUMERO_FAIXAS; i++) {
            int inicio = i * TAMANHO_FAIXA;
            int fim = inicio + TAMANHO_FAIXA;
            executor.execute(new VerificadorPrimo(inicio, fim));
        }
            executor.shutdown(); // Encerra o executor após conclusão das tarefas
    }
     // Classe que verifica primos em uma faixa específica
    static class VerificadorPrimo implements Runnable {
        private final int inicio;
        private final int fim;

        public VerificadorPrimo(int inicio, int fim) {
            this.inicio = inicio;
            this.fim = fim;
        }

        @Override
        public void run() {
            for (int num = inicio; num < fim; num++) {
                if (ehPrimo(num)) {
                    System.out.println(num); // Thread-safe (PrintStream é sincronizado)
                }
            }
        }

        // Método para verificar se um número é primo
        private boolean ehPrimo(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
    }
}
