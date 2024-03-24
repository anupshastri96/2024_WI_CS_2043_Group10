import java.time.LocalDate;

public class Members {
    private String name;
    private int age;
    private String gender;
    private String ethnicity;
    private String phoneNumber;
    private LocalDate membershipDate;
    private static int membershipID = 100000; // Starting membership ID
    private int memID;

    public Members(String name, int age, String gender, String phoneNumber, String ethnicity) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.ethnicity = ethnicity;
        this.membershipDate = LocalDate.now();
        this.memID = membershipID++;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }
    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public int getMembershipID() {
        return memID;
    }

    public void setMembershipID(int memID) {
        this.memID = memID;
    }
}
