
1.times{
	job('voting-deploy-aws'+it) {
	//ogRotator(int daysToKeep, int numToKeep)
    logRotator {
        numToKeep(15)
    }
    jdk('Java 8')
    scm {
      git {
           remote {
               url('https://github.com/9553432712/dsl-scripts.git')
               credentials('git-credential')
           }
           branch("master")
      }
  }
    triggers {
        githubPush()
    }
    steps {
        //gradle('clean build')
    }
    publishers {
        archiveArtifacts('job-dsl-plugin/build/libs/job-dsl.hpi')
    }
 }
}
