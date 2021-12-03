import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Banque extends UnicastRemoteObject implements BanqueInterface {
    private Connection conn = null;
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/";
    static final String DB = "projet_rmi_banque";

    //  Database credentials
    static final String USER = "agouat2";
    static final String PASS = "";

    public Banque() throws RemoteException {
        super();

        try {
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
//            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(
                    DB_URL+DB, USER, PASS);
            System.out.println("Connected database successfully...");

        } catch (Exception se) {
            se.printStackTrace();
        }

    }

    @Override
    public boolean verifSoldeClient(String nom, String numeroCarte, String dateExpiration, String cryptogramme, double montant) throws RemoteException {
        try{
            //STEP 4: Execute a query
            System.out.println("SELECT client");

            String sql = "SELECT * FROM clients "
                        + "JOIN carte ON carte.id = clients.carte_id "
                        + "WHERE carte.numero = ? ;";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,numeroCarte);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                String nomClient = rs.getString("nom");
                String date_exp = rs.getString("date_exp");
                String crypto = rs.getString("crypto");
                double solde = rs.getDouble("solde");
                System.out.println(date_exp);
                System.out.println(rs.getString("id"));
                return (nomClient.equals(nom) && crypto.equals(cryptogramme) && date_exp.equals(dateExpiration) && solde > montant);
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean debite(String numeroCarte,String nom, double montant,String magasin) throws RemoteException {
        if(demandeConfirmation(nom,magasin,montant)){
            try{
                System.out.println("Debite client");

                String sql =  "UPDATE clients "
                            + "JOIN carte ON carte.id = carte_id "
                            + "SET solde=(solde-?) "
                            + "WHERE carte.numero = ? ;";

                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setDouble(1,montant);
                stmt.setString(2,numeroCarte);
                stmt.executeUpdate();
                return true;
            }catch (SQLException sqle){
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public boolean demandeConfirmation(String nom,String magasin, double montant) throws RemoteException {
        try {
            int port = 8000;
            ClientInterface client = (ClientInterface) Naming.lookup("rmi://127.0.0.1:" + port + "/"+nom);
            return client.demandeConfirmation(magasin,montant);
        } catch (Exception e) {
            System.out.println ("Banque exception: " + e);
        }
        return false;
    }
}
