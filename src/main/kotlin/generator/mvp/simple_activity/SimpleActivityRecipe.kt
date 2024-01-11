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
        language: Language,
        isCreateDir: Boolean,
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

        var dirnam = "";
        var packageName2=packageName;

        if (isCreateDir) {
            dirnam = "" + activityClass + "/";
            packageName2=packageName+"."+activityClass;
        }

        var defPackgeName=projectData.applicationPackage;
        if (defPackgeName==null){
            defPackgeName=packageName;
        }

        if (true) {
            //生成param 参数文件
            save(mvpParamTemp(defPackgeName, packageName2, activityClass, desc), srcOut.resolve("${dirnam}${activityClass}Param.${ktOrJavaExt}"))
            //生成interface文件
            save(mvpInterfaceTemp(defPackgeName, packageName2, activityClass, desc), srcOut.resolve("${dirnam}I${activityClass}View.${ktOrJavaExt}"))
            //生成presenter
            save(mvpPresenterTemp(defPackgeName, packageName2, activityClass, desc), srcOut.resolve("${dirnam}${activityClass}Presenter.${ktOrJavaExt}"))
            //生成model
            save(mvpModelTemp(defPackgeName, packageName2, activityClass, desc), srcOut.resolve("${dirnam}${activityClass}Model.${ktOrJavaExt}"))
            //生成view
            save(mvpViewTemp(defPackgeName, packageName2, activityClass, layoutName, desc), srcOut.resolve("${dirnam}${activityClass}View.${ktOrJavaExt}"))
            //生成layout
            save(mvpLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        } else {
            //生成view
            save(mvpViewTemp(projectData.applicationPackage, packageName2, activityClass, layoutName, desc), srcOut.resolve("${dirnam}${activityClass}View.${ktOrJavaExt}"))
            //生成layout
            save(simpleLayoutTemp(desc), resOut.resolve("layout/${layoutName}.xml"))
        }
    }

}