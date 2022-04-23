# Gestion des étudiants
Application JEE en spring pour gérer les étudiant.
# Enancé :
Créer une application Web basée sur Spring MVC, Spring Data JPA et Spring Security qui permet de gérer des étudiants.
Chaque étudiant est défini par:
- Son id
- Son nom
- Son prénom
- Son email
- Sa date naissance
- Son genre : MASCULIN ou FEMININ
- Un attribut qui indique si il est en règle ou non
  L'application doit offrir les fonctionnalités suivantes :
- Chercher des étudiants par nom
- Faire la pagination
- Supprimer des étudiants en utilisant la méthode (DELETE au lieu de GET)
- Saisir et Ajouter des étudiants avec validation des formulaires
- Editer et mettre à jour des étudiants
- Créer une page template
- Sécuriser l'accès à l'application avec un système d'authentification basé sur Spring security en utilisant la stratégie UseDetails Service
- Ajouter d'autres fonctionnalités supplémentaires
# Compte Rendu :
> ## 1- Créer l'entité Etudiant : 
* L'entité `Etudiant`.

<img width="441" alt="1" src="https://user-images.githubusercontent.com/98979712/164910485-61a53781-51d0-4462-824d-ed11c118846d.PNG">


* L'entité `Genre` de type enum.

<img width="350" alt="2" src="https://user-images.githubusercontent.com/98979712/164910497-f43c5d7b-828d-49d0-9934-66d97fb0a250.PNG">


> ## 2- Créer le repository  EtudiantRepository : 
<img width="503" alt="3" src="https://user-images.githubusercontent.com/98979712/164910507-b5a69b05-3431-4545-8b51-99ae2a045073.PNG">


> ## 3- Créer le controller  EtudiantController :

* Home page:

<img width="377" alt="4" src="https://user-images.githubusercontent.com/98979712/164910523-394507b8-281e-4d71-b164-cf521a894a5f.PNG">


* Liste des étudiants + pagination + recherche par mot clé:

 <img width="671" alt="5" src="https://user-images.githubusercontent.com/98979712/164910528-6637842a-8131-49fb-b266-1c49494ba68b.PNG">


* Supprimer un étudiant par id:

  <img width="421" alt="6" src="https://user-images.githubusercontent.com/98979712/164910538-3fc64764-767f-49c1-989a-f126701d8e26.PNG">


* Ajouter un nouveau étudiant:

  <img width="414" alt="7" src="https://user-images.githubusercontent.com/98979712/164910554-8a6358be-3d27-4bf8-be62-16542ffc44b9.PNG">


* Modifier un étudiant:

  <img width="487" alt="8" src="https://user-images.githubusercontent.com/98979712/164910577-a1ecc96b-a47a-4862-98cd-31a3a7359ffc.PNG">


* Login:

 <img width="233" alt="9" src="https://user-images.githubusercontent.com/98979712/164910587-558f6c60-3d47-41e3-b76f-a73e1dcf340a.PNG">


* Insertion des étudiants dans la base de données:

<img width="638" alt="10" src="https://user-images.githubusercontent.com/98979712/164910595-f16c5bed-3ac9-40dd-a1eb-bdfb589b94e5.PNG">


* Les propriétés spring boot:

  <img width="605" alt="11" src="https://user-images.githubusercontent.com/98979712/164910601-aadf4692-6121-44ff-b656-88da22f7b52e.PNG">


> ## 4- Spring Security
* Les entités user & role:

 <img width="388" alt="13" src="https://user-images.githubusercontent.com/98979712/164910607-4c20c982-04a8-48d4-8447-7391c3b76eb1.PNG">

 <img width="415" alt="12" src="https://user-images.githubusercontent.com/98979712/164910614-414475cb-1b2b-452f-b5b0-f9c70d33513c.PNG">

  
* UserRepository:

  <img width="505" alt="14" src="https://user-images.githubusercontent.com/98979712/164910625-22a0dce7-f8dc-40f7-93c1-34571f1af671.PNG">

  
* RoleRepository:

 <img width="486" alt="15" src="https://user-images.githubusercontent.com/98979712/164910634-383ced04-6269-4509-9d5f-dc5c5148282d.PNG">

  
* SecurityConfig:

  
<img width="616" alt="16" src="https://user-images.githubusercontent.com/98979712/164910641-eb1933b1-9209-448e-a53a-7b09e171f0af.PNG">

> ## 5- La page d'acceuil
 
<img width="934" alt="17" src="https://user-images.githubusercontent.com/98979712/164910656-fadebb5c-23d2-4f0c-8f93-04bbd5e1d276.PNG">

> ## 6- Authentification avec le role ADMIN
  
<img width="933" alt="18" src="https://user-images.githubusercontent.com/98979712/164910685-aac932c3-ce5c-47af-98f7-5fad73028bd5.PNG">

> ## 7- La liste des étudiants

<img width="932" alt="19" src="https://user-images.githubusercontent.com/98979712/164910684-c9476bab-78b2-49ba-8675-cd1dd6168052.PNG">

> ## 8- Ajouter étudiant

<img width="935" alt="20" src="https://user-images.githubusercontent.com/98979712/164910690-01cd9057-c781-41e4-9751-ce26a57c0dde.PNG">

> ## 9- Modifier étudiant

<img width="933" alt="21" src="https://user-images.githubusercontent.com/98979712/164910823-cb8df19b-57c9-4af1-9f62-0cec08a07cd8.PNG">


> ## 10- Authentification avec le role USER

* Cet utilisateur à le droit de consulter la liste des étudiant mais peut pas faire des operation comme la suppression,la modification ou l'ajout.

 <img width="933" alt="22" src="https://user-images.githubusercontent.com/98979712/164910835-7edb31b4-dbde-428d-9cbe-70539fef9883.PNG">

  <img width="933" alt="23" src="https://user-images.githubusercontent.com/98979712/164910847-f91ba1a0-f08c-442a-ba72-4ce313dc6160.PNG">


> ## 11- Page d'erreur 404
<img width="933" alt="24" src="https://user-images.githubusercontent.com/98979712/164910858-94c29540-e272-4d21-a293-9c0b6db200c9.PNG">


> ## 12- La structure du projet
<img width="329" alt="25" src="https://user-images.githubusercontent.com/98979712/164910867-902a8a10-0ac9-4d89-b1f4-e7f907adc508.PNG">
