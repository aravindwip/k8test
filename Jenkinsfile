pipeline {
  agent any
  tools {
    jdk 'Java17'
    maven 'Maven-home'
  }
  stages {
    stage('Checkout Code') {
      steps {
        echo 'Pulling from Github'
        git branch: 'main', credentialsId: 'Git-Cred', url: 'https://github.com/aravindwip/k8test.git'
      }
    }
    stage('Test Code') {
      steps {
        echo 'JUNIT Test case execution started'
        bat 'mvn clean test'
        
      }
      post {
        always {
		  junit '**/target/surefire-reports/*.xml'
          echo 'Test Run is SUCCESSFUL!'
        }

      }
    }
    stage('Build Project') {
      steps {
        echo 'Building Java project'
        bat 'mvn clean package -DskipTests'
      }
    }
    stage('Build the Docker Image') {
      steps {
        echo 'Building Docker Image'
        bat 'docker build -t myindiaproj:1.0 .'
      }
    }
    stage('Push Docker Image to DockerHub') {
      steps {
        echo 'Pushing  Docker Image'
        withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'DOCKER_PASS')]) {
  	      bat '''
          echo %DOCKER_PASS% | docker login -u aravind1721 --password-stdin
          docker tag myjavaproj:1.0 aravind1721/myindiaproj:1.0
          docker push aravind1721/myindiaproj:1.0
          '''}
      }
    }
 }
  post {
    success {
      echo 'BUild and Run is SUCCESSFUL!'
    }
    failure {
      echo 'OOPS!!! Failure.'
    }
  }
}
