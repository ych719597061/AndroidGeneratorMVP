package generator.mvp.simple_fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import generator.util.defaultPackageNameParameter

/**
 * @author  LiuJiang
 * Desc:    简单的Fragment生成器
 */
val simpleFragmentGenerator
    get() = template {
        name = "Mvp Fragment"
        description = "生成MVP框架的Fragment和layout"
        minApi = MIN_API

        category = Category.Fragment
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        // Fragment
        val fragmentClass = stringParameter {
            name = "Fragment Name"
            default = "Xxx"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        // Layout
        val layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_xxx"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "fragment_${camelCaseToUnderlines(fragmentClass.value)}" }
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
            suggest = { "${fragmentClass.value}Model" }
            visible = { isMvp.value }
        }

        //view
        val viewName = stringParameter {
            name = "View Name"
            default = "XxxView"
            help = "请输入view的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${fragmentClass.value}View" }
            visible = { isMvp.value }
        }

        //presenter
        val presenterName = stringParameter {
            name = "Presenter Name"
            default = "XxxPresenter"
            help = "请输入presenter的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${fragmentClass.value}Presenter" }
            visible = { isMvp.value }
        }

        val packageName = defaultPackageNameParameter

        val language = enumParameter<Language> {
            name = "Source Language"
            help = "请选择语言"
            default = Language.Kotlin
        }

        widgets(
            TextFieldWidget(fragmentClass),
            TextFieldWidget(desc),
            TextFieldWidget(layoutName),
            CheckBoxWidget(isMvp),
            TextFieldWidget(modelName),
            TextFieldWidget(viewName),
            TextFieldWidget(presenterName),
            PackageNameWidget(packageName),
            EnumWidget(language)
        )

        recipe = {
            simpleFragmentRecipe(
                it as ModuleTemplateData,
                packageName.value,
                fragmentClass.value,
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

