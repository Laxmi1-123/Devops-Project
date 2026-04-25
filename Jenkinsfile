pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'delete-module', 
                    url: 'https://github.com/Laxmi1-123/Devops-Project.git'
            }
        }

        stage('Build & Test') {
            steps {
                script {
                    def mvnHome = tool 'Maven-3.9'
                    bat "${mvnHome}\\bin\\mvn clean test"
                }
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
        }
    }
}