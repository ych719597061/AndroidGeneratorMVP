package generator.mvp.refresh_fragment.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshFragWithAdapterTemp (
    applicationPackage: String?,
    packageName: String,
    fragmentClass: String,
    presenterName: String,
    viewName: String,
    desc: String,
    beanName: String,
    adapterName: String,
) = """
    package ${packageName}.${FRAGMENT_PATH}

    import android.view.View
    import ${packageName}.adapter.${adapterName}
    import ${packageName}.${PRESENTER_PATH}.${presenterName}
    import ${packageName}.${VIEW_PATH}.$viewName
    import ${applicationPackage}.$APP_PATH.$BEAN_PATH.${beanName}
    import ${applicationPackage}.base.activity.BaseMvpFragment
    import ${applicationPackage}.databinding.Fragment${fragmentClass}Binding
    import com.sum.simpleadapter.interfaces.SimpleOnItemClickListener

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${fragmentClass}Fragment: BaseMvpFragment<Fragment${fragmentClass}Binding, ${presenterName}>(), $viewName {
        private var adapter: ${adapterName}? = null
        override fun createPresenter() = ${presenterName}(this, this)

        override fun getMultipleStatusView() = viewBinding.muView
        override fun getBinding() = Fragment${fragmentClass}Binding.inflate(layoutInflater)

        override fun initView() {
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