package Configuration_XML;
import dao.IDao;
import metier.Imetier;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public class ConfigurationXML {
    private String nomfile;
    public ConfigurationXML(String nomfile) {
        this.nomfile = nomfile;
    }
    public String getClassDao() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(nomfile));
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("framework");
        String firstname = null;
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                firstname = element.getElementsByTagName("dao").item(0).getTextContent();
            }
        }
        return firstname;
    }

    public String getClassMetier() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(nomfile));
        doc.getDocumentElement().normalize();
        NodeList list = doc.getElementsByTagName("framework");
        String metier = null;
        for (int temp = 0; temp < list.getLength(); temp++) {
            Node node = list.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                metier = element.getElementsByTagName("metier").item(0).getTextContent();
            }
        }
        return metier;
    }
public Imetier getClasse() throws InstantiationException, IllegalAccessException, ParserConfigurationException, IOException, SAXException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
    /**Charger la classe dans la mémoire*/
    Class cDao=Class.forName(getClassDao());
    /**Instancier la classe fait appel au constructeur par défaut
     * newInstance() retourne une classe de type Object*/
    IDao dao=(IDao) cDao.newInstance();
    Class cmetier=Class.forName(getClassMetier());
    Imetier metier= (Imetier) cmetier.newInstance();
    Method method=cmetier.getMethod("setDao",IDao.class);
    /** Injection des dépandances d'une manière dynamique
     *  Executer la méthode*/
    method.invoke(metier,dao);
    return  metier;
}
}
