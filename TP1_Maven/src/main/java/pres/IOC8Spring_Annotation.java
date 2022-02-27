package pres;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class IOC8Spring_Annotation {
    public static void main(String[] args) {
        //Scanner les packages dao & metier
        ApplicationContext context=
                new AnnotationConfigApplicationContext("dao","metier","ext");
        IMetier metier=context.getBean(IMetier.class);
        System.out.println(metier.calcul());
    }
}
