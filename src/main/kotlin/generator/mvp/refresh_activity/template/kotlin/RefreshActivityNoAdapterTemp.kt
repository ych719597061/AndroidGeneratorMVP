package generator.mvp.refresh_activity.template.kotlin

import generator.util.*
import generator.util.time

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshActivityNoAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    activityClass: String,
    presenterName: String,
    viewName: String,
    desc: String,
) = """
    package ${packageName}.${ACTIVITY_PATH}

    import android.os.Bundle
    import ${packageName}.${PRESENTER_PATH}.${presenterName}
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.base.activity.BaseMvpActivity
    import ${applicationPackage}.databinding.Activity${activityClass}Binding

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${activityClass}Activity : BaseMvpActivity<Activity${activityClass}Binding, ${presenterName}>(), $viewName {
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getMultipleStatusView() = viewBinding.muView
        override fun getBinding() = Activity${activityClass}Binding.inflate(layoutInflater)

        override fun initView(savedInstanceState: Bundle?) {
         
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