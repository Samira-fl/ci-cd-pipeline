/* groovylint-disable-next-line CompileStatic */
pipeline {
    agent any

    environment {
        EMAIL_RECIPIENT = 'samira.fallah69@gmail.com'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Stage 1: Build'
                echo 'Task: Compile and package the application code.'
                echo 'Tool: Maven'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Stage 2: Unit and Integration Tests'
                echo 'Task: Run unit tests to verify code functionality and integration tests.'
                echo 'Tool: JUnit or TestNG'
            }
            post {
                always {
                    emailext(
                        to: "${EMAIL_RECIPIENT}",
                        subject: "Unit and Integration Tests - ${currentBuild.fullDisplayName}",
                        body: """Unit and Integration Tests stage completed with status: ${currentBuild.currentResult}
                        |Details:
                        |Test Log:
                        |${JENKINS_HOME}/jobs/${JOB_NAME}/builds/${BUILD_NUMBER}/log
                        """,
                        attachLog: true
                    )
                }
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Stage 3: Code Analysis'
                echo 'Task: Analyze code quality and adherence to coding standards.'
                echo 'Tool: SonarQube'
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Stage 4: Security Scan'
                echo 'Task: Scan the code for vulnerabilities and security issues.'
                echo 'Tool: OWASP Dependency-Check'
            }
            post {
                always {
                    emailext(
                        to: "${EMAIL_RECIPIENT}",
                        subject: "Security Scan - ${currentBuild.fullDisplayName}",
                        body: """Security Scan stage completed with status: ${currentBuild.currentResult}
                        |Details:
                        |Security Scan Log:
                        |${JENKINS_HOME}/jobs/${JOB_NAME}/builds/${BUILD_NUMBER}/log
                        """,
                        attachLog: true
                    )
                }
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Stage 5: Deploy to Staging'
                echo 'Task: Deploy the application to a staging environment for further testing.'
                echo 'Tool: AWS EC2 or similar staging server'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Stage 6: Integration Tests on Staging'
                echo 'Task: Run integration tests in the staging environment to ensure the application functions.'
                echo 'Tool: Selenium'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Stage 7: Deploy to Production'
                echo 'Task: Deploy the application to the production environment for end-users.'
                echo 'Tool: AWS EC2 or similar production server'
            }
        }
    }
}
