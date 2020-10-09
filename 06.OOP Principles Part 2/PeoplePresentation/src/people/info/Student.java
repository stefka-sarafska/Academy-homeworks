package people.info;

public class Student extends Person {
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;
	private final int durationOfOneLecture = 120;
	private final int durationOfOneExercise = 90;
	private final int schoolDays = 5;

	public Student(String firstName, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
		super(firstName, lastName);
		setFacultyNumber(facultyNumber);
		setLectureCount(lectureCount);
		setExerciseCount(exerciseCount);
	}

	public double hoursPerDay(double lectureCountPerWeek, double exerciseCountPerWeek) {
		double durationOfLecturesPerDay = lectureCountPerWeek / schoolDays * durationOfOneLecture/60;
		double durationOfExercisePerDay = exerciseCountPerWeek / schoolDays * durationOfOneExercise/60;
		double hoursPerDay = durationOfExercisePerDay + durationOfLecturesPerDay;
		return hoursPerDay;
	}

	public void setFacultyNumber(String facultyNumber) {
		if (facultyNumber != null && facultyNumber.length() >= 5 && facultyNumber.length() <= 10) {
			this.facultyNumber = facultyNumber;
		} else {
			System.out.println("Expected length for faculty number is beween 5 and 10 symbols.");
			System.exit(1);
		}
	}

	public void setLectureCount(int lectureCount) {
		if (lectureCount >= 0) {
			this.lectureCount = lectureCount;
		} else {
			System.out.println("Expected positive number for lecture count.");
			System.exit(1);
		}
	}

	public void setExerciseCount(int exerciseCount) {
		if (exerciseCount >= 0) {
			this.exerciseCount = exerciseCount;
		} else {
			System.out.println("Expected positive number for exercise count.");
			System.exit(1);
		}
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public int getLectureCount() {
		return lectureCount;
	}

	public int getExerciseCount() {
		return exerciseCount;
	}
}
