pipeline {
    agent any

    environment {
        DOCKERHUB_REPO = "ibudaa/sportstracker"
        DOCKER_IMAGE_TAG = "latest"
        DOCKERHUB_CREDENTIALS_ID = "dockerhub-credentials"
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
                script {
                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                }
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                    }
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
