package generator.mvp.simple_activity.template.kotlin

import generator.util.time

/**
 * @author  LiuJiang
 * Desc:    Mvp model 模板
 */
fun mvpInterfaceTemp (
        applicationPackage: String?,
        packageName: String,
        paramName: String,
        desc: String
) = """
package ${packageName};

import ${applicationPackage}.base.IMvpView;
/**
* created  at: ${time()}
* Desc:    $desc
*/
public interface I${paramName}View extends IMvpView {
}
""".trimIndent()