package generator.mvp.simple_activity.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    mvp view 模板
 */
fun mvpViewTemp(
    applicationPackage: String?,
    packageName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.view

    import ${applicationPackage}.base.mvp.BaseView

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    interface $viewName : BaseView {
    
    }
""".trimIndent()