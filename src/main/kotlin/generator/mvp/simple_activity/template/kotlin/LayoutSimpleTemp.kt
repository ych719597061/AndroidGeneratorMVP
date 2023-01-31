package generator.mvp.simple_activity.template.kotlin

/**
 * @author  LiuJiang
 * Desc:    简单的Activity layout模板
 */
fun simpleLayoutTemp(
    desc: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <com.sum.titlebar.TitleBar
        android:id="@+id/title_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tb_title="$desc" />

</LinearLayout>
"""