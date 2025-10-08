pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'anurag9507'
        IMAGE_NAME = 'scientific-calculator'
        IMAGE_TAG = 'latest'
        DOCKER_IMAGE = "${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
    }

    stages {
        stage('Build & Test') {
            steps {
                echo 'Application build and unit tests with Maven...'
                sh 'mvn clean package test'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker image: ${env.DOCKER_IMAGE}..."
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }

        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    echo 'Docker Hub login and image push...'
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds',
                                                     usernameVariable: 'DOCKER_USER',
                                                     passwordVariable: 'DOCKER_PASS')]) {
                        
                        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                echo 'Deployment using Ansible playbook...'
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }
    post {
        success {
            mail to: 'anurag.ramaswamy.201344@gmail.com',
            subject: "Build #${env.BUILD_NUMBER} SUCCESS",
            body: """\
            BUILD SUCCESS!
            Pipeline: ${env.JOB_NAME}
            Build Number: ${env.BUILD_NUMBER}
            URL: ${env.BUILD_URL}
            """
        }
        failure {
            mail to: 'anurag.ramaswamy.201344@gmail.com',
            subject: "Build #${env.BUILD_NUMBER} FAILURE",
            body: """\
            BUILD FAILURE!
            Pipeline: ${env.JOB_NAME}
            Build Number: ${env.BUILD_NUMBER}
            URL: ${env.BUILD_URL}
            """
        }
    }
}