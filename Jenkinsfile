pipeline {
    agent any
    environment {
            GIT_URL = "https://github.com/nikolaymal/rest"
            IMAGE_NAME = "payments"
            DBUSER = credentials('DBUSER')
            DBPASSWORD = credentials('DBPASSWORD')
        }
    stages {
        stage('GetFromGithub') {
            steps {
                git branch: 'main', url: GIT_URL
            }
        }
        stage('Ensure Maven is runnable') {
            steps {
                sh 'chmod a+x mvnw'
            }
        }

        stage('Maven build') {
            steps {
                sh './mvnw clean package -Dmaven.test.skip=true'
            }
        }

        stage('Docker image build') {
            steps {
                sh 'docker image build -t${IMAGE_NAME} --build-arg DBUSER=$DBUSER --build-arg DBPASSWORD=$DBPASSWORD .'
            }
        }

        stage('Update docker-compose to use the new version') {
            steps {
                sh 'sudo -u student /usr/local/bin/docker-compose -f /home/student/docker-compose.yaml up -d'
            }
        }

    }
}