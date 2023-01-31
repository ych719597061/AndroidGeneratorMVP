package generator.mvp.simple_fragment.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    mvp view fragment 模板
 */
fun mvpFragView(
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
    interface $viewName: BaseView {
        
    }
""".trimIndent()