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
                sh './quickstart/gradlew test jacocoTestReport -p quickstart/'
            }
        }
    }
    post {
       always {
           junit 'quickstart/build/test-results/test/*.xml'
	   publishHTML (target: [
               allowMissing: false,
	       alwaysLinkToLastBuild: false,
	       keepAll: true,
	       reportDir: 'quickstart/build/reports/tests/test',
	       reportFiles: 'index.html',
	       reportName: "Test Summary"
	     ])
           publishHTML (target: [
               allowMissing: false,
	       alwaysLinkToLastBuild: false,
	       keepAll: true,
	       reportDir: 'quickstart/build/reports/jacoco',
	       reportFiles: 'index.html',
	       reportName: "Code Coverage"
             ])	       
       }
       success {
           archiveArtifacts artifacts: 'quickstart/build/libs/*.jar', fingerprint: true
       }      
    }
}
