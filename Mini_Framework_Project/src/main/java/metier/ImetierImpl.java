package metier;
import Annotation.Annotation_Autowired;
import Annotation.Annotation_Component;
import dao.IDao;
@Annotation_Component
public class ImetierImpl implements Imetier {
    /**@Annotation_Autowired pour faire l'injection des dépendances
     * on demande au framework au moment qu'on il instancie la classe
     * MetierImpl de chercher parmi les objets qu'il a crée un objet
     * de type IDao et l'injecter dans la variable dao
     */
    @Annotation_Autowired
    private IDao dao;
    @Override
    public double calcule() {
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
