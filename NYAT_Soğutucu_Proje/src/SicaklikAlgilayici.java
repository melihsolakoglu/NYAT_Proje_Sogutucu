import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {
    Ekran ekran=new Ekran();
    @Override
    public Integer sicaklikOku() {

        Random random = new Random();
        int sicaklik = random.nextInt(30);
        ekran.mesajGoruntule("Soğutucunun sıcaklığı : "+sicaklik);
        return sicaklik;
    }

}