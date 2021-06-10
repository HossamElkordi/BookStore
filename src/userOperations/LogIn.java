package userOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.chrono.IsoChronology;
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

    public boolean CheckCredentials(String UserName, String Password)
    {
        Operation operation = new SearchForBooks();
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
}
