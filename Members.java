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

    public String toFileFormat() {
        return id + ";" + name + ";" + phoneNumber + ";" + address;
    }

    public static Members fromFileFormat(String line) {
        String[] parts = line.split(";");
        return new Members(parts[0], parts[1], parts[2], parts[3]);
    }
}
