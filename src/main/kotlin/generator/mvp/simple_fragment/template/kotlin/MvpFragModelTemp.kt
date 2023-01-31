package generator.mvp.simple_fragment.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    Mvp model Fragment 模板
 */
fun mvpFragModel (
    applicationPackage: String?,
    packageName: String,
    modelName: String,
    desc: String
) = """
    package ${packageName}.model

    import androidx.fragment.app.Fragment
    import ${applicationPackage}.base.mvp.BaseModel

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    class ${modelName}(fragment: Fragment?): BaseModel(fragment) {

    }
""".trimIndent()