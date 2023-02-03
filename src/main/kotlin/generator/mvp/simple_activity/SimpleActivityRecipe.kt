package generator.mvp.simple_activity

import com.android.tools.idea.wizard.template.Language
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import generator.mvp.simple_activity.template.kotlin.*
import generator.util.*

/**
 * @author  LiuJiang
 * Desc:    生成文件
 */
fun RecipeExecutor.simpleActivityRecipe(
    moduleData: ModuleTemplateData,
    packageName: String,
    activityClass: String,
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

    //applicationPackage = "com.sum.framekt"
    //packageName = "com.sum.framekt.application.pages.test"
    //request manifestPackageName = ".application.pages.test.activity.BookActivity"
    generateManifest(
        moduleData = moduleData,
        activityClass = "${activityClass}Activity",
        packageName = packageName.replace(projectData.applicationPackage!!, "") + ".${ACTIVITY_PATH}",
        isLauncher = false,
        hasNoActionBar = false,
        isNewModule = false,
        isLibrary = false,
        generateActivityTitle = false
    )
    if (language == Language.Kotlin) {
        if (isMvp) {
            //生成activity
            save(mvpActivityTemp(projectData.applicationPackage, packageName, activityClass, presenterName, viewName, desc), srcOut.resolve("${ACTIVITY_PATH}/${activityClass}Activity.${ktOrJavaExt}"))
            //生成presenter
            save(mvpPresenterTemp(projectData.applicationPackage, packageName, presenterName, modelName, viewName, desc), srcOut.resolve("${PRESENTER_PATH}/${presenterName}.${ktOrJavaExt}"))
            //生成model
            save(mvpModelTemp(projectData.applicationPackage, packageName, modelName, desc), srcOut.resolve("${MODEL_PATH}/${modelName}.${ktOrJavaExt}"))
            //生成view
            save(mvpViewTemp(projectData.applicationPackage, packageName, viewName, desc), srcOut.resolve("${VIEW_PATH}/${viewName}.${ktOrJavaExt}"))
            //生成layout
            save(mvpLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        } else {
            //生成activity
            save(simpleActivityTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("${ACTIVITY_PATH}/${activityClass}Activity.${ktOrJavaExt}"))
            //生成layout
            save(simpleLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        }

    } else if (language == Language.Java) {

    }

}