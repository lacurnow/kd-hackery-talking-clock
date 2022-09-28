package actions

import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}
import java.util.Calendar

class TalkingClockActionsSpec extends FlatSpec with Matchers with BeforeAndAfterAll {

  behavior of "actions.TalkingClockActions"

  it should "return the correct time at midnight" in {
//    val calendar = Calendar.getInstance()
//    calendar.set(2022, Calendar.JULY, 2 ,0,0,0)

    val expected = "The time is zero minutes past midnight."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(0, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 0.31 AM." in {
    val expected = "The time is thirty one minutes past midnight."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(0, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 0.01 AM." in {
    val expected = "The time is one minutes past midnight."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(0, 1))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 1.01 AM." in {
    val expected = "The time is one oh one AM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(1, 1))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 4.31 AM." in {
    val expected = "The time is four thirty one AM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(4, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 4.31 PM." in {
    val expected = "The time is four thirty one PM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(16, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.00 PM." in {
    val expected = "The time is twelve PM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(12, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 8.00 PM." in {
    val expected = "The time is eight PM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(20, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.12 PM." in {
    val expected = "The time is twelve twelve PM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(12, 12))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.01 PM." in {
    val expected = "The time is twelve oh one PM."

    val actual = TalkingClockActions.convertToWords(HourAndMinute(12, 1))

    actual should contain theSameElementsAs expected
  }
}
