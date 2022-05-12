public class SogutucuFactory {
    public static  ISogutucu createSogutucu(Class aclass) throws IllegalAccessException, InstantiationException{
        return (ISogutucu) aclass.newInstance();
    }
}