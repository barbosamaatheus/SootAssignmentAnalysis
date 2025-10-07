import br.ufpe.cin.analysis.AssignmentCountingAnalysis;
import br.ufpe.cin.sootsetup.SootConfiguration;
import org.junit.jupiter.api.Test;
import soot.SootClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssignmentCountingAnalysisTest {

    @Test
    void testAssignmentCountingInExampleMethod() {
        // Nome da classe de teste que está em src/main/java
        String className = "br.ufpe.cin.samples.Test";

        // Inicializa SOOT e carrega a classe alvo
        SootConfiguration.setupSoot("target/test-classes/");

        // Executa a análise e obtém o número de atribuições
        int totalAssignments = AssignmentCountingAnalysis.run(className);

        // Verifica se o número de atribuições é o esperado
        assertEquals(16, totalAssignments, "O número de atribuições deve ser 16 para o total de métodos");
    }
}
