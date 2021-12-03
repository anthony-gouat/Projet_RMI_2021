import java.rmi.RemoteException;

public interface BanqueInterface extends java.rmi.Remote {
    public boolean verifSoldeClient(String nom,String numeroCarte, String dateExpiration, String cryptogramme, double montant) throws RemoteException;
    public boolean debite(String numeroCarte,String nom, double montant,String magasin) throws RemoteException;
}
