package actions

object TalkingClockJob extends App {
  val timeString = TalkingClockActions.convertToWords(TalkingClockActions.getTime)
  TextToSpeechActions.textToSpeech(timeString)
  println(timeString)
}