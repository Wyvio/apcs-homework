/* Jolie Zhou
 * Mr. Peterson
 * APCS Period 2
 * 8 January 2020
 * 
 * This TimeSpan class represents a length of time (hours, minutes).
 */
public class TimeSpan {
	// Fields
	int hours;
	int minutes;

	// The constructor initializes the fields from the parameters.
	public TimeSpan(int h, int m) {
		hours = h;
		minutes = m;
	}

	// This method adds hours and minutes to the current TimeSpan.
	public void add(int h, int m) {
		hours += h;
		minutes += m;
	}

	// This method adds a TimeSpan to the current TimeSpan.
	public void add(TimeSpan t) {
		hours += t.hours;
		minutes += t.minutes;
	}

	// This method returns the total time as a double in hours.
	public double getTotalHours() {
		return (hours * 60.0 + minutes) / 60.0;
	}
	
	// This method carries over 60 minutes to an hour and adjusts the fields accordingly.
	private void checkTime() {
		int minutes = hours * 60 + this.minutes;
		this.minutes = minutes % 60;
		hours = minutes/60;
	}

	// This method outputs TimeSpan as a readable String.
	public String toString() {
		this.checkTime();
		return hours + "h" + minutes + "m";
	}
}
