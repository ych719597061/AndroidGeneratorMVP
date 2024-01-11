package generator.mvp.simple_activity.template.kotlin

import generator.util.*

/**
 * @author  LiuJiang
 * Desc:    mvp presenter 模板
 */
fun mvpPresenterTemp(
    applicationPackage: String?,
    packageName: String,
    viewName: String,
    desc: String
) = """
  package ${packageName};

  import ${applicationPackage}.base.BasicPresenter;
  
  public class ${viewName}Presenter extends BasicPresenter<I${viewName}View,${viewName}Model> {

      public ${viewName}Presenter(I${viewName}View view) {
          super(view);
      }

      @Override
      protected ${viewName}Model createModel() {
          return new ${viewName}Model();
      }
  }

""".trimIndent()