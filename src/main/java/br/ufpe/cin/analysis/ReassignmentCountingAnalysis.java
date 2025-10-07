package br.ufpe.cin.analysis;

import soot.*;
import soot.jimple.AssignStmt;

import java.util.HashMap;
import java.util.Map;

public class ReassignmentCountingAnalysis {

    /**
     * Executa a análise de contagem de instruções de atribuição
     * em todos os métodos concretos de uma classe.
     *
     * @return Número de métodos que contêm múltiplas atribuições para a mesma variável
     */
    public static int run(String className) {
        int methodsWithReassignments = 0;

        for (SootMethod method : Scene.v().loadClassAndSupport(className).getMethods()) {
            if (!method.isConcrete()) continue;

            Body body = method.retrieveActiveBody();

            // Mapa para contar atribuições por variável local
            Map<Local, Integer> assignmentCountPerVariable = new HashMap<>();

            for (Unit u : body.getUnits()) {
                if (u instanceof AssignStmt) {
                    AssignStmt assignStmt = (AssignStmt) u;

                    // Verifica se o lado esquerdo é uma variável local
                    Value leftOp = assignStmt.getLeftOp();
                    if (leftOp instanceof Local) {
                        Local variable = (Local) leftOp;

                        // Incrementa o contador para essa variável
                        assignmentCountPerVariable.put(
                                variable,
                                assignmentCountPerVariable.getOrDefault(variable, 0) + 1
                        );
                    }
                }
            }

            // Verifica se há variáveis com múltiplas atribuições
            boolean hasReassignment = false;
            int totalAssignments = 0;

            System.out.println("Method: " + method.getName());

            for (Map.Entry<Local, Integer> entry : assignmentCountPerVariable.entrySet()) {
                Local var = entry.getKey();
                int count = entry.getValue();
                totalAssignments += count;

                if (count > 1) {
                    hasReassignment = true;
                    System.out.println("  → Variable '" + var.getName() + "' (" + var.getType() + "): " + count + " assignments");
                }
            }

            if (hasReassignment) {
                methodsWithReassignments++;
            }

            System.out.println("  → Total assignments: " + totalAssignments);
            System.out.println("  → Has reassignments: " + (hasReassignment ? "YES" : "NO"));
            System.out.println("------------------------------");
        }

        System.out.println("\n=== SUMMARY ===");
        System.out.println("Methods with reassignments: " + methodsWithReassignments);

        return methodsWithReassignments;
    }
}