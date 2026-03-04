package fr.nexus.erp;

public class Main {
    public static void main(String[] args){
        if(!SystemBoot.checkAccess(10))
            return;

        SystemBoot.getEtape();
        DataEngine.runPipeline();
    }
}
