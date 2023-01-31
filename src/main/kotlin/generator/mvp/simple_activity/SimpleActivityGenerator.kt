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
        name = "Mvp Activity"
        description = "生成MVP框架的Activity和layout"
        minApi = MIN_API

        category = Category.Activity
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        // Activity
        val activityClass = stringParameter {
            name = "Activity Name"
            default = "Xxx"
            help = "只输入名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }

        // layout
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_xxx"
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

        //model
        val modelName = stringParameter {
            name = "Model Name"
            default = "XxxModel"
            help = "请输入model的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Model" }
            visible = { isMvp.value }
        }

        //view
        val viewName = stringParameter {
            name = "View Name"
            default = "XxxView"
            help = "请输入view的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}View" }
            visible = { isMvp.value }
        }

        //presenter
        val presenterName = stringParameter {
            name = "Presenter Name"
            default = "XxxPresenter"
            help = "请输入presenter的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Presenter" }
            visible = { isMvp.value }
        }

        val packageName = defaultPackageNameParameter

        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }

        widgets(
            TextFieldWidget(activityClass),
            TextFieldWidget(desc),
            TextFieldWidget(layoutName),
            CheckBoxWidget(isMvp),
            TextFieldWidget(modelName),
            TextFieldWidget(viewName),
            TextFieldWidget(presenterName),
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
                modelName.value,
                viewName.value,
                presenterName.value,
                language.value,
            )
        }
    }

