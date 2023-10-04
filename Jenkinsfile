pipeline {
  agent any
  stages {
    stage('Checkout') {
      steps {
        // Checkout the Git repository
        checkout([$class: 'GitSCM', branches: [[name: '*/main']],
                  userRemoteConfigs: [[url: 'https://github.com/JohnJoser3/automate-jenkins.git']]])
      }
    }
    stage('Compile') {
      steps {
        sh 'pwd'
        sh 'javac -cp /Users/johnjose/Downloads/selenium-server-4.9.1.jar:/Users/johnjose/Downloads/testng-7.4.0.jar:. TestOnSafari.java'
      }
    }
    stage('Test') {
      steps {
          sh 'java -cp /Users/johnjose/Downloads/selenium-server-4.9.1.jar:/Users/johnjose/Downloads/testng-7.4.0.jar:. TestOnSafari.java'
        }
      }
    }
  }













