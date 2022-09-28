package actions

object TextToSpeechActions {
  def textToSpeech(inputText: String): Unit = {
    Runtime.getRuntime.exec(s"say $inputText")
  }
}
