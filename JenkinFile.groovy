/* groovylint-disable-next-line CompileStatic */
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the code... and Use Maven as the build automation tool'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running unit and integration tests... and Use JUnit or TestNG for tests'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Performing code analysis... and Use SonarQube for code analysis'
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing security scan... and  Use OWASP Dependency-Check'
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to staging... and eploy to AWS EC2'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running integration tests on staging... and Use Selenium for testing on staging'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to production...and Example: Deploy to AWS EC2'
            }
        }
    }

    post {
        always {
            emailext(
                to: 'samira.fallah69@gmail.com',
                subject: "Jenkins Pipeline: ${currentBuild.fullDisplayName}",
                body: "Pipeline completed with status: ${currentBuild.currentResult}",
                attachLog: true
            )
        }
    }
}
