package br.ufpe.cin.sootsetup;

import soot.Scene;
import soot.SootClass;
import soot.options.Options;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class SootConfiguration {

    public static void setupSoot(String classPath) {
        List<String> classes = Collections.singletonList(classPath);
        // Configurações básicas do SOOT
        Options.v().set_no_bodies_for_excluded(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_output_format(soot.options.Options.output_format_jimple);
        Options.v().set_whole_program(true);
        Options.v().set_process_dir(classes);
        Options.v().set_full_resolver(true);
        Options.v().set_keep_line_number(true);
        Options.v().set_prepend_classpath(true);
        Options.v().set_soot_classpath(Scene.v().defaultClassPath() + File.pathSeparator + classPath);

        configureSootJBOptions();

        // Garante que todas as dependências foram carregadas
        Scene.v().loadNecessaryClasses();



    }

    private static void configureSootJBOptions() {
        Options.v().setPhaseOption("jb", "use-original-names:true");

        Options.v().setPhaseOption("jb.dtr", "enabled:false");   // Duplicate CatchAll Trap Remover
        Options.v().setPhaseOption("jb.ese", "enabled:false");   // Empty Switch Eliminator
        Options.v().setPhaseOption("jb.ls", "enabled:false");    // Local Splitter
        Options.v().setPhaseOption("jb.sils", "enabled:false");  // Shared Initialization Local Splitter
        Options.v().setPhaseOption("jb.a", "enabled:false");     // Jimple Local Aggregator
        Options.v().setPhaseOption("jb.ule", "enabled:false");   // Unused Local Eliminator
        Options.v().setPhaseOption("jb.tr", "enabled:false");    // Type Assigner
        Options.v().setPhaseOption("jb.ulp", "enabled:false");   // Unsplit-originals Local Packer
        Options.v().setPhaseOption("jb.lns", "enabled:false");   // Local Name Standardizer
        Options.v().setPhaseOption("jb.cp", "enabled:false");    // Copy Propagator
        Options.v().setPhaseOption("jb.dae", "enabled:false");   // Dead Assignment Eliminator
        Options.v().setPhaseOption("jb.cp-ule", "enabled:false");// Post-copy propagation Unused Local Eliminator
        Options.v().setPhaseOption("jb.lp", "enabled:false");    // Local Packer
        Options.v().setPhaseOption("jb.ne", "enabled:false");    // Nop Eliminator
        Options.v().setPhaseOption("jb.uce", "enabled:false");   // Unreachable Code Eliminator
        Options.v().setPhaseOption("jb.tt", "enabled:false");    // Trap Tightener
        Options.v().setPhaseOption("jb.cbf", "enabled:false");   // Conditional Branch Folder
    }
}
