public class Eyleyici implements IEyleyici {
    SogutucuAc sogutucuAc=new SogutucuAc();
    SogutucuKapat sogutucuKapat=new SogutucuKapat();
    public void sogutucuAc(){
        sogutucuAc.sogutucuYazi();
    }
    public void sogutucuKapat(){
        sogutucuKapat.sogutucuYazi();
    }
}
