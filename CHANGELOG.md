# Changelog
Ce fichier contient les modifications apportées sur les TP

## [Unreleased]

## [v1.0.5-20201005 ] - 2020-10-05

- TP7
    + solution
        * Utilisation du `JobParametersBuilder` pour construire le `JobParameters` à utiliser au lancement du Job
        * Lancement du step en rajoutant l'utilisation du `JobParameters` afin que le paramètre indiqué dans l'énoncé soit pris en compte (sinon le lancement est réalisé avec un paramètre `random`)

- TP8
    + solution
        * Ajout profile `monitor` avec utilisation `jobRepository` en Base + lancement console Swing
        * Ajout Launcher `TP8Lanceur_solution_profile_monitor.launch` pour lancer en utilisant ce profile.

## [v1.0.4-20191204 ] - 2019-12-04

- Ajout du fichier `CHANGELOG.md` pour faciliter le suivi des modifications

- TP0
    + Ajout archive du repo maven nécessaire (pour le cas où l'accès réseau est trop limitant)
    + Ajout STS en version 64 bits pour ceux qui ont déjà un jdk8 64 bits installé sur leur poste

- TP2
    + solution
        * Ajout exemple de définition d'un `CompositeItemProcessor` (cf. `tp2.process.context.xml`) pour remplacer le `TP2Processor` :
            1. filtrage via l'utilisation d'un `ValidatingItemProcessor`
            2. reste du traitement dans le `TP2ProcessorWithoutFilter`

- TP4
    + enonce
        * Ajout Launcher `TP4Lanceur_enonce_advanced.launch` pour activer les log de niveau DEBUG pour les catégories StepListener et SkipListener
    + solution
        * Ajout éléments liés au Bonus du TP4 visant à montrer la cinématique dans le cas où un skip est mis en oeuvre :
            - ajout d'un `TP4SkipListener` qui loggue les items "skip", en criticité DEBUG
            - ajout de ce listener dans la définition du job
            - modification du `TP4Step1Listener` pour logguer, en criticité DEBUG :
                + la début / fin de chaque chunk (beforeChunk, afterChunk, afterChunkError)
                + la lecture de chaque item (afterRead)
                + le traitement de chaque item (beforeProcess, onProcessError)
                + le nombre d'items à écrire (beforeWrite, afterWrite)
            - ajout du launcher `TP4Lanceur_solution_advanced.launch` pour :
                + activer les logs de niveau DEBUG du `TP4SkipListener` et du `TP4Step1Listener`
                + définir un skip-limit de 3
        * Ajout éléments liés au Bonus du TP4 visant à montrer la cinématique dans le cas où un skip est mis en oeuvre au niveau du Writer ou du Reader :
            - modification du `TP4Processor` pour configurer l'activation du filtrage ou non
            - ajout d'un `TP4Reader` qui utilise le `FlatFileItemReader` permettant de configurer l'activation du filtrage au niveau du read()
            - ajout d'un `TP4Writer` qui utilise le `JdbcBatchItemWriter` et qui filtre au niveau du write()

## [v1.0.3-20190703 ] - 2019-07-02

- TP6_annotation
    + solution
        * Remplacement du JobRepository de type Map par un JobRepositoty de type JDBC
        * Ajout défition d'un Bean, associé au profile `monitor`, permettant de lancer la console d'accès à la BD
        * Ajout de Launcher Eclipse pour lancer le Batch via `TP6Lanceur` avec activation du profile `monitor`
