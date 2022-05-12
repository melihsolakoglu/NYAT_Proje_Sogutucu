public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    Eyleyici e = new Eyleyici();
    SicaklikAlgilayici s=new SicaklikAlgilayici();
    Ekran ekran=new Ekran();
    public void islemiGerceklestir(int secim){
       switch (secim)
       {
           case 1:
               e.sogutucuAc();
               break;
           case 2:
               e.sogutucuKapat();
               break;
           case 3:
               s.sicaklikOku();
               break;
           default:
               ekran.mesajGoruntule("Lütfen geçerli işlem seçiniz.");


       }
    }
}
