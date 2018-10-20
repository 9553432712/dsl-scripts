String basePath = 'example1'
String repo = 'sheehan/gradle-example'

folder(basePath) {
    description 'This example shows basic folder/job creation.'
}

job("$basePath/gradle-example-build") {
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
        scm 'H/5 * * * *'
	 githubPush()

    }
    steps {
        gradle 'assemble'
    }
}
