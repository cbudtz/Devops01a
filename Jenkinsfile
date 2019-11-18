pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

    stage('Deploy') {
      steps {
        sh 'java -jar target/Heroku01.jar'
      }
    }

  }
  environment {
    HEROKUBUILD = 'true'
  }
}