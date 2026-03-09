pipeline {
    agent any

    stages {

        stage('Checkout from GitHub') {
            steps {
                echo "Cloning repository..."
                git branch: 'main',
                    url: 'https://github.com/kgurindagunta/DevopsAutomationSelenium.git'
            }
        }

        stage('Build & Run Tests') {
            steps {
                echo "Running Maven build and TestNG tests..."
                sh 'mvn test -Dheadless=yes'
            }
        }

        stage('Archive Extent Reports') {
            steps {
                echo "Archiving Extent Reports..."
                archiveArtifacts artifacts: 'TestReports/**',
                                 allowEmptyArchive: true
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: 'TestReports',
                    reportFiles: '**/index.html',
                    reportName: 'Extent Automation Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }

    post {
        always {
            echo "Build completed."
        }

        success {
            emailext(
                subject: "✅ Jenkins Build Successful - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2 style='color:green;'>Build Passed</h2>
                <p><b>Project:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p>
                  View the
                  <a href="${env.BUILD_URL}Extent%20Automation%20Report/">
                    Extent Automation Report
                  </a>
                </p>
                """,
                to: "gurindaguntakiran@gmail.com",
                mimeType: 'text/html'
            )
        }

        failure {
            emailext(
                subject: "❌ Jenkins Build Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                <h2 style='color:red;'>Build Failed</h2>
                <p><b>Project:</b> ${env.JOB_NAME}</p>
                <p><b>Build Number:</b> ${env.BUILD_NUMBER}</p>
                <p>
                  Check the
                  <a href="${env.BUILD_URL}console">
                    Jenkins Console Logs
                  </a>.
                </p>
                """,
                to: "gurindaguntakiran@gmail.com",
                mimeType: 'text/html'
            )
        }
    }
}