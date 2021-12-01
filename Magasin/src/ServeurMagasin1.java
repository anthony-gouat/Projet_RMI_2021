import java.rmi.RemoteException;

public class ServeurMagasin1 {
    public static void main(String[] args) {
        //        try {
//            int port = 8000;
//            LocateRegistry.createRegistry(port);
//            Naming.rebind ("rmi://127.0.0.1:"+port+"/Magasin1", new Magasin());
//            System.out.println ("Magasin prêt !");
//        } catch (Exception e) {
//            System.out.println ("Echec serveur magasin " + e);
//        }
        try {
            Magasin m = new Magasin();
            m.connexionClient("meyer", "test");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
