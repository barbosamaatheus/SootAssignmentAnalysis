import br.ufpe.cin.analysis.ReassignmentCountingAnalysis;
import br.ufpe.cin.sootsetup.SootConfiguration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReassignmentCountingAnalysisTest {

    @Test
    void testAssignmentCountingInExampleMethod() {
        // Nome da classe de teste que está em src/main/java
        String className = "br.ufpe.cin.samples.Test";

        // Inicializa SOOT e carrega a classe alvo
        SootConfiguration.setupSoot("target/test-classes/");

        // Executa a análise e obtém o número de atribuições
        int totalAssignments = ReassignmentCountingAnalysis.run(className);

        // Verifica se o número de atribuições é o esperado
        assertEquals(2, totalAssignments, "O número metodos que tem atribuições para a mesma varival deve ser 2");
    }
}
