package fr.nexus.erp;

public class SystemBoot {
    public static boolean checkAccess(int niveau) {
        if(niveau < 5){
            System.out.println("Accès refusé => Le niveau d'accréditation trop faible !");
            return false;
        }else{
            System.out.println("Accès autorisé. Bienvenue !");
            return true;
        }
    }

    public static void getEtape(){
        String[] lesEtapes = {"Initialisation", "Connexion DB", "Nettoyage", "Export"};

        System.out.println("============================================");
        System.out.println("ETAPE :");
        for(String etape : lesEtapes){
            System.out.println("- " + etape);
        }
        System.out.println("============================================");
    }
}
