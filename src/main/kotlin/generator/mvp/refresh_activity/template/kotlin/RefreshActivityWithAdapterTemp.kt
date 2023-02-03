package generator.mvp.refresh_activity.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshActivityWithAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    activityClass: String,
    presenterName: String,
    viewName: String,
    desc: String,
    beanName: String,
    adapterName: String,
) = """
    package ${packageName}.${ACTIVITY_PATH}

    import android.os.Bundle
    import android.view.View
    import ${packageName}.adapter.${adapterName}
    import ${packageName}.${PRESENTER_PATH}.${presenterName}
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.$APP_PATH.$BEAN_PATH.${beanName}
    import ${applicationPackage}.base.activity.BaseMvpActivity
    import ${applicationPackage}.databinding.Activity${activityClass}Binding
    import com.sum.simpleadapter.interfaces.SimpleOnItemClickListener

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${activityClass}Activity : BaseMvpActivity<Activity${activityClass}Binding, ${presenterName}>(), $viewName {
        private var adapter: ${adapterName}? = null
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getMultipleStatusView() = viewBinding.muView
        override fun getBinding() = Activity${activityClass}Binding.inflate(layoutInflater)

        override fun initView(savedInstanceState: Bundle?) {
            adapter = ${adapterName}(context, presenter?.data)
            viewBinding.recyclerView.adapter = adapter
            adapter?.setOnItemClickListener(object : SimpleOnItemClickListener<${beanName}>() {
                override fun onItemClick(view: View?, item: ${beanName}?, position: Int) {

                }

            })

            viewBinding.smartRefreshLayout.setOnRefreshListener {
                it.setNoMoreData(false)

            }
            viewBinding.smartRefreshLayout.setOnLoadMoreListener {

            }
        }

        override fun notifyAdapter() {
            adapter?.notifyDataSetChanged()
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