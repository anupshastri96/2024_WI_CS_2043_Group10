import java.time.LocalDate;

public class Members{
    private String name;
    private int age;
    private String gender;
    private String ethnicity;
    private String phoneNumber;
    private LocalDate membershipDate;
    private static int membershipID = 000000; 
    private int memID;

    public Members(String name, int age, String gender, String phoneNumber, String ethnicity){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.memID = membershipID++;,
        this.ethnicity = ethnicity;
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
    
    public String getEthnicity(){
        return ethnicity;
    }
    
    public LocalDate getMemDate(){
        return membershipDate;
    }
}
