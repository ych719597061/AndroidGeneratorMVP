package generator.mvp.simple_activity.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    mvp presenter 模板
 */
fun mvpPresenterTemp(
    applicationPackage: String?,
    packageName: String,
    presenterName: String,
    modelName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.presenter

    import android.content.Context
    import ${packageName}.model.$modelName
    import ${packageName}.view.$viewName
    import ${applicationPackage}.base.mvp.BasePresenter

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    class ${presenterName}(listener: ${viewName}, context: Context?) : BasePresenter<${modelName}, ${viewName}>(listener, context) {
        override fun createModel() = ${modelName}(context)

        
    }
""".trimIndent()