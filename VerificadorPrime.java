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