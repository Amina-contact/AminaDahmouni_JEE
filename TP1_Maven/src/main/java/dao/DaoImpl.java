package dao;
import org.springframework.stereotype.Component;
/** L'annotation @Component pour dire à Spring au démarrage
 * à chaque fois qu'il trouve une classe precedé par
 * @Component il va l'instancier et lui donner comme nom dao
 */
@Component("dao")
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("DaoImpl 1");
        double temp=Math.random()*40;
        return temp;
    }
}
