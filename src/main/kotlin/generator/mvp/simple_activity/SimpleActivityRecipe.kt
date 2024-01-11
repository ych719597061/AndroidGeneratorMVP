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
//        modelName: String,
//        viewName: String,
//        presenterName: String,
        language: Language
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = language.extension

    //applicationPackage = "com.sum.framekt"
    //packageName = "com.sum.framekt.application.pages.test"
    //request manifestPackageName = ".application.pages.test.activity.BookActivity"
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            packageName = packageName + ".${ACTIVITY_PATH}",
//            isLauncher = false,
//            hasNoActionBar = false,
//            isNewModule = false,
//            isLibrary = false,
//            generateActivityTitle = false
//    )
    if (language == Language.Kotlin) {


    } else if (language == Language.Java) {
        if (isMvp) {
            //生成param 参数文件
            save(mvpParamTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("${activityClass}Param.${ktOrJavaExt}"))
            //生成interface文件
            save(mvpInterfaceTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("I${activityClass}View.${ktOrJavaExt}"))
            //生成presenter
            save(mvpPresenterTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("${activityClass}Presenter.${ktOrJavaExt}"))
            //生成model
            save(mvpModelTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("${activityClass}Model.${ktOrJavaExt}"))
            //生成view
            save(mvpViewTemp(projectData.applicationPackage, packageName, activityClass,layoutName, desc), srcOut.resolve("${activityClass}View.${ktOrJavaExt}"))
            //生成layout
            save(mvpLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        } else {
            //生成activity
            save(simpleActivityTemp(projectData.applicationPackage, packageName, activityClass, desc), srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
            //生成layout
            save(simpleLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        }
    }

}