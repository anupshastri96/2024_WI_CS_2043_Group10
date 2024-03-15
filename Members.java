import java.time.LocalDate;

public class Members{
    private String name;
    private int age;
    private String gender;
    private String phoneNumber;
    private LocalDate membershipDate;
    private final int memID;

    public Members(String name, int age, String gender, 
                    String phoneNumber, int memID){
        this.name = name;
        this.age = age;
        this.phoneNumber= phoneNumber;
        this.memID= memID;
        membershipDate = LocalDate.now(); 
    } 

    public void setName(String name) {
        this.name = name;
    }  

    public void setGender(String gender) {
        this.gender = gender;
    }  

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }  

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    public String getNumber(){
        return phoneNumber;
    }
    public LocalDate getMemDate(){
        return membershipDate;
    }
}