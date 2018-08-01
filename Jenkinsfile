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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		sh './quickstart/gradlew clean build -p quickstart/'
            }
        }
    }
    post {
       always {
           junit 'quickstart/build/test-results/test/*.xml'
       }
       success {
           archiveArtifacts artifacts: 'quickstart/build/libs/*.jar', fingerprint: true
       }
       publishHTML (target: [
           allowMissing: false,
           alwaysLinkToLastBuild: false,
           keepAll: true,
           reportDir: 'quickstart/build/reports/tests/test',
	   reportFiles: 'index.html',
	   reportName: "Tests Report"
       ])      
    }
}
