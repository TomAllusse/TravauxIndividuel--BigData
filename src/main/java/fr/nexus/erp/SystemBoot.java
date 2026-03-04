package fr.nexus.erp;

public class SystemBoot {
    public static boolean checkAccess(int niveau) {
        if(niveau < 5){
            return false;
        }else{
            return true;
        }
    }

    public static void getEtape(){
        String[] lesEtapes = {"Initialisation", "Connexion DB", "Nettoyage", "Export"};

        for(String etape : lesEtapes){
            System.out.println("============================================");
            System.out.println(etape);
            System.out.println("============================================");
        }
    }
}
