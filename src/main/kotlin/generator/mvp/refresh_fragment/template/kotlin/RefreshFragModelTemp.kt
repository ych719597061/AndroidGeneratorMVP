package generator.mvp.refresh_fragment.template.kotlin

import generator.util.MODEL_PATH
import generator.util.time


/**
 * @author  LiuJiang
 * Desc:    Mvp model Fragment 模板
 */
fun refreshFragModelTemp (
    applicationPackage: String?,
    packageName: String,
    modelName: String,
    desc: String
) = """
    package ${packageName}.${MODEL_PATH}

    import androidx.fragment.app.Fragment
    import ${applicationPackage}.base.mvp.BaseModel

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${modelName}(fragment: Fragment?): BaseModel(fragment) {

    }
""".trimIndent()