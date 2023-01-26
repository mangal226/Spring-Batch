REM +------------------------------+
REM + Spring Cloud Data Flow Shell +
REM +------------------------------+

SET DATAFLOW_SHELL_JAR=C:\formation-spring-batch\m2\repository\org\springframework\cloud\spring-cloud-dataflow-shell\1.7.3.RELEASE\spring-cloud-dataflow-shell-1.7.3.RELEASE.jar

REM Default DataFlow URI if option not set : http://localhost:9393
SET DATAFLOW_URI_OPTION=--dataflow.uri=http://localhost:9393

SET DATAFLOW_OPTIONS=%DATAFLOW_URI_OPTION%

java -jar %DATAFLOW_SHELL_JAR% %DATAFLOW_OPTIONS%
