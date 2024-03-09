pipeline {
    agent any

    stages {
        stage('Fetch From SCM') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/shubhamgheek/Jenkins-CI-CD']])
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean install'
                }
            }
        }

        stage('Deploy') {
            steps {
                deploy adapters: [tomcat9(credentialsId: 'tomcat-pwd', path: '', url: 'http://localhost:9090/')], contextPath: 'Jenkins-CI-CD', war: '**/*.war'
            }
        }

    }

    post {
        always {
            emailext attachLog: true, body: '''<html>
<body>
<p>Build Number : ${BUILD_NUMBER} </p>
<p>Build Status : ${BUILD_STATUS} </p>
<p>Check the <a href=${BUILD_URL}>console output</a></p>

</body>
</html>''', compressLog: true, mimeType: 'text/html', replyTo: 'shubhamgheek1@gmail.com', subject: 'Jenkins ${BUILD_NUMBER} :: ${BUILD_STATUS}', to: 'shubhamgheek1@gmail.com'
        }
    }
}
