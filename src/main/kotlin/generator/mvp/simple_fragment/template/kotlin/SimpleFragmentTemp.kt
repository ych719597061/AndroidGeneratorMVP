package generator.mvp.simple_fragment.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * created  at: 2023/1/30 13:12
 * Desc:    简单的Fragment模板
 */
fun simpleFragmentTemp(
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String,
    desc: String
) = """
    package $packageName

    import ${applicationPackage}.base.activity.BaseFragment
    import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${fragmentClass}Fragment : BaseFragment<Fragment${fragmentClass}Binding>() {
        override fun getBinding() = Fragment${fragmentClass}Binding.inflate(layoutInflater)

        override fun initView() {

        }
    }
""".trimIndent()