package generator.mvp.refresh_fragment.template.kotlin

import generator.util.*
import generator.util.time

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshFragNoAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String,
    presenterName: String,
    viewName: String,
    desc: String,
) = """
    package ${packageName}.${FRAGMENT_PATH}

    import ${packageName}.${PRESENTER_PATH}.${presenterName}
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.base.activity.BaseMvpFragment
    import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${fragmentClass}Fragment: BaseMvpFragment<Fragment${fragmentClass}Binding, ${presenterName}>(), $viewName {
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getMultipleStatusView() = viewBinding.muView
        override fun getBinding() = Fragment${fragmentClass}Binding.inflate(layoutInflater)

        override fun initView() {
         
            viewBinding.smartRefreshLayout.setOnRefreshListener {
                it.setNoMoreData(false)

            }
            viewBinding.smartRefreshLayout.setOnLoadMoreListener {

            }
        }

        override fun notifyAdapter() {
    
        }

        override fun finishLoadMore() {
            viewBinding.smartRefreshLayout.finishLoadMore()
        }

        override fun finishRefresh() {
            viewBinding.smartRefreshLayout.finishRefresh()
        }

        override fun loadMoreComplete() {
            viewBinding.smartRefreshLayout.setNoMoreData(true)
        }

    }
""".trimIndent()