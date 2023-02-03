package generator.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * 获取当前时间
 */
fun time(): String {
    val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.CHINA)
    return dateFormat.format(Date())
}

/**
 * 下划线转驼峰
 */
fun underlineToHump(param: String): String {
    if (param.isEmpty()) {
        return ""
    }
    //全部转小写
    return param.lowercase().split("_").map { item ->
        //每个单词首字母大写
        item.replaceFirstChar { first ->
            first.uppercase()
        }
    }.joinToString("")
}