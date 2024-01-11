package generator.mvp.simple_activity.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:    mvp view 模板
 */
fun mvpViewTemp(
        applicationPackage: String?,
        packageName: String,
        viewName: String,
        layoutName: String,
        desc: String
) = """
package ${packageName};
import android.content.Context;
import android.view.Display;
import ${applicationPackage}.R;
import ${applicationPackage}.base.MvpPresentation;
    /**
     * created  at: ${time()}
     * Desc:    $desc
     */
public class ${viewName}View extends MvpPresentation<${viewName}Presenter> implements I${viewName}View {

    public ${viewName}View(Context context, Display display) {
        super(context, display);
    }

    @Override
    protected int layoutId() {
        return R.layout.${layoutName};
    }

    @Override
    protected void initView() {

    }

    @Override
    public void dobusiness() {

    }

    @Override
    public void onFail(String reason) {

    }

    @Override
    public ${viewName}Presenter createPresenter() {
        return new ${viewName}Presenter(this);
    }
}
""".trimIndent()