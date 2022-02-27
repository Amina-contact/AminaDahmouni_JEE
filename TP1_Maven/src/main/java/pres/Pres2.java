package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException,
                                                  InstantiationException, IllegalAccessException,
                                                  NoSuchMethodException, InvocationTargetException {
        Scanner scanner=new Scanner(new File("config.txt"));
        /**Lire le premier ligne du fichier config.txt*/
        String daoClassName=scanner.nextLine();
        /**Charger la classe dans la mémoire*/
        Class cDao=Class.forName(daoClassName);
        /**Instancier la classe fait appel au constructeur par défaut
         * newInstance() retourne une classe de type Object*/
        IDao dao =(IDao) cDao.newInstance();

        String metierClassName= scanner.nextLine();
        Class cMetier=Class.forName(metierClassName);
        IMetier metier=(IMetier) cMetier.newInstance();

        Method method=cMetier.getMethod("setDao",IDao.class);
        /** Injection des dépandances d'une manière dynamique*/
        method.invoke(metier,dao);//exécuter la methode
        System.out.println("Résultat=>"+metier.calcul());
    }
}
