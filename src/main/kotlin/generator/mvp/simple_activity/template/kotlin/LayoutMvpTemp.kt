package generator.mvp.simple_activity.template.kotlin

/**
 * @author  LiuJiang
 * Desc:    Mvp Layout模板
 */
fun mvpLayoutTemp(
    desc: String
) = """
  <?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/root"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
     >


</androidx.constraintlayout.widget.ConstraintLayout>
""".trimIndent()