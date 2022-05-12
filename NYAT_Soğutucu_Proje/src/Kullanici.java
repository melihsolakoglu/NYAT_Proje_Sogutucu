public class Kullanici implements IKullanici {
    private String kullaniciAdi;
    private int sifre;

    public Kullanici(String kullaniciAdi, int sifre) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
    }
    public String getKullaniciAdi() {
        return kullaniciAdi;
    }
    public int getSifre() {
        return sifre;
    }
}

