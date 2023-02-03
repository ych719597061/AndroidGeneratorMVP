package generator.mvp.refresh_fragment

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import generator.mvp.refresh_activity.template.kotlin.*
import generator.mvp.refresh_fragment.template.kotlin.*
import generator.util.*

/**
 * @author  LiuJiang
 * Desc:
 */
fun RecipeExecutor.refreshFragmentRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    fragmentClass: String,
    layoutName: String,
    desc: String,
    modelName: String,
    viewName: String,
    presenterName: String,
    isGenerateAdapter: Boolean,
    adapterName: String,
    itemLayoutName: String,
    beanName: String,
    language: Language
) {
    val (projectData, srcOut, resOut, _, _, _, _, rootOut) = moduleData
    val ktOrJavaExt = language.extension
    if (language == Language.Kotlin) {
        //是否生成adapter/bean
        if (isGenerateAdapter) {
            //生成Fragment
            save(refreshFragWithAdapterTemp(projectData.applicationPackage, packageName, fragmentClass, presenterName, viewName, desc, beanName, adapterName), srcOut.resolve("${FRAGMENT_PATH}/${fragmentClass}Fragment.${ktOrJavaExt}"))
            //生成presenter
            save(refreshFragPresenterWithAdapterTemp(projectData.applicationPackage, packageName, presenterName, modelName, viewName, desc, beanName), srcOut.resolve("${PRESENTER_PATH}/${presenterName}.${ktOrJavaExt}"))
            //生成bean
            val path = "/src/main/java/${projectData.applicationPackage!!.replace(".", "/")}/${APP_PATH}/$BEAN_PATH"
            save(beanTemp(projectData.applicationPackage, beanName, desc), rootOut.resolve("${path}/${beanName}.${ktOrJavaExt}"))
            //生成adapter
            save(adapterTemp(projectData.applicationPackage, packageName, beanName, adapterName, underlineToHump(itemLayoutName), desc), srcOut.resolve("adapter/${adapterName}.${ktOrJavaExt}"))
            //生成itemLayout
            save(itemLayoutTemp(), resOut.resolve("layout/${itemLayoutName}.xml"))
        } else {
            //生成Activity
            save(refreshFragNoAdapterTemp(projectData.applicationPackage, packageName, fragmentClass, presenterName, viewName, desc), srcOut.resolve("${FRAGMENT_PATH}/${fragmentClass}Fragment.${ktOrJavaExt}"))
            //生成presenter
            save(refreshFragPresenterNoAdapterTemp(projectData.applicationPackage, packageName, presenterName, modelName, viewName, desc), srcOut.resolve("${PRESENTER_PATH}/${presenterName}.${ktOrJavaExt}"))
        }
        //生成model
        save(refreshFragModelTemp(projectData.applicationPackage, packageName, modelName, desc), srcOut.resolve("${MODEL_PATH}/${modelName}.${ktOrJavaExt}"))
        //生成view
        save(refreshViewTemp(projectData.applicationPackage, packageName, viewName, desc), srcOut.resolve("${VIEW_PATH}/${viewName}.${ktOrJavaExt}"))
        //生成layout
        save(refreshFragLayoutTemp(), resOut.resolve("layout/${layoutName}.xml"))
    }
}