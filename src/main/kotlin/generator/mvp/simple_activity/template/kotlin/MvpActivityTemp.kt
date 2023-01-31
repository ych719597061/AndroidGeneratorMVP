package generator.mvp.simple_activity.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    Mvp Activity模板
 */
fun mvpActivityTemp(
    applicationPackage: String?,
    packageName: String,
    activityClass: String,
    presenterName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.activity

    import android.os.Bundle
    import ${packageName}.presenter.$presenterName
    import ${packageName}.view.$viewName
    import ${applicationPackage}.base.activity.BaseMvpActivity
    import ${applicationPackage}.databinding.Activity${activityClass}Binding

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    class ${activityClass}Activity : BaseMvpActivity<Activity${activityClass}Binding, ${presenterName}>(), $viewName {
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getBinding() = Activity${activityClass}Binding.inflate(layoutInflater)

        override fun initView(savedInstanceState: Bundle?) {
            
        }


    }
""".trimIndent()