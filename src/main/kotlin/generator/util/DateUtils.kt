package generator.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * @author  LiuJiang
 * Desc:    Date工具类
 */
class DateUtils {
    companion object {
        fun time(): String {
            val dateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.CHINA)
            return dateFormat.format(Date())
        }
    }
}