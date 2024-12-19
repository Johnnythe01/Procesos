class Hilo extends Thread {
    private final int n; // Número de elementos a calcular

    public Hilo(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        calcularFibonacci();
    }

    // Método que calcula e imprime la sucesión de Fibonacci
    private void calcularFibonacci() {
        int a = 1, b = 1; // Los dos primeros números de Fibonacci

        for (int i = 0; i < n; i++) {
            System.out.print(a + (i < n - 1 ? ", " : "\n")); // Imprime el número
            int nuevo = a + b; // Suma los dos anteriores
            a = b; // Actualiza a
            b = nuevo; // Actualiza b
        }
    }
}