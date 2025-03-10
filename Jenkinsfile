pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "ibudaa/sportstracker:latest"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/BudaOP/SportTimeTracker.git'
            }
        }

        stage('Build with Maven') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t ${env.DOCKER_IMAGE} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub-credentials', url: '']) {
                    bat 'docker push ${env.DOCKER_IMAGE}'
                }
            }
        }
    }

    post {
        success {
            echo 'Build, Test, and Dockerization Successful!'
        }
        failure {
            echo 'Build failed. Check logs for details.'
        }
    }
}
