pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
	        sh '''
		chmod +x quickstart/gradlew
		./quickstart/gradlew clean assemble -p quickstart/
		'''
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
	        sh './quickstart/gradlew clean test -p quickstart/'
		junit '**/target/*.xml'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....i'
            }
        }
    }
}
