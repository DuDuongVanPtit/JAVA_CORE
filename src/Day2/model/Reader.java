package Day2.model;

public class Reader {
    private String readerId, name, address, phoneNumber, readerType;

    public Reader(String readerId, String name, String address, String phoneNumber, String readerType) {
        this.readerId = readerId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.readerType = readerType;
    }

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getReaderType() {
        return readerType;
    }

    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }

    @Override
    public String toString() {
        return
                "readerId='" + readerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", readerType='" + readerType + '\'';
    }
}
