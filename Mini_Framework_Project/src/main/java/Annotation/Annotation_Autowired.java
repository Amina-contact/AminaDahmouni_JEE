package Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @Target Pour créer une annotation personnalisée
 * l'annotation peut être appliquée pour une méthode,constructeur et champ
 */

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
/**
 * RetentionPolicy.RUNTIME : les annotations annotées à l'aide de la
 * politique de rétention RUNTIME sont conservées pendant l'exécution et
 * sont accessibles dans notre programme pendant l'exécution.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Annotation_Autowired {
}
