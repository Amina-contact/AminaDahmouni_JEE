package Injection_Constructeur;

import Extention.DaoImpl2;
import metier.ImetierImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Presentation {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<Class> list = new ArrayList<>();
        list.add(ImetierImpl.class);
        list.add(DaoImpl2.class);
        ConfigurionConstructors configurionConstructors = new ConfigurionConstructors(list);
        configurionConstructors.instacierInjection();
               ImetierImpl imt= (ImetierImpl) configurionConstructors.getListClass().get(ImetierImpl.class);
               System.out.println(imt.calcule());
   }
    }
