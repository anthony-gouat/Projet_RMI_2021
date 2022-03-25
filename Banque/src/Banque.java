import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Banque extends UnicastRemoteObject implements BanqueInterface {
    // Infos de connexion à la BDD de la banque
    private Connection conn = null;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/";
    static final String DB = "projet_rmi_banque";

    // Identifiants de la bdd
    static final String USER = "agouat2";
    static final String PASS = "";

    public Banque() throws RemoteException {
        super();
        try {
            // Connexion à la BDD
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL+DB, USER, PASS);
        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    // Vérifie si le solde du client est supérieur au montant
    @Override
    public boolean verifSoldeClient(String nom,String numero, String dateexpiration, String cryptogramme, float montant) throws RemoteException {
        try{
            String sql = "SELECT * FROM clients "
                        + "JOIN carte ON carte.id = clients.carte_id "
                        + "WHERE carte.numero = ? ;";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,numero);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {// si le client existe
                String nomClient = rs.getString("nom");
                String date_exp = rs.getString("date_exp");
                String crypto = rs.getString("crypto");
                double solde = rs.getDouble("solde");
                System.out.println(date_exp);
                System.out.println(rs.getString("id"));
                return (crypto.equals(cryptogramme) && date_exp.equals(dateexpiration) && solde >= montant);
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return false;
    }

    // Débite le montant au client
    @Override
    public boolean debite(String nom,String numero, String dateexpiration, String cryptogramme, float montant,String magasin) throws RemoteException {

            try{
                String sql =  "UPDATE clients "
                            + "JOIN carte ON carte.id = carte_id "
                            + "SET solde=(solde-?) "
                            + "WHERE carte.numero = ? AND carte.date_exp = ? AND carte.crypto = ?;";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDouble(1,montant);
                stmt.setString(2,numero);
                stmt.setString(3,dateexpiration);
                stmt.setString(4,cryptogramme);
                stmt.executeUpdate();
                return true;
            }catch (SQLException sqle){
                sqle.printStackTrace();
            }
        return false;
    }

}
