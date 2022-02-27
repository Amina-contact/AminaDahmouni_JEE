package pres;
import ext.DaoImpl2;
import metier.MetierImpl;
public class Presentation {
    public static void main(String[] args) {
        /** Injection des dépendances par instanciation statique
        * statique => new qu'est le vrai probleme de la maintenance*/
        //DaoImpl dao=new DaoImpl();
        DaoImpl2 dao=new DaoImpl2();
        /**Injection des depandences avec constructeur*/
         //MetierImpl metier=new MetierImpl(dao);
        /**Avec Autowired*/
        MetierImpl metier=new MetierImpl();
        metier.setDao(dao);
        System.out.println("Résultats = "+metier.calcul());
    }
}
