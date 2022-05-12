import java.util.ArrayList;

public class AgArayuz implements IAgArayuz,ISubject {
    private IObserver observer;
    private IKullanici kullanici;
    private IEkran ekran;
    private ITusTakimi veri;
    private IVeritabani veritabani;
    private IMerkeziIslemBirimi cpu;
    private ArrayList observers;
    private String kullaniciadi;
    private  int sifre;
    Anamenu menu=new Anamenu();
    public AgArayuz() {
        this.ekran=new Ekran();
        this.kullanici=new Kullanici(kullaniciadi,sifre);
        this.veri=new TusTakimi();
        this.veritabani=new Veritabani();
        this.cpu=new MerkeziIslemBirimi();
    }

    @Override
    public void attach(IObserver o) {
        observers.add(o);
    }

    @Override
    public void detach(IObserver o) {
        int i=observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notify(boolean kisi) {
        for(int i=0;i<observers.size();i++){
            observer=(IObserver) observers.get(i);
            if (kisi==true) {
                //kullanıcı girişini kaydeder.
                observer.update(KullaniciDogrula(kullanici));
                ekran.mesajGoruntule("Kullanıcı girişi yapıldı. ad ="+kullanici.getKullaniciAdi());
            }
        }
    }

    @Override
    public void Basla() {


        do{
           ekran.mesajGoruntule("Hoşgeldiniz");
           ekran.mesajGoruntule("Kullanıcı Adınızı Giriniz :");
           kullaniciadi=veri.veriAlString();
           ekran.mesajGoruntule("Şifrenizi Giriniz :");
           sifre= veri.veriAlInt();
           kullanici = new Kullanici(kullaniciadi,sifre);
        }while (!KullaniciDogrula(kullanici));
        ekran.mesajGoruntule(kullanici.getKullaniciAdi()+", Başarıyla Giriş Yaptınız.");
        IslemYap();

    }

    @Override
    public boolean KullaniciDogrula(IKullanici kullanici) {
        ekran.mesajGoruntule("Veritabanına bağlanılıyor...");
        if(!veritabani.baglan())
        {
            ekran.mesajGoruntule("Veritabanına bağlanılamıyor.");
            return false;
        }
        if(!veritabani.kullaniciKontrol(kullanici))
        {
            ekran.mesajGoruntule("Kullanıcı adı veya şifreniz hatalıdır.");
            return false;
        }
        else{
            return true;
        }
    }

    public void IslemYap()
    {
        String devam;
        do {
            menu.AnaMenuyuGoster();
            int secim = veri.veriAlInt();
            cpu.islemiGerceklestir(secim);
            ekran.mesajGoruntule("Devam etmek istiyor musunuz?(e/h)");
            devam= veri.veriAlString();
        }while ((devam.equalsIgnoreCase("E") && devam.equalsIgnoreCase("e")));
        ekran.mesajGoruntule("Görüşmek üzere.");
    }

}
