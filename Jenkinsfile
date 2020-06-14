node {
    
   stage('git clone') { // for display purposes
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'github-accout-password', url: 'https://github.com/amyli0808/Emart.git']]])
   }
   
   stage('Build') {
       
        echo 'Building'
        sh 'mvn clean install -f stockmarket-master/cloud-eureka-service/pom.xml -Dmaven.test.skip=true'
       // sh 'mvn clean install -f stockmarket-master/cloud-eureka-service/pom.xml -Dmaven.test.skip=true -X'
        
   }
   
   stage('Deploy') {
       
       echo 'Deploying'
       sh 'docker build -t eurekaservice:1.0 -f Dockerfile .'
       sh 'docker run -d -p 8761:8761 eurekaservice:1.0'
       ssh 'echo hello'
        
       
   }
   
   
}
    