package fr.nexus.erp;

public class Main {
    public static void main(String[] args){
        int niveauAccess = 3;
        if(!SystemBoot.checkAccess(niveauAccess))
            return;

        SystemBoot.getEtape();
        DataEngine.runPipeline();
    }
}
