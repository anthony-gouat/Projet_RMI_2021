import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.sql.*;
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
        Statement stmt = null;

        try{
            //STEP 4: Execute a query
            System.out.println("SELECT clients");
            stmt = conn.createStatement();

            String sql = "SELECT * FROM projet_rmi_banque.clients";

            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("carte_id"));
                System.out.println(rs.getString("nom"));
                System.out.println(rs.getDouble("solde"));
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return false;
    }
}
