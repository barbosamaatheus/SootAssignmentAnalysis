package br.ufpe.cin.analysis;

import soot.*;
import soot.jimple.AssignStmt;

public class AssignmentCountingAnalysis {

    /**
     * Executa a análise de contagem de instruções de atribuição
     * em todos os métodos concretos de uma classe.
     *
     * @return Número total de instruções de atribuição encontradas
     */
    public static int run(String className) {
        int assignmentCount = 0;
        for (SootMethod method : Scene.v().loadClassAndSupport(className).getMethods()) {
            if (!method.isConcrete()) continue;

            Body body = method.retrieveActiveBody();

            for (Unit u : body.getUnits()) {
                if (u instanceof AssignStmt) {
                    assignmentCount++;
                }
            }

            System.out.println("Method: " + method.getName());
            System.out.println("→ Total assignment statements: " + assignmentCount);
            System.out.println("------------------------------");
        }
        return assignmentCount;
    }
}
