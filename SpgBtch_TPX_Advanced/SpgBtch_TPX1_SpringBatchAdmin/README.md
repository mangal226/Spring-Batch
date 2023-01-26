Exemples autours du monitoring des Batchs.

----

# TPX1_0_base
Le projet contient les éléments permettant de gérer une base de données H2.

Les applications Java suivantes sont mises à disposition : 
- `StartServerH2`
    + Démarre une instance H2
- `StartSwingConsole`
    + Lance une console Swing sur la base
- `CreateBase`
    + Ajoute la structure des données métier en base (i.e. table BIBLIOTHEQUE)
- `UpdateBase_1_SpringBatch`
    + Ajoute la structure permettant d'utiliser dans Spring Batch un repo de type Base
- `UpdateBase_2_SpringCloudTask`
    + Ajoute la structure complémentaire permettant d'utiliser dans Spring Cloud Task un repo de type Base.
    + La structure Spring Batch doit être présente
- `UpdateBase_3_SpringCloudDataFlow`
    + Ajoute la structure complémentaire permettant d'utiliser dans Spring Cloud DataFlow un repo de type Base.
    + Les structures Spring Batch et Spring Cloud Task doivent être présentes

La configuration Spring principale est définie dans `MainConfiguration`

La base H2 est :
- démarrée en mode Serveur sur le port `9092`
- stockée dans l'arbo : `target/database`
- nom de l'instance : `dataSource`
- le compte utilisée est : `sa`, sans mot de passe
- l'accès web est démarré : http://localhost:8082

----

# TPX1_1_job
Le projet contient 2 jobs :
- `tpx1Job` : réimplémentation du TP2 en définissant la config Spring uniquement en Java
    + la configuration est stockée dans `tpx1.job.properties`
- `tpx1Job2` : Tasklet avec exploitation d'un Job Parameter `msg`

La configuration Spring principale est définie dans `MainConfiguration`

2 possibilité de lancement des jobs :
- classe Java : `LaunchTpx1Job` et `LaunchTpx1Job2`
- launcher Eclipse : `TPX1Lanceur_tpx1Job.launch` et `TPX1Lanceur_tpx1Job2.launch`

----

# TPX1_2_admin
Le projet montre un exemple de Spring Batch Admin embarquant des jobs. Il a donc en dépendance :
- Spring Batch Admin en version 1.3.1.RELEASE (dernière version existante).
- TPX1_1_job pour les jobs.

NB : L'utilisation de Spring Batch Admin limite la version de Spring Batch (max version 3) et donc la version de Spring (max version 4).

Spring Batch Admin permet une surcharge de sa configuration :
- `META-INF/spring/batch/jobs/job-config.xml` : définition des jobs
- `META-INF/spring/batch/servlet/override/manager-context.xml`: ajout bean de type `ResourceBundle` pour associer une description à chaque job
    + la description du job `<jobId>` est référencée par la propriété `<jobId>.description` (cf. fichier `messages.properties`)
- `batch-<environnement>.properties` : configuration générale lié principalement à la base, et associée à l'environnement `<environnement>`
    + l'environnement est défini via la propriété system `ENVIRONMENT`, et valorisé par défaut à hsql (cf. `spring-batch-admin-manager.jar!/META-INF/spring/batch/bootstrap/manager/env-context.xml`)
    + configuration fournie : `batch-default.properties`

Application Web à déployer.
Pour Tomcat (ou tcServer), spécification de `ENVIRONMENT` dans le fichier `catalina.properties` :
```properties
ENVIRONMENT=default
```

URL de la console d'admin : http://localhost:8080/TPX1_2_admin

La console permet entre autres de : 
- voir les jobs enregistrés
- lancer un job, avec paramètres
- consulter les comptes rendus d'exécution
- les actions sont également accessibles via API REST

----

# TPX1_3a_springboot
Il s'agit du job `tpx1Job` packagé en tant que Spring Cloud Task

Le projet a été initialisé via l'Initializr Spring : https://start.spring.io/ en utilisant : 
- Spring Boot en version 1.5,
- Dépendances __Batch__ (spring batch 3.0) et __Cloud Task__ (spring cloud task 1.2)

Le projet `TPX1_1_job` est ajouté en dépendance.

L'annotation `@EnableTask` permet de définir le job en tant que Spring Cloud Task, et non comme simple application Spring Boot.

`application.properties` contient classiquement la configuration d'une application Spring Boot.

Un _hack_ est implémenté dans `Tpx1JobApplication` afin que la Task soit en erreur (défini par son exit code) si un step du job n'est pas __COMPLETED__. ll est associé à la property `spring.cloud.task.closecontextEnabled=false` évitant la fermeture prématurée du contexte Spring

----

# TPX1_3b_springboot
Il s'agit du job `tpx1Job2` packagé en tant que Spring Cloud Task.

----

# TPX1_3c_springcloudtask
Le projet montre l'implémentation d'une Task sans pour autant être défini en tant que Batch

La Task `Tp1xTask` affiche en sysout : 
- le nom de la Task, défini via la property `tp1x.taskName` de cette Task
- le `<message>` fournit via l'option `--msg=<message>`

Les éléments suivants contribuent à la définition de la property :
- dépendance `spring-boot-configuration-processor` permet la génération paa défaut de la property en utilisant le code et la javadoc
- `META-INF/additional-spring-configuration-metadata.json` : permet de surcharger les éléments liés à la génération auto, notamment la valeur par défaut.
- `META-INF/spring-configuration-metadata-whitelist.properties` : utilisé pour définir les properties visibles.

Comme pour les Batchs, on retrouve la notion de __ExecutionListener__

----

# TPX1_4_springclouddataflow
Le projet permet de tester en local Spring Cloud DataFlow, en version 1.7

La configuation de démarrage utilisée est définie dans le fichier `application.properties`. On y retrouve notamment la configuration liée à la base et aux repo maven

Une fois démarré, la console Web est accesible via l'URL : http://localhost:9393/dashboard

La gestion des Task (enregistrement des Apps, création des Tasks, exécution des Tasks, ...) peut être réalisée, soit via la console, soit via le shell (Spring Cloud DataFlow Shell)

Le script `start_dataflow_shell.bat` permet de démarrer le Shell.
Le fichier `dataflow_shell_cmd.md` recense quelles commandes

L'App `composed-task-runner` permet de définir des Tasks par composition, avec possibilité de conditionner les transitions sur le résultat de la Task (un peu comme dans Spring Batch). Il y a une DSL spécifique (cf. la doc)
