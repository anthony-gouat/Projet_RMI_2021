import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurMagasin1 {
    public static void main(String[] args) {
        try {
            int port = 8800;
            LocateRegistry.createRegistry(port);
            Naming.rebind ("rmi://127.0.0.1:"+port+"/mag1", new Magasin("projet_rmi_magasin_1","magasin 1"));
            System.out.println ("Magasin prêt !");
        } catch (Exception e) {
            System.out.println ("Echec serveur magasin " + e);
        }
    }
}
