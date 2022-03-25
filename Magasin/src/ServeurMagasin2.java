import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurMagasin2 {
    // Démarre le serveur RMI du magasin sur le port 8800
    public static void main(String[] args) {
        try {
            int port = 8800;
//            LocateRegistry.createRegistry(port);
            Naming.rebind ("rmi://127.0.0.1:"+port+"/mag2", new Magasin("projet_rmi_magasin_2","magasin 2"));
            System.out.println ("Magasin prêt !");
        } catch (Exception e) {
            System.out.println ("Echec serveur magasin " + e);
        }
    }
}
