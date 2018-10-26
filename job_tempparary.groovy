
job('temapary') {


  logRotator {
        numToKeep(5)
    }


  scm {
      git {
           remote {
               url('https://github.com/9553432712/inventory-docker.git')
           }
           branch("master")
      }
  }

  triggers {
      scm('* * * * *')
  }

  steps {
        shell('mvn clean install ')
  }
}

