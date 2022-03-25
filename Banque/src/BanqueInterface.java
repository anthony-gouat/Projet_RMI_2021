import java.rmi.RemoteException;

public interface BanqueInterface extends java.rmi.Remote {
    public boolean verifSoldeClient(String nom,String numero, String dateexpiration, String cryptogramme, float montant) throws RemoteException; // Vérifie si le solde du client est supérieur au montant
    public boolean debite(String nom,String numero, String dateexpiration, String cryptogramme, float montant,String magasin) throws RemoteException; // Débite le montant au client
}