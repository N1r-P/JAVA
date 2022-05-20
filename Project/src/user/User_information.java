package user;

public class User_information {
    private String name;
    private String password;
    private String phone_number;
    private String address;

    /**
     * initialize the property
     * @param name
     * @param password
     * @param phone_number
     * @param address
     */
    public User_information(String name, String password, String phone_number, String address)
    {
        this.name = name;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
    }

    /**
     * get the name of user
     * @return name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * get the password of user
     * @return password
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * get the phone_number of user
     * @return phone_number
     */
    public String getPhone_number()
    {
        return this.phone_number;
    }

    /**
     * get the address of user
     * @return address
     */
    public String getAddress()
    {
        return this.address;
    }
}
