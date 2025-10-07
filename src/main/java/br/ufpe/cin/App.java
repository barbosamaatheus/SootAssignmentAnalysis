package br.ufpe.cin;

import br.ufpe.cin.analysis.AssignmentCountingAnalysis;
import br.ufpe.cin.sootsetup.SootConfiguration;
import soot.SootClass;

public class App
{
    public static void main( String[] args )
    {
        // Defina aqui o nome da classe a ser analisada (sem .java)
        String className = "Test";

        // Inicializa o SOOT e carrega a classe
        SootConfiguration.setupSoot("target/classes/");

        // Executa a análise de contagem de atribuições
        AssignmentCountingAnalysis.run(className);
    }
}
