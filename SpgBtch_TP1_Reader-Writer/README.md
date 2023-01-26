# Formation Spring Batch
## TP N°1 - Reader & Writer

### Objectifs
* Comprendre comment fonctionne la mécanique du reader au travers de la lecture d'un fichier
* Comprendre comment fonctionne la mécanique du writer au travers d'une ecriture en base de donnée.

### Ce qu'il faut faire
1) (~45min) Implementer en Java une classe "reader" qui lit le fichier <code>tp1_bibliotheque.csv</code>.

2) (~45min) Implémenter en Java une classe "writer" qui insere les lignes lues dans la source de donnée <code>dataSourceId</code>.

### Comment procéder étape par étape
#### 1) Le reader
a. Dans la classe <code>com/soprasteria/academy/tp1/TP1Reader.java</code>
- Décrire la structure
  - Déclarer une variable de type <code>String</code> qui contiendra le chemin de la resource à lire.
  - Déclarer une variable de type <code>TP1LivreMapper</code> qui contiendra la référence du mapper qui permet de convertir une ligne lue en objet.
  - Ajouter les accesseurs publics de ses 2 attributs.
  - Déclarer une variable buffer de type <code>BufferedReader</code> et l'initialiser à <code>null</code>.

- Décrire les opérations
  - Déclarer que la classe implémente l'interface d'un reader SpringBatch (<code>ItemReader<></code>) sur le model <code>TP1Livre</code>.
  - Ajouter la méthode (<code>read()</code>) attendue par le compilateur
  - Implementer dans cette méthode la lecture du fichier et la convertion des lignes lues:
    - Si le buffer n'a pas encore été ouvert, l'initialiser une premiere (et unique) fois avec la ressource à lire (<code>BufferedReader</code> ← <code>InputStreamReader</code> ← <code>FileInputStream</code>)
    - A chaque fois que vous pouvez lire une nouvelle ligne du fichier, la convertir en objet à l'aide du mapper (<code>.mapStringToLivre()</code>) et le retourner (c'est lo'bjet qui sera traiter dans la suite du step).
    - S'il n'y a plus de lignes à lire, fermer le buffer et retourner <code>null</code>.

<em>Note: on pensera à eviter de convertir la premiere ligne du fichier qui contient des titres de colonnes.</em>

b. Dans la configuration spring <code>com/soprasteria/academy/tp1/context/reader/tp1.reader.context.xml</code>
- Décrire les beans
  - Creer un bean pour le mapper en référence de la classe <code>TP1LivreMapper.java</code>
  - Creer un bean pour le reader en référence de la classe <code>TP1Reader.java</code>
    - Injecter la valeur du chemin d'accès à la ressource dans la propriété correspondante du reader.
    - Injecter la référénce du mapper dans la propriété correspondante du reader.

#### 2) Le writer
a. Dans la classe <code>com/soprasteria/academy/tp1/TP1Writer.java</code>
- Décrire la structure
  - Déclarer une variable de type <code>String</code> qui contiendra la requete sql d'insertion d'une donnée.
  - Déclarer une variable de type <code>DataSource</code> qui contiendra la référence de la source de donnée.
  - Ajouter les accesseurs publics de ses 2 attributs.

- Décrire les opérations
  - Déclarer que la classe implémente l'interface d'un writer SpringBatch (<code>ItemWriter<></code>) sur le model <code>TP1Livre</code>.
  - Ajouter la méthode (<code>write()</code>) attendue par le compilateur
  - Implementer dans cette méthode la creation de l'objet en base de donnée:
    - Recuperer une connection sur la source de donnée (<code>.getConnection()</code>).
    - Sur cette connection, desactivé le commit automatique (<code>.setAutoCommit(false)</code>).
    - Préparer une déposition de la requete sur la connection (<code>.prepareStatement()</code>).
    - Pour chaque element de la liste:
      - Injecter les valeurs de l'objet dans la déposition.
      - Executer la déposition (<code>.executeUpdate()</code>).
    - Envoyer un ordre d'envoi pour valider cette transaction (<code>.commit()</code>).

<em>Note: on pensera à utiliser la notation try-with-resources de Java 8 pour l'ouverture de la connection et pour la préparation de la déposition.</em>

b. Dans la configuration spring <code>com/soprasteria/academy/tp1/context/reader/tp1.writer.context.xml</code>
- Décrire le bean
  - Creer un bean pour le writer en référence de la classe <code>TP1Writer.java</code>
    - Injecter la valeur de la requete sql d'insertion (<code>${bibliotheque.query.insert}</code>) dans la propriété correspondante du writer.
    - Injecter la référénce de la source de donnée (<code>dataSourceID</code>) dans la propriété correspondante du reader.
