cd  /kafka
java -cp "libs/*" kafka.tools.StorageTool random-uuid
java -cp "libs/*" kafka.tools.StorageTool format -t "PASTE_UUID_HERE" -c config/kraft/server.properties
java -cp "libs/*" kafka.Kafka config/kraft/server.properties


java -cp "libs/*" kafka.Kafka config\kraft\server.properties windo




# 1. Go to Kafka root folder
cd C:\Users\leonids.gurockins\Desktop\Mercury\kafkaBase\kafkaTest\kafkaLocal\kafka

# 2. Delete old KRaft metadata/data
Remove-Item -Recurse -Force "C:\tmp\kraft-combined-logs" -ErrorAction SilentlyContinue

# 3. Generate a new cluster ID
java -cp "libs/*" kafka.tools.StorageTool random-uuid

# 4. Copy that generated ID into a variable
$KAFKA_CLUSTER_ID = "YOUR_GENERATED_ID"

# Example:
# $KAFKA_CLUSTER_ID = "JBJ7P3hNRIyY0z8MdYKbsA"

# 5. Format KRaft storage with the new ID
java -cp "libs/*" kafka.tools.StorageTool format -t $KAFKA_CLUSTER_ID -c config\kraft\server.properties

# 6. Start Kafka
java -cp "libs/*" kafka.Kafka config\kraft\server.properties



test
netstat -ano | findstr :9092