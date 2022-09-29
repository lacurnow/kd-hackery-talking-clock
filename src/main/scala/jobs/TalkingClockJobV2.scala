package jobs

import actions.TalkingClockActionsV2.{getTime, timeToString}
import actions.TextToSpeechActions.textToSpeech

object TalkingClockJobV2 extends App {
  val currentTime = getTime
  println(timeToString(currentTime))
  textToSpeech(timeToString(currentTime))
}