/**
 * Classe que contém o método principal para executar a busca de números primos.
 * 
 * @author Isabela Bella Bortoleto
 * @version 1.2
 */

public class Primo {

    public Primo() {
    }

    /**
     * Método para verificar se um número é primo
     * 
     * @param n o número a ser verificado
     * @return true se o número for primo, false caso contrário
     */
    public static boolean ehPrimo(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
