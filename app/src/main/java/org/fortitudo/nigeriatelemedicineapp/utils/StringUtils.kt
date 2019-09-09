package org.fortitudo.nigeriatelemedicineapp.utils

class StringUtils {

    companion object {

        private val NULL_AS_STRING = "null"
        private val SPACE_CHAR = " "

        fun notNull(string: String?): Boolean {
            return null != string && NULL_AS_STRING != string.trim { it <= ' ' }
        }

        fun isBlank(s: String?): Boolean {
            var check = s?.replace(" ".toRegex(), "")
            return(check == NULL_AS_STRING || check == "" || check == SPACE_CHAR)
        }

        fun check(s: String?) : Boolean
        {
            return notNull(s) && !isBlank(s)
        }
    }
}