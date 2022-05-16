package Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Component est une annotation au niveau de la classe.
 * Il est utilisé pour désigner une classe en tant que composant.
 * l'annotation peut être appliquée pour Class, interface or enumeration
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation_Component {
}
