$SPARK_HOME/bin/spark-submit \
--class r.ian.Main \
--master "spark://EPRUPETW09AA:7077"  \
--deploy-mode cluster \
build/libs/sparkAlchemy-1.0-SNAPSHOT-all.jar