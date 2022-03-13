package ma.enset.jpaap.repositories;
import ma.enset.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
public interface PatientRepository extends JpaRepository<Patient,Long> {
//on definie la methode sans l'implémenter sela va étre fait par spring

 //Chercher la liste des patient selon l'attribut malade
  public List<Patient> findByMalade(boolean m);

//Retourne une page
  public Page<Patient> findByMalade(boolean m, Pageable pageable);

 /*List<Patient> findByMaladeAndScoreLessThan(boolean m,int score);
 List<Patient> findByMaladeIsTrueAndScoreLessThan(boolean m,int score);
 List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1, Date d2,String mc);

 @Query("select p from  Patient  p where  p.nom  like :x and p.score<:y")
 List<Patient> chercherPatients(@Param("x") String nom,@Param("y") int scoreMin);

 @Query("select p from  Patient  p where  p.dateNaissance between  :x and :y or p.nom like :z")
 List<Patient> chercherPatients1(@Param("x") Date d1,@Param("y") Date d2,@Param("z") String nom);*/
}

