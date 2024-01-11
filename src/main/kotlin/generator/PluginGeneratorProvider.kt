package generator

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import generator.mvp.refresh_activity.refreshActivityGenerator
import generator.mvp.refresh_fragment.refreshFragmentGenerator
import generator.mvp.simple_activity.simpleActivityGenerator
import generator.mvp.simple_fragment.simpleFragmentGenerator

/**
 * @author  LiuJiang
 * Desc:    GeneratorProvider
 */
class PluginGeneratorProvider : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        //Simple Activity
        simpleActivityGenerator,
//        //Simple Fragment
//        simpleFragmentGenerator,
//        //Refresh Activity
//        refreshActivityGenerator,
//        //Refresh Fragment
//        refreshFragmentGenerator,
    )
}