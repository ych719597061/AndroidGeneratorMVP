package generator.mvp.refresh_activity.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshViewTemp (
    applicationPackage: String?,
    packageName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.${VIEW_PATH}

    import ${applicationPackage}.base.mvp.BaseRefreshView

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    interface $viewName : BaseRefreshView {

    }
""".trimIndent()