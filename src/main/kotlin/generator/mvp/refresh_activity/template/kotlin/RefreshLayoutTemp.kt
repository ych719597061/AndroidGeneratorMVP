package generator.mvp.refresh_activity.template.kotlin

/**
 * @author  LiuJiang
 * Desc:
 */
fun refreshLayoutTemp(
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

    <com.scwang.smart.refresh.layout.SmartRefreshLayout
        android:id="@+id/smart_refresh_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:srlEnableAutoLoadMore="true"
        app:srlEnableLoadMore="true"
        app:srlEnableRefresh="true">

        <com.sum.multiple.MultipleStatusView
            android:id="@+id/mu_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent">


            <com.sum.simple.SimpleRecyclerView
                android:id="@+id/recycler_view"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
        </com.sum.multiple.MultipleStatusView>
    </com.scwang.smart.refresh.layout.SmartRefreshLayout>
</LinearLayout>
""".trimIndent()