$SPARK_HOME/bin/spark-submit \
--class r.ian.Main \
--master "spark://EPRUPETW09AA:7077"  \
--deploy-mode cluster \
build/libs/sparkApp-1.0-SNAPSHOT-all.jar

/usr/local/hadoop-3.2.2/spark-3.1.1-bin-without-hadoop/bin/spark-submit \
--class r.ian.Main \
--master "spark://EPRUPETW09AA:7077"  \
--conf spark.submit.deployMode=cluster \
/Users/Ian_Rakhmatullin/IdeaProjects/sparkAlchemy/sparkApp/build/libs/sparkApp-1.0-SNAPSHOT-all.jar
