package generator.util

import com.android.tools.idea.wizard.template.Constraint
import com.android.tools.idea.wizard.template.stringParameter

/**
 * @author  LiuJiang
 * Desc:    获取包名
 */
val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.github.summersrest"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }
