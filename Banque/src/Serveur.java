import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
public class Serveur {
    // Démarre le serveur RMI de la banque sur le port 8810
    public static void main (String[] argv) {
        try {
            int port = 8810;
            LocateRegistry.createRegistry(port);
            Naming.rebind ("rmi://127.0.0.1:"+port+"/banque", new Banque());
            System.out.println ("Serveur de la banque prêt !");
        } catch (Exception e) {
            System.out.println ("Serveur de la banque échec " + e);
        }

    }
}
