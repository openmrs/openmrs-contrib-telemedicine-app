package com.example.nigeriatelemedicineapp.utils

class DateUtlis {

    companion object {

        fun checkDateFormat(date: String) : Boolean {
            return DateUtlis().validate(date)
        }

        fun getCorrectDateFormat(date:String) : String{
           val StringArray = date.split("-")
            var correctFormat: String=""
            correctFormat= correctFormat+StringArray[2]+"-"+StringArray[1]+"-"+StringArray[0]
            return correctFormat.trim()
        }

    }

    fun validate(dateString: String): Boolean {
        val s = dateString.trim { it <= ' ' }
        // length must be min d/M/yyyy and max dd/MM/yyyy
        if (s.isEmpty() || s.length < 8 || s.length > 10) {
            return false
        }
        // number of slashes must be 2
        if (!s.contains("-")) {
            return false
        }

        var numberOfDashes = 0
        for (i in 0 until s.length) {
            if (s[i] == '-') {
                numberOfDashes++
            }
        }

        if (numberOfDashes != 2) run { return false }

        // check day, month and year
        val bundledDate = s.split("-")
        val day = Integer.parseInt(bundledDate[0])

        if (bundledDate[0].isEmpty() || day < 1 || day > 31)
            return false

        val month = Integer.parseInt(bundledDate[1])

        if(bundledDate[1].isEmpty() || month<1 || month>12)
            return false

        val year = bundledDate[2]

        if (year.length!=4)
            return false

        return true
    }
}