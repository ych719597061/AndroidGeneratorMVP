package generator.mvp.simple_fragment.template.kotlin

import generator.util.*

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
    package ${packageName}.${VIEW_PATH}

    import ${applicationPackage}.base.mvp.BaseView

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    interface $viewName: BaseView {
        
    }
""".trimIndent()