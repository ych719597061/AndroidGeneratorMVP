package generator.mvp.refresh_activity.template.kotlin

import generator.util.APP_PATH
import generator.util.BEAN_PATH
import generator.util.time


/**
 * @author  LiuJiang
 * Desc:
 */
fun adapterTemp (
    applicationPackage: String?,
    packageName: String,
    beanName: String,
    adapterName: String,
    itemLayoutName: String,
    desc: String,
) = """
    package ${packageName}.adapter

    import android.content.Context
    import android.view.LayoutInflater
    import android.view.ViewGroup
    import ${applicationPackage}.${APP_PATH}.${BEAN_PATH}.$beanName
    import ${applicationPackage}.databinding.${itemLayoutName}Binding
    import com.sum.simpleadapter.BaseAdapter
    import com.sum.simpleadapter.base.ViewHolder

    /**
     * @author  LiuJiang
     * created  at: ${time()}
     * Desc:    $desc
     */
    class ${adapterName}(val context: Context?, val data: MutableList<${beanName}>?) : BaseAdapter<${itemLayoutName}Binding, ${beanName}>(context, data) {
        override fun getViewBinding(viewType: Int, layoutInflater: LayoutInflater?, parent: ViewGroup?): ${itemLayoutName}Binding {
            return ${itemLayoutName}Binding.inflate(layoutInflater!!, parent, false)
        }

        override fun onBind(context: Context?, holder: ViewHolder<${itemLayoutName}Binding>?, item: ${beanName}?, position: Int) {
            item?.let {
                holder?.binding?.run {
                    
                }
            }

        }
    }
""".trimIndent()