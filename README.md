


<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#parametrization">Parametrization</a></li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Project for running spark jobs written as spring beans.

2 main modules:
* [SparkApp](sparkApp) should contain your logic for spark. If you want to run it locally, you can simply run it like a common spring boot app.
* [Launcher](launcher) module can send your uber jar to spark.


<p align="right">(<a href="#top">back to top</a>)</p>


### Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

* [Vanilla spark](https://spark.apache.org/)
* [Spring boot](https://spring.io/projects/spring-boot)
* [Scala](https://docs.scala-lang.org/)
* [Gradle](https://gradle.org/)

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

### Prerequisites


* I had spark 3.1.1 installed locally (not neccesary for local mode)
* Hadoop 3.2.2 installed locally (not neccesary for local mode)
  ```sh
  export HADOOP_HOME=/usr/local/hadoop-3.2.2
  export SPARK_HOME=/usr/local/hadoop-3.2.2/spark-3.1.1-bin-without-hadoop
  ```

### Installation


1. Clone the repo
   ```sh
   git clone https://github.com/MeltonSmith/sparkAlchemy.git
   ```

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- USAGE EXAMPLES -->
## Usage

This projects contains two modules: 


1. Write your spark job and implement run method. For example:
   ```java
    @Service
    class App extends Job{
      //some logic here
    }
   ```
2. You can run your job directly from IDE in case of local mode of spark by running 
   ```
   sparkApp/src/main/scala/r/ian/Main.scala
   ```   
   Pass jobBeanName:{className} args param for spring to run needed bean

3. Running with launcher:
   * launch spark in standalone mode somewhere (the only 1 nonLocal option for now)
   ```sh
   sh $SPARK_HOME/sbin/start-master.sh
   sh $SPARK_HOME/sbin/start-worker.sh spark://EPRUPETW09AA:7077
   ```  
   * build an uber jar of sparkApp module    
    ```sh
   gradlew sparkApp:shadowJar
   ```  

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- Parametrization -->
## Parametrization TODO

[SparkApp](sparkApp) has only 1 spring profile - default, which is dedicated to local mode running.

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a full list of proposed features (and known issues).

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Melton Smith - ravenglc1@gmail.com

Project Link: [https://github.com/MeltonSmith/sparkAlchemy](https://github.com/MeltonSmith/sparkAlchemy)

<p align="right">(<a href="#top">back to top</a>)</p>




