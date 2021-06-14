package userOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogIn{
    private String UserName;
    private String Password;
    private String LName;
    private String FName;
    private String Email;
    private String Phone;
    private String ShippingAddress;
    private String UserType;

    public boolean CheckCredentials(String UserName, String Password) throws SQLException {
        Operation operation = new Select();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("*");
        arguments.add("USER");
        arguments.add("UserName="+UserName+" and Password="+Password);
        ResultSet UserInfo = operation.execute(arguments);
        int size = 0;
        try{
            while(UserInfo.next())
            {
                ++size;
                this.UserName=UserInfo.getString(1);
                this.Password=UserInfo.getString(2);
                this.LName=UserInfo.getString(3);
                this.FName=UserInfo.getString(4);
                this.Email=UserInfo.getString(5);
                this.Phone=UserInfo.getString(6);
                this.ShippingAddress=UserInfo.getString(7);
                this.UserType=UserInfo.getString(8);
            }
            return size==1;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void Register(String text, String textPasswordText, String textFirstnameText, String textLastnameText, String textEmailText, String textPhoneText, String textAddressText) throws SQLException {
        Operation operation = new Insert();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("User");
        arguments.add(text);
        arguments.add(textPasswordText);
        arguments.add(textLastnameText);
        arguments.add(textFirstnameText);
        arguments.add(textEmailText);
        arguments.add(textPhoneText);
        arguments.add(textAddressText);
        operation.execute(arguments);
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getLName() {
        return LName;
    }

    public String getFName() {
        return FName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getShippingAddress() {
        return ShippingAddress;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setShippingAddress(String shippingAddress) {
        ShippingAddress = shippingAddress;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }
}
