object prog1 {
  import org.apache.spark.sql.SparkSession
  def main(args: Array[String]): Unit = {


    val spark = SparkSession
      .builder().master("local")
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()

    // For implicit conversions like converting RDDs to DataFrames
    import spark.implicits._

    val df = spark.read.json("people.json")

    // Displays the content of the DataFrame to stdout
    df.show()
  }
}
