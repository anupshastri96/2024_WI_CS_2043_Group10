public class Members {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;

    public Members(String id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toFileFormat() {
        return id + ";" + name + ";" + phoneNumber + ";" + address;
    }

    public static Members fromFileFormat(String line) {
        String[] parts = line.split(";");
        if (parts.length == 4) {
            String id = parts[0];
            String name = parts[1];
            String phoneNumber = parts[2];
            String address = parts[3];
            return new Members(id, name, phoneNumber, address);
        } else {
            System.err.println("Invalid member format in file");
            return null;
        }
    }
}
