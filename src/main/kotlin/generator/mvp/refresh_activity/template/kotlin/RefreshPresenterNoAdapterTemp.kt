package generator.mvp.refresh_activity.template.kotlin

import generator.util.*
import generator.util.time

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshPresenterNoAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    presenterName: String,
    modelName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.${PRESENTER_PATH}

    import android.content.Context
    import ${packageName}.${MODEL_PATH}.$modelName
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.base.mvp.BasePresenter

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${presenterName}(listener: ${viewName}, context: Context?) : BasePresenter<${modelName}, ${viewName}>(listener, context) {
        override fun createModel() = ${modelName}(context)

        var page = 1;


    }
""".trimIndent()