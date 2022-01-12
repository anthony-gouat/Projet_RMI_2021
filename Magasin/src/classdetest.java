import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;

public class classdetest {
    public static void main(String[] args) {

        try {
            int port = 8000;
            BanqueInterface banque = (BanqueInterface) Naming.lookup("rmi://127.0.0.3:" + port + "/banque");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatterDB = new SimpleDateFormat("yyyy-MM-dd");
            String date = "01/10/2022";
            Date dateexp = formatter.parse(date);
            String dateFormatDB = formatterDB.format(dateexp);

            if(banque.verifSoldeClient("DUPOND","1234567891011120",dateFormatDB,"465",345)) System.out.println(banque.debite("1234567891011120",345));

        } catch (Exception e) {
            System.out.println ("Banque exception: " + e);
        }
    }

}
