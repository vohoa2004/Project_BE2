
package core;

/**
 *
 * @author vothimaihoa
 */
public class User {
    private String username;
    private String password;
    
    //Constructor
    public User(){
    }
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    
   //Getter
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    //Setter
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    //to String
    @Override
    public String toString(){
        return "User{" +
                "username =" + username +
                "password =" + password +
                "}";
    } 
    
}

