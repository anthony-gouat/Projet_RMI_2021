package client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientInterface {
    Client() throws RemoteException {
        super();
    }

    /**
     *
     * une popup avec 2btns "valider" et "refuser"
     * et le message " Le 'magasin' veut vous débiter de 'montant'"
     *
     */
    @Override
    public boolean demandeConfirmation(String magasin, double montant) throws RemoteException {
        return false;
    }
}
