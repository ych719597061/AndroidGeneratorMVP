package generator.mvp.simple_fragment.template.kotlin

import generator.util.DateUtils

/**
 * @author  LiuJiang
 * Desc:    Mvp Fragment 模板
 */
fun mvpFragmentTemp(
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String,
    presenterName: String,
    viewName: String,
    desc: String
) = """
    package ${packageName}.fragment

    import ${packageName}.presenter.$presenterName
    import ${packageName}.view.$viewName
    import ${applicationPackage}.base.activity.BaseMvpFragment
    import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding

    /**
     * @author  LiuJiang
     * created  at: ${DateUtils.time()}
     * Desc:    $desc
     */
    class ${fragmentClass}Fragment: BaseMvpFragment<Fragment${fragmentClass}Binding, ${presenterName}>(), $viewName {
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getBinding() = Fragment${fragmentClass}Binding.inflate(layoutInflater)

        override fun initView() {

        }
        
    }
""".trimIndent()