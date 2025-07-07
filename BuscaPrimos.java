/**
 * Classe que executa a busca de números primos em um intervalo específico.
 * 
 * @author Isabela Bella Bortoleto
 * @version 1.2
 */

public class BuscaPrimos implements Runnable {
    private int inicio;
    private int fim;

    public BuscaPrimos(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fim; i++) {
            if (Primo.ehPrimo(i)) {
                System.out.println(i);
            }
        }
    }
}

