cd  /kafka
java -cp "libs/*" kafka.tools.StorageTool random-uuid
java -cp "libs/*" kafka.tools.StorageTool format -t "PASTE_UUID_HERE" -c config/kraft/server.properties
java -cp "libs/*" kafka.Kafka config/kraft/server.properties