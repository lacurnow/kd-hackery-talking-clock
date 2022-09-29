package actions

import java.util.Calendar

case class HourAndMinute(hour: Int, minute: Int)

object TalkingClockActionsV2 {

  def getTime: HourAndMinute = {
    val timeNow = Calendar.getInstance()
    val hour = timeNow.get(Calendar.HOUR_OF_DAY)
    val minute = timeNow.get(Calendar.MINUTE)
    HourAndMinute(hour, minute)
  }

  def convertNumberToWords(number: Int): String = {
    val numberWords = Map(0 -> "zero", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six",
      7 -> "seven", 8 -> "eight", 9 -> "nine", 10 -> "ten", 11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen",
      15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen", 20 -> "twenty",
      30 -> "thirty", 40 -> "forty", 50 -> "fifty")
    numberWords.get(number) match {
      case Some(number) => number
      case None => "Error retrieving number."
    }
  }

  def timeStringBuilder(hourNum: Int, minNum: Int, tensMinWord: String, unitsMinWord: String, minWord: String, hourWord: String): String = {
    val timeString = new StringBuilder("The time is ")

    if (hourNum == 0) {
      if ((minNum <= 20) || (minNum % 10 == 0)) {
        timeString.append(s"$minWord ")
      } else {
        timeString.append(s"$tensMinWord $unitsMinWord ")
      }
      timeString.append("minutes past midnight.").toString
    }
    else {
      timeString.append(s"$hourWord ")
      if (minNum != 0) {
        if ((minNum <= 20) || (minNum % 10 == 0)) {
          if (minNum < 10) {
            timeString.append(s"oh ")
          }
          timeString.append(s"$minWord ")
        } else {
          timeString.append(s"$tensMinWord $unitsMinWord ")
        }
      }
      if (hourNum >= 12) timeString.append("PM.").toString else timeString.append("AM.").toString
    }
  }
}