# Formation Spring Batch
## TP N°6 - Annotation

### Objectifs
* Savoir configurer un batch Spring Batch uniquement par annotations.

### Ce qu'il faut faire
1) (~30min) Implémenter une classe de configuration Spring Batch et supprimer le dossier context.

### Comment procéder étape par étape
#### 1) Créer une classe de configuration Spring Batch
 - Déclarer les annotations @Configuration et @EnableBatchProcessing au niveau de la classe pour la déclarer comme classe de configuration Spring Batch, et ajouter l'annotation @PropertySource avec le chemin vers le fichier de propriétés
 - Créer des attributs Autowired de type JobBuilderFactory et StepBuilderFactory pour déclarer la configuration des jobs et des steps
 - Créer une méthode annotée @Bean qui retourne un objet de type Job
 - Créer des méthodes qui retournent un Step, un ItemReader et un ItemWriter

#### 2) Ajouter la configuration de la datasource
 - Créer les méthodes d'initialisation des objets JobRepository, JobLauncher, DataSource
 - Créer la méthode d'initialisation d'un DataSourceInitializer à l'aide d'un constructeur en lui fournissant la datasource et un databasePopulator
 - Créer un ResourceDatabasePopulator pour le DataSourceInitializer pour créer la base avec le script sql prévu

#### 3) Modifier le launcher Spring Batch
Le 1er argument devient le nom complet de la classe principale de configuration à la place du fichier XML