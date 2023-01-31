package generator.mvp.simple_fragment.template.kotlin

/**
 * @author  LiuJiang
 * Desc:    Mvp Layout模板
 */
fun mvpLayoutFragTemp () = """
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".application.pages.MainActivity">

        <com.sum.multiple.MultipleStatusView
            android:id="@+id/mu_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

        </com.sum.multiple.MultipleStatusView>
    </LinearLayout>  
""".trimIndent()