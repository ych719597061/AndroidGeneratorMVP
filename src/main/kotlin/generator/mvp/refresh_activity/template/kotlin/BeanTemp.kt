package generator.mvp.refresh_activity.template.kotlin

import generator.util.APP_PATH
import generator.util.BEAN_PATH
import generator.util.time

/**
 * @author  LiuJiang
 * Desc:
 */
fun beanTemp (
    applicationPackage: String?,
    beanName: String,
    desc: String
) = """
    package ${applicationPackage}.$APP_PATH.$BEAN_PATH

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    data class ${beanName}()
""".trimIndent()