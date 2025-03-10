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
                sh 'mvn clean package'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Code Coverage') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'dockerhub-credentials', url: '']) {
                    sh 'docker push $DOCKER_IMAGE'
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
