package metier;
import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class MetierImpl implements IMetier{
    /**@Autowired pour faire l'injection des dépendances
     * on demande à spring au moment qu'on il instancie la classe
     * MetierImpl de chercher parmi les objets qu'il a crée un objet
     * de type IDao et l'injecter dans la variable dao
     */
    @Autowired
    @Qualifier("dao2")
    private IDao dao;
    /*public MetierImpl(IDao dao) {
        this.dao = dao;
    }*/
    @Override
    public double calcul() {
        double tmp= dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
    //affecter une valeur à dao
    /** Injecter dans la variable dao un objet d'une
     *  classe qu'implemente l'interface IDao
     */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
