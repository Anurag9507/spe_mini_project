pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'anurag9507'
        IMAGE_NAME = 'scientific-calculator'
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

        stage('Docker Build & Push') {
            steps {
                sh "docker build -t anurag9507/scientific-calculator"
                sh "docker push anurag9507/scientific-calculator"
            }
        }
        
        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook -i inventory.ini deploy.yml'
            }
        }
    }
}
