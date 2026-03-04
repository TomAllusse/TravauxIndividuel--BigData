package fr.nexus.erp;

public class Main {
    public static void main(String[] args){
        /* Niveau d'accréditation => Autorisation */
        int niveauAccess = 10;
        if(!SystemBoot.checkAccess(niveauAccess))
            return;

        SystemBoot.getEtape();
        DataEngine.runPipeline();

        /* Niveau d'accréditation => Refus */
        int niveauAccessRefus = 3;
        if(!SystemBoot.checkAccess(niveauAccessRefus))
            return;
    }
}
