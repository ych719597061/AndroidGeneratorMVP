package generator.mvp.refresh_activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import generator.util.defaultPackageNameParameter

/**
 * @author  LiuJiang
 * created  at: 2023/2/3 10:43
 * Desc:    带刷新的Activity
 */
val refreshActivityGenerator
    get() = template {
        name = "Refresh Activity"
        description = "生成带下拉刷新的Activity和layout，可以选择是否生成Bean与Adapter。"
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

        //model
        val modelName = stringParameter {
            name = "Model Name"
            default = "XxxModel"
            help = "请输入model的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Model" }
        }

        //view
        val viewName = stringParameter {
            name = "View Name"
            default = "XxxView"
            help = "请输入view的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}View" }
        }

        //presenter
        val presenterName = stringParameter {
            name = "Presenter Name"
            default = "XxxPresenter"
            help = "请输入presenter的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Presenter" }
        }

        //是否生成adapter
        val isGenerateAdapter = booleanParameter {
            name = "Is Generate Adapter"
            help = "是否生成Adapter与Bean"
            default = false
        }

        // adapter
        val adapterName = stringParameter {
            name = "Adapter Name"
            default = "XxxAdapter"
            help = "请输入adapter的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Adapter" }
            visible = { isGenerateAdapter.value }
        }

        // layout
        val itemLayoutName = stringParameter {
            name = "Item Layout Name"
            default = "item_xxx"
            help = "请输入Item布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "item_${camelCaseToUnderlines(activityClass.value)}" }
            visible = { isGenerateAdapter.value }
        }

        // bean
        val beanName = stringParameter {
            name = "Bean Name"
            default = "XxxBean"
            help = "请输入Bean的名字"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}Bean" }
            visible = { isGenerateAdapter.value }
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
            TextFieldWidget(modelName),
            TextFieldWidget(viewName),
            TextFieldWidget(presenterName),
            CheckBoxWidget(isGenerateAdapter),
            TextFieldWidget(adapterName),
            TextFieldWidget(beanName),
            TextFieldWidget(itemLayoutName),
            PackageNameWidget(packageName),
            EnumWidget(language),
        )

        recipe = {
            refreshActivityRecipe(
                it as ModuleTemplateData,
                packageName.value,
                activityClass.value,
                layoutName.value,
                desc.value,
                modelName.value,
                viewName.value,
                presenterName.value,
                isGenerateAdapter.value,
                adapterName.value,
                itemLayoutName.value,
                beanName.value,
                Language.Kotlin,
            )
        }
    }