/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author 721292
 */
public class UserService {
    
    private String username;
    private String password;

    public UserService() {
    }

    public UserService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean login(String u, String p)
    {
        if(u.equals("adam") && p.equals("password"))
        {
            return true;
        }
        else if(u.equals("betty") && p.equals("password"))
        {
            return true;
        }
        return false;
    }
    
}
