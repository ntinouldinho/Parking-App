public class User {
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String username;
    private String password;
    private Credits credits;
    private Address address;
    private Rating rating;



    public User(String name, String surname, String phone, String email, String username, String password, Credits credits, Address address, Rating rating) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
        this.credits = credits;
        this.address = address;
        this.rating = rating;
    }

    public User(){}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Credits getCredits() {
        return credits;
    }

    public Address getAddress() {
        return address;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", credits=" + credits +
                ", address=" + address +
                ", rating=" + rating +
                '}';
    }
}
