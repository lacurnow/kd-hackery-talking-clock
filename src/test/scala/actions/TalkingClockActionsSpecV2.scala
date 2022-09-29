package actions

import jobs.TalkingClockJobV2

import org.scalatest.{BeforeAndAfterAll, FlatSpec, Matchers}

class TalkingClockActionsSpecV2 extends FlatSpec with Matchers with BeforeAndAfterAll {

  behavior of "actions.TalkingClockActions"

  it should "return the correct time at midnight" in {

    val expected = "The time is zero minutes past midnight."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(0, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 0.31 AM." in {
    val expected = "The time is thirty one minutes past midnight."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(0, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 0.01 AM." in {
    val expected = "The time is one minutes past midnight."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(0, 1))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 1.01 AM." in {
    val expected = "The time is one oh one AM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(1, 1))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 4.31 AM." in {
    val expected = "The time is four thirty one AM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(4, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 4.31 PM." in {
    val expected = "The time is four thirty one PM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(16, 31))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.00 PM." in {
    val expected = "The time is twelve PM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(12, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 8.00 PM." in {
    val expected = "The time is eight PM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(20, 0))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.12 PM." in {
    val expected = "The time is twelve twelve PM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(12, 12))

    actual should contain theSameElementsAs expected
  }

  it should "return the correct time at 12.01 PM." in {
    val expected = "The time is twelve oh one PM."

    val actual = TalkingClockActionsV2.timeToString(HourAndMinute(12, 1))

    actual should contain theSameElementsAs expected
  }
}

