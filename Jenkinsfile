pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'dev', url: 'https://github.com/Sarthakcha/Student-CRUD-SpringBoot.git'
            }
        }

        stage('Build') {
            steps {
                dir('Student'){
                    sh 'mvn clean package'
                }
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'Student/target/*.jar', fingerprint: true
            }
        }
    }
}