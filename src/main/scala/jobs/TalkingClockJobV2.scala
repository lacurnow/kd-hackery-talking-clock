package actions

import actions.TalkingClockActionsV2.{convertNumberToWords, getTime, timeStringBuilder}

object TalkingClockJobV2 extends App {
  val currentTime = getTime

  def timeToSpeech(currentTime: HourAndMinute) = {
    val hourNum = currentTime.hour
    val minNum = currentTime.minute
    val hourWord = convertNumberToWords(if (hourNum <= 12) hourNum else hourNum % 12)
    val minWord = convertNumberToWords(minNum)
    val unitsMinWord = convertNumberToWords(minNum % 10)
    val tensMinWord = convertNumberToWords(minNum - (minNum % 10))

    val timeString = timeStringBuilder(hourNum, minNum, tensMinWord, unitsMinWord, minWord, hourWord)
    timeString
  }
    println(timeToSpeech(currentTime))
    TextToSpeechActions.textToSpeech(timeToSpeech(currentTime))
}