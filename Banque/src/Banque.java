import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Banque extends UnicastRemoteObject implements BanqueInterface {

    public Banque() throws RemoteException {
        super();
    }

    @Override
    public boolean verifSoldeClient(String nom, String numeroCarte, String dateExpiration, String cryptogramme, double montant) throws RemoteException {

        return false;
    }
}
