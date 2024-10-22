package kassa1;

import java.util.Random;

public class Employee {
    protected String login = "123";
    protected String password = "228";

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String generateNewPassword() {
        int num = 8;
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random rand = new Random();
        
        StringBuilder newPassword = new StringBuilder();
        
        for (int i = 0; i < num; i++) {
            int letterIndex = rand.nextInt(letters.length);
            newPassword.append(letters[letterIndex]);
        }
        
        password = newPassword.toString();
        return password;
    }
}