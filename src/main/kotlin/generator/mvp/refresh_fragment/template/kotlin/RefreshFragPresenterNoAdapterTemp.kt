package generator.mvp.refresh_fragment.template.kotlin

import generator.util.*
import generator.util.time

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshFragPresenterNoAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    presenterName: String,
    modelName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.${PRESENTER_PATH}

    import androidx.fragment.app.Fragment
    import ${packageName}.${MODEL_PATH}.$modelName
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.base.mvp.BasePresenter

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${presenterName}(listener: ${viewName}, fragment: Fragment?): BasePresenter<${modelName}, ${viewName}>(listener, fragment) {
        override fun createModel() = ${modelName}(fragment)

        var page = 1;


    }
""".trimIndent()