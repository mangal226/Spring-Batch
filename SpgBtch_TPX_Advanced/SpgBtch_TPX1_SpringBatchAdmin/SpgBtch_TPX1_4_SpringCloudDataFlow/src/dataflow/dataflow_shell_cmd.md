# Register App
app import --uri file:///C:/formation-spring-batch/sources/training-springbatch/SpgBtch_TPX_Advanced/SpgBtch_TPX1_SpringBatchAdmin/SpgBtch_TPX1_4_SpringCloudDataFlow/src/dataflow/app_import.properties --force

# Define Task
task create --name "composed-example" --definition "task1:chunk-example 'FAILED'->task2:tasklet-example"

task create --name "task-example" --definition "task1:task-example --task-name=Task1"


# Launch Task
task launch composed-example --arguments "--increment-instance-enabled=true --spring.cloud.task.batch.failOnJobFailure=true --composed-task-arguments=msg=coucou"

task launch task-example --arguments "--msg=coucou" --properties="--app.task-example.tp1x.task-name=Hello"
