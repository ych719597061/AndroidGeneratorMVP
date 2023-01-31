package generator.mvp.simple_activity.template.kotlin

import generator.util.DateUtils


/**
 * @author  LiuJiang
 * Desc:    简单的Activity模板
 */
fun simpleActivityTemp(
    applicationPackage: String?,
    packageName: String,
    activityClass: String,
    desc: String
) = """
package ${packageName}.activity

import android.os.Bundle
import ${applicationPackage}.base.activity.BaseActivity
import ${applicationPackage}.databinding.Activity${activityClass}Binding

/**
 * @author  LiuJiang
 * created  at: ${DateUtils.time()}
 * Desc:    $desc
 */
class ${activityClass}Activity: BaseActivity<Activity${activityClass}Binding>() {
    override fun getBinding() = Activity${activityClass}Binding.inflate(layoutInflater)

    override fun initView(savedInstanceState: Bundle?) {
    
    }
}
"""