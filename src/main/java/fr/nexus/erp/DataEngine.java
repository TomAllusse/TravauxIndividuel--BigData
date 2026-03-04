package fr.nexus.erp;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

public class DataEngine {
    public static void runPipeline(){
        /* set Variable Globale Java (Windows Only) */
        System.setProperty("hadoop.home.dir", "C:\\Hadoop\\hadoop-3.3.6");
        System.load("C:\\Hadoop\\hadoop-3.3.6\\bin\\hadoop.dll");

        /* Init de Spark */
        SparkSession spark = SparkSession.builder()
                .appName("Test Spark")
                .config("spark.master", "local[*]")
                .getOrCreate();

        /* Connexion a mySQL */
        String url = "jdbc:mysql://localhost:3306/nexus_erp";
        String user = "root";
        String password = "";

        Properties connectionProp = new Properties();
        connectionProp.put("user", user);
        connectionProp.put("password", password);
        connectionProp.put("driver", "com.mysql.cj.jdbc.Driver");

        System.out.println("============================================");
        System.out.println("CONNEXION DB MYSQL");
        System.out.println("============================================");

        Dataset<Row> dfMySQL = spark.read().jdbc(url, "server_logs", connectionProp);

        /* tout affiché */
        dfMySQL.printSchema();
        dfMySQL.show();

        System.out.println("============================================");
        System.out.println("ETAPE MAP");
        System.out.println("============================================");

        Dataset<Row> dfMap = dfMySQL
                .select("id","name", "region", "statut")
                .filter(dfMySQL.col("region").isNotNull());

        dfMap.show(5);

        System.out.println("============================================");
        System.out.println("ETAPE REDUCE ET SHUFFLE");
        System.out.println("============================================");

        Dataset<Row> dfReduce = dfMap.orderBy("region", "name");

        dfReduce.show(5);

        /* Exporté la donnée */
        System.out.println("============================================");
        System.out.println("EXPORTATION DE LA DATA");
        System.out.println("============================================");

        String cheminExportJSON = "archives_logs_serveurs";
        dfReduce.write()
                .mode(SaveMode.Overwrite)
                .partitionBy("region")
                .json(cheminExportJSON);

        System.out.println("Export réaliser : " + cheminExportJSON);

        /* Vidé la variable spark */
        spark.stop();
    }
}
