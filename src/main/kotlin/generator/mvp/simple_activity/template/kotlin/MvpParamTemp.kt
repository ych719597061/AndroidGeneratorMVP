package generator.mvp.simple_activity.template.kotlin

import generator.util.time

/**
 * @author  LiuJiang
 * Desc:    Mvp model 模板
 */
fun mvpParamTemp (
        applicationPackage: String?,
        packageName: String,
        paramName: String,
        desc: String
) = """
package ${packageName};

import ${applicationPackage}.base.BaseParam;

/**
* created  at: ${time()}
* Desc:    $desc
*/
public class ${paramName}Param extends BaseParam {

}

""".trimIndent()