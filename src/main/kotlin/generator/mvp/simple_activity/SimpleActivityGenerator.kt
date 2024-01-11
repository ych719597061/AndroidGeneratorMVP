package generator.mvp.simple_activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import generator.util.defaultPackageNameParameter

/**
 * @author  LiuJiang
 * Desc:    简单的Activity生成器
 */
val simpleActivityGenerator
    get() = template {
        name = "LT Mvp Presentation生成器"
        description = "生成MVP框架的Presentation和layout"
        minApi = MIN_API
        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)
        // View
        val activityClass = stringParameter {
            name = "View Name"
            default = "Simple"
            help = "只输入名字，不要包含View"
            constraints = listOf(Constraint.NONEMPTY)
        }

        // layout
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_simple"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "activity_${camelCaseToUnderlines(activityClass.value)}" }
        }

        //desc
        val desc = stringParameter {
            name = "description"
            default = ""
            help = "请输入注释"
            constraints = listOf(Constraint.STRING)
        }

        //是否生成mvp
        val isMvp = booleanParameter {
            name = "Is MVP"
            help = "是否生成Model，View，Presenter"
            default = true
        }


        val isCreateDir = booleanParameter {
            name = "生成文件夹"
            help = "是否创建独立文件夹"
            default = false
        }

//        //model
//        val modelName = stringParameter {
//            name = "Model Name"
//            default = "SimpleModel"
//            help = "请输入model的名字"
//            constraints = listOf(Constraint.NONEMPTY)
//            suggest = { "${activityClass.value}Model" }
//            visible = { isMvp.value }
//        }
//
//        //view
//        val viewName = stringParameter {
//            name = "View Name"
//            default = "SimpleView"
//            help = "请输入view的名字"
//            constraints = listOf(Constraint.NONEMPTY)
//            suggest = { "${activityClass.value}View" }
//            visible = { isMvp.value }
//        }
//
//        //presenter
//        val presenterName = stringParameter {
//            name = "Presenter Name"
//            default = "SimplePresenter"
//            help = "请输入Presenter的名字"
//            constraints = listOf(Constraint.NONEMPTY)
//            suggest = { "${activityClass.value}Presenter" }
//            visible = { isMvp.value }
//        }
        val packageName = defaultPackageNameParameter
        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Java
        }
        widgets(
                TextFieldWidget(activityClass),
                TextFieldWidget(desc),
                TextFieldWidget(layoutName),
//                CheckBoxWidget(isMvp),
                CheckBoxWidget(isCreateDir),
//                TextFieldWidget(modelName),
//                TextFieldWidget(viewName),
//                TextFieldWidget(presenterName),
                PackageNameWidget(packageName),
                EnumWidget(language),
        )

        recipe = {
            simpleActivityRecipe(
                    it as ModuleTemplateData,
                    packageName.value,
                    activityClass.value,
                    layoutName.value,
                    desc.value,
                    isMvp.value,
                    language.value,
                    isCreateDir.value
            )
        }
    }

