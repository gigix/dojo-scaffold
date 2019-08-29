# 练功房脚手架

如果你恰好也用Java做练功房的练习，可以从这个脚手架开始入手。

准备步骤：

* `git clone https://github.com/gigix/dojo-scaffold.git my_kata && cd $_`
* `./gradlew clean build`
  * 如果你使用Windows，这一步应该是 `gradlew.bat clean build`

此时你应该看到成功的build：

```bash
$ ./gradlew clean build

BUILD SUCCESSFUL in 1s
4 actionable tasks: 4 executed
```

用Intellij IDEA或Eclipse或者你习惯的任何IDE（但是我强烈建议不要使用IDEA或Eclipse之外的其他IDE）导入工程，运行全部测试，你应该看到绿条。

从这里开始你的Dojo练习。
