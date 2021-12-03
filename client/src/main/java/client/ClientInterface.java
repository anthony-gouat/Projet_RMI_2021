package client;

import java.rmi.RemoteException;

public interface ClientInterface extends java.rmi.Remote {
    public boolean demandeConfirmation(String magasin, double montant) throws RemoteException;
}
