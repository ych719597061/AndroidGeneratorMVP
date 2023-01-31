package generator.mvp.simple_activity.template.kotlin

import generator.util.DateUtils

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
    package ${packageName}.model

    import android.content.Context
    import ${applicationPackage}.base.mvp.BaseModel

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    class ${modelName}(context: Context?) : BaseModel(context) {

    }
""".trimIndent()