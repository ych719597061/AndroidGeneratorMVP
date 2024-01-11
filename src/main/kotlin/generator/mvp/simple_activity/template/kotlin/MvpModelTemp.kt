package generator.mvp.simple_activity.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:    Mvp model 模板
 */
fun mvpModelTemp (
    applicationPackage: String?,
    packageName: String,
    modelName: String,
    desc: String
) = """
 package ${packageName};
 import ${applicationPackage}.base.BasicModel;
 /**
  * created  at: ${time()}
  * Desc:    $desc
  */
public class ${modelName}Model extends BasicModel {
     
}
""".trimIndent()