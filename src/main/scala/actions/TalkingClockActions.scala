package actions

import java.util.Calendar

case class HourAndMinute(hour: Int, minute: Int)

object TalkingClockActions {

  def getTime: HourAndMinute = {
    val timeNow = Calendar.getInstance()
    val hour = timeNow.get(Calendar.HOUR_OF_DAY)
    val minute = timeNow.get(Calendar.MINUTE)
    HourAndMinute(hour, minute)
  }

  def convertToWords(time: HourAndMinute): String = {
    val numberWords = Map(0 -> "zero", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six",
      7 ->"seven", 8 -> "eight", 9 -> "nine", 10 -> "ten", 11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen",
    15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen", 20 -> "twenty",
      30 -> "thirty", 40 -> "forty", 50 -> "fifty")

    val timeString = new StringBuilder("The time is ")
    val hour = time.hour
    val minNum = time.minute

    if (hour == 0) {
      // The time is x past midnight.
      if ((minNum <= 20) || (minNum % 10 == 0)) {
        val min = numberWords.get(minNum)
        min match {
          case Some(min) => timeString.append(s"$min ")
          case None => println("Midnight error")
          }
        } else {
        val tensMins = numberWords.get((minNum / 10) * 10)
        tensMins match {
          case Some(tensMins) => timeString.append(s"$tensMins ")
          case None => println("Min Error")
        }
        val unitsMins = numberWords.get(minNum % 10)
        unitsMins match {
          case Some(unitsMins) => timeString.append(s"$unitsMins ")
          case None => println("Min Error")
        }
      }
      timeString.append("minutes past midnight.")
    }
    else {
      val hourNum = if (hour <= 12) hour else hour % 12
      val hourString = numberWords.get(hourNum)
      hourString match {
        case Some(hourString) => timeString.append(s"$hourString")
        case None => println("Hour Error")
      }

      if (minNum == 0) {
        timeString.append(" ")
      }
      else {
        if ((minNum % 10 == 0) || (minNum < 19)) {
          val numberString = numberWords.get(minNum)
          numberString match {
            case Some(numberString) => if (minNum < 10) timeString.append(" oh ") else timeString.append(" ")
              timeString.append(s"$numberString ")
            case None => println("Min Error")
          }
        } else {
          val tensMins = numberWords.get((minNum / 10) * 10)
          tensMins match {
            case Some(tensMins) => timeString.append(s" $tensMins ")
            case None => println("Min Error")
          }
          val unitsMins = numberWords.get(minNum % 10)
          unitsMins match {
            case Some(unitsMins) => timeString.append(s"$unitsMins ")
            case None => println("Min Error")
          }
        }
      }

      if (hour >= 12) timeString.append("PM.") else timeString.append("AM.")
    }
    timeString.toString
  }
}