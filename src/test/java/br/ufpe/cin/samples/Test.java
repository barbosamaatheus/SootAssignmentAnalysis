package br.ufpe.cin.samples;

public class Test {

    // Método COM reatribuições (múltiplas atribuições para mesmas variáveis)
    public void methodWithReassignment() {
        int x = 1;      // 1ª atribuição para x
        int y = 2;      // 1ª atribuição para y
        x = y + 3;      // 2ª atribuição para x (reatribuição)
        y = x;          // 2ª atribuição para y (reatribuição)
    }

    // Método SEM reatribuições (cada variável recebe apenas uma atribuição)
    public void methodWithoutReassignment() {
        int a = 10;
        int b = 20;
        int c = a + b;
        int result = c * 2;
    }

    // Método COM reatribuição (loop)
    public void methodWithLoop() {
        int counter = 0;        // 1ª atribuição
        for (int i = 0; i < 5; i++) { // Múltiplas atribuição (i = 0, $stack4 = i, $stack3 = 5, i = i + 1)
            counter = counter + 1;  // Múltiplas reatribuições de counter
        }
    }

    // Método SEM reatribuição (apenas declarações)
    public void methodSimple() {
        String message = "Hello";
        int value = 42;
    }
}

