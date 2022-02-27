package pres;
import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOC_Spring_XML {
    public static void main(String[] args) {
        ApplicationContext context=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        // Objet de type IMetier
        IMetier metier=(IMetier) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}

