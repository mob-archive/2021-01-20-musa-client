package rgbledring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LedRingsTest {
	private boolean[] leds;

	@Test
	void testGivenRingOfSize2_whenLevelIsSetTo51_thenLED1And2AreOn() {
		givenLEDRingOfSize(2);
		whenLevelIsSetTo(51);
		thenLEDsAre(true, true);
	}

	@Test
	void testGivenRingOfSize2_whenLevelIsSetTo0_thenLED1And2AreOff() {
		givenLEDRingOfSize(2);
		whenLevelIsSetTo(0);
		thenLEDsAre(false, false);
	}

	@Test
	void testGivenRingOfSize2_whenLevelIsSetTo2_thenLED1OnAndLed2Off() {
		givenLEDRingOfSize(2);
		whenLevelIsSetTo(2);
		thenLEDsAre(true, false);
	}

	@Test
	void testGivenRingOfSize4_whenLevelIsSetTo0_thenAllLEDsAreOff() {
		givenLEDRingOfSize(4);
		whenLevelIsSetTo(0);
		thenLEDsAre(false, false, false, false);
	}

	@Test
	void testGivenRingOfSize4_whenLevelIsSetTo80_thenOnlyLED4IsOff() {
		givenLEDRingOfSize(4);
		whenLevelIsSetTo(70);
		thenLEDsAre(true, true, true, false);
	}

	private void thenLEDsAre(boolean... expected) {
		Assertions.assertThat(leds).isEqualTo(expected);
	}

	private void thenLEDIsOn(int index) {
		Assertions.assertThat(leds[index]).isTrue();
	}

	private void thenLEDisOff(int index) {
		Assertions.assertThat(leds[index]).isFalse();
	}

	private void givenLEDRingOfSize(int size) {
		leds = new boolean[size];
	}

	private void whenLevelIsSetTo(int level) {
		if (level == 0) {
			leds[0] = false;
		} else if (level > 0) {
			leds[0] = true;
		}
		if (level > 50) {
			leds[0] = true;
			leds[1] = true;
		}
	}

}

