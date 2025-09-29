pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'anurag9507'
        IMAGE_NAME = 'scientific-calculator'
        IMAGE_TAG = '1.0'
        DOCKER_IMAGE = "${DOCKERHUB_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Anurag9507/spe_mini_project.git'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean package test'
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials',
                                                      usernameVariable: 'DOCKER_USER',
                                                      passwordVariable: 'DOCKER_PASS')]) {
                        
                        sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                        sh "docker build -t ${DOCKER_IMAGE} ."
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }
}