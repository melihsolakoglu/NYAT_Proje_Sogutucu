import java.sql.*;
import java.util.concurrent.ExecutionException;

public class Veritabani implements IVeritabani{
    private Connection connection;
    @Override
    public boolean baglan() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/NYAT_Proje";
        String username = "postgres";
        String password = "12345";
        try{
            connection = DriverManager.getConnection(jdbcURL,username,password);
            return true;
        }
        catch (Exception e) {
            System.out.println("Veritabanına bağlanırken hata oluştu.");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean kullaniciKontrol(IKullanici kullanici) {
        String sql = "SELECT * FROM \"Kullanicilar\" WHERE \"ad\"='"+kullanici.getKullaniciAdi()+"' AND \"sifre\"='"+kullanici.getSifre()+"'";
        try
        {
            Statement stmnt = connection.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
            if(rs.next())
            {
                return true;
            }
            else return false;
        }catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }
}
