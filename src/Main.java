import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Student {
    private static int nextIndexNumber = 1;
    private String indexNumber;
    private String status;
    private List<StudyProgram> studyPrograms;
    private int currentSemester;
    private int itnCount;
    private int maxItnAllowed;
    private String firstName;
    private String lastName;
    private String email;
    private String address;

    public Student(String firstName, String lastName, String email, String address, int maxItnAllowed) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.indexNumber = "s" + nextIndexNumber++;
        this.status = "candidate"; // Default status
        this.studyPrograms = new ArrayList<>();
        this.currentSemester = 1; // Default to first semester
        this.itnCount = 0;
        this.maxItnAllowed = maxItnAllowed;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getIndexNumber() {
        return indexNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public void enrollStudent(StudyProgram program) {
        studyPrograms.add(program);
    }

    public int getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(int currentSemester) {
        this.currentSemester = currentSemester;
    }

    public void addGrade(int grade, String subject) {
        // Add grade implementation
    }

    public void promoteToNextSemester() {
        if (s.currentSemester < s.studyPrograms.get(0).getNumberOfSemesters()) {
            s.currentSemester++;
        } else {
            s.status = "graduate";
        }
    }

    public void incrementItnCount() {
        s.itnCount++;
    }

    public boolean isExceedMaxItn() {
        return s.itnCount >= s.maxItnAllowed;
    }
}

class StudyProgram {
    private String programName;
    private String description;
    private int numberOfSemesters;
    private int maxItnAllowed;

    public StudyProgram(String programName, String description, int numberOfSemesters, int maxItnAllowed) {
        this.programName = programName;
        this.description = description;
        this.numberOfSemesters = numberOfSemesters;
        this.maxItnAllowed = maxItnAllowed;
    }


    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfSemesters() {
        return numberOfSemesters;
    }

    public void setNumberOfSemesters(int numberOfSemesters) {
        this.numberOfSemesters = numberOfSemesters;
    }

    public int getMaxItnAllowed() {
        return maxItnAllowed;
    }

    public void setMaxItnAllowed(int maxItnAllowed) {
        this.maxItnAllowed = maxItnAllowed;
    }
}

class StudentInfo {
    private static List<Student> studentList = new ArrayList<>();

    public static void promoteAllStudents() {
        for (Student s : studentList) {
            if (!s.getStatus().equals("graduate")) {
                if (s.getCurrentSemester() < s.getStudyPrograms().get(0).getNumberOfSemesters() &&
                        !s.isExceedMaxItn()) {
                    s.promoteToNextSemester();
                } else {
                    s.setStatus("graduate");
                }
            }
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student s : studentList) {
            System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
            System.out.println("Index Number: " + s.getIndexNumber());
            System.out.println("Status: " + s.getStatus());
            System.out.println("Current Semester: " + s.getCurrentSemester());
            System.out.println("Study Programs:");
            for (StudyProgram program : s.getStudyPrograms()) {
                System.out.println("- " + program.getProgramName() + ": " + program.getDescription());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        StudentInfo studentInfo = new StudentInfo();
        Student s = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12", 5);
        StudyProgram it = new StudyProgram("IT", "AAA", 7, 5);
        s.enrollStudent(it);
        s.addGrade(5, "PGO");
        s.addGrade(2, "APBD");

        studentList.add(s);

        promoteAllStudents();

        displayInfoAboutAllStudents();
    }
}
