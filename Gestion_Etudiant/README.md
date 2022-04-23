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

<img src="./captures/1.png" width="600">

* L'entité `Genre` de type enum.

<img src="./captures/2.png" width="600">

> ## 2- Créer le repository  EtudiantRepository : 
<img src="./captures/3.png" width="600">

> ## 3- Créer le controller  EtudiantController :

* Home page:

<img src="./captures/4.png" width="600">

* Liste des étudiants + pagination + recherche par mot clé:

  <img src="./captures/5.png" width="600">

* Supprimer un étudiant par id:

  <img src="./captures/6.png" width="600">

* Ajouter un nouveau étudiant:

  <img src="./captures/7.png" width="600">

* Modifier un étudiant:

  <img src="./captures/8.png" width="600">

* Login:

 <img src="./captures/9.png" width="200">

* Insertion des étudiants dans la base de données:

<img src="./captures/10.png" width="600">

* Les propriétés spring boot:

  <img src="./captures/11.png" width="600">

> ## 4- Spring Security
* Les entités user & role:

  <img src="./captures/13.png" width="600">
  <img src="./captures/12.png" width="600">
  
* UserRepository:

  <img src="./captures/14.png" width="600">
  
* RoleRepository:

  <img src="./captures/15.png" width="600">
  
* SecurityConfig:

  <img src="./captures/16.png" width="600">

> ## 5- La page d'acceuil
  <img src="./captures/17.png" width="600">

> ## 6- Authentification avec le role ADMIN
  <img src="./captures/18.png" width="600">

> ## 7- La liste des étudiants
<img src="./captures/19.png" width="600">

> ## 8- Ajouter étudiant
<img src="./captures/20.png" width="600">

> ## 9- Modifier étudiant

<img src="./captures/21.png" width="600">

> ## 10- Authentification avec le role USER

* Cet utilisateur à le droit de consulter la liste des étudiant mais peut pas faire des operation comme la suppression,la modification ou l'ajout.

  <img src="./captures/22.png" width="600">
  <img src="./captures/23.png" width="600">

> ## 11- Page d'erreur 404
<img src="./captures/24.png" width="600">

> ## 12- La structure du projet
<img src="./captures/25.png" width="600">