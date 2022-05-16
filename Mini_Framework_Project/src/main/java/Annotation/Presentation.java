package Annotation;

import InjectionAnotation.ConfigurationAnotattion;
import metier.Imetier;

import java.lang.reflect.InvocationTargetException;
public class Presentation {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
    //Scanner les packages dao & metier
    ConfigurationAnotattion context=new ConfigurationAnotattion();
        context.getClasses("dao", "metier");
    Imetier imetier= (Imetier) context.getInstances().get(Imetier.class);

        System.out.println(imetier.calcule());
}}

