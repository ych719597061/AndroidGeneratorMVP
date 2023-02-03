package generator.mvp.simple_fragment

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import generator.mvp.simple_fragment.template.kotlin.mvpFragPresenterTemp
import generator.mvp.simple_fragment.template.kotlin.*
import generator.util.*


/**
 * @author  LiuJiang
 * Desc:    生成文件
 */
fun RecipeExecutor.simpleFragmentRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    fragmentClass: String,
    layoutName: String,
    desc: String,
    isMvp: Boolean,
    modelName: String,
    viewName: String,
    presenterName: String,
    language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension
    if (language == Language.Kotlin) {
        if (isMvp) {
            //生成Fragment
            save(mvpFragmentTemp(projectData.applicationPackage, packageName, fragmentClass, presenterName, viewName, desc), srcOut.resolve("${FRAGMENT_PATH}/${fragmentClass}Fragment.${ktOrJavaExt}"))
            //生成presenter
            save(mvpFragPresenterTemp(projectData.applicationPackage, packageName, presenterName, modelName, viewName, desc), srcOut.resolve("${PRESENTER_PATH}/${presenterName}.${ktOrJavaExt}"))
            //生成model
            save(mvpFragModel(projectData.applicationPackage, packageName, modelName, desc), srcOut.resolve("${MODEL_PATH}/${modelName}.${ktOrJavaExt}"))
            //生成view
            save(mvpFragView(projectData.applicationPackage, packageName, viewName, desc), srcOut.resolve("${VIEW_PATH}/${viewName}.${ktOrJavaExt}"))
            //生成layout
            save(mvpLayoutFragTemp(), resOut.resolve("layout/${layoutName}.xml"))
        } else {
            //生成Fragment
            save(simpleFragmentTemp(projectData.applicationPackage, packageName, fragmentClass, desc), srcOut.resolve("${FRAGMENT_PATH}/${fragmentClass}Fragment.${ktOrJavaExt}"))
            //生成layout
            save(simpleLayoutFragTemp(), resOut.resolve("layout/${layoutName}.xml"))
        }
    } else if (language == Language.Java) {

    }

}