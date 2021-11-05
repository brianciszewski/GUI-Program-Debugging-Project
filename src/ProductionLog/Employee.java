package ProductionLog;

public class Employee {

    String name;
    String Password;
    String email;
    String username;

    public Employee(String name, String password) {
        this.name = name;
        this.Password = password;
        name = name.toLowerCase();

        checkName(name);
        isValidPassword(password);
    }

    public Employee(String name, String username, String Password, String email) {
        this.name = name;
        this.username = username;
        this.Password = Password;
        this.email = email;
    }

    // String str1 = "Name: " + name + "\nPassword: " + password;

    @Override
    public String toString() {

        return "Employee Details" + "\nName : " + name + "\nUsername : " + username  + "\nEmail : " + email
        +"\nInitial Password : " + Password + "\n";
    }

    private void setUsername(String name) {
        name = name.toLowerCase();
        if (name.contains(" ")) {
            username = (name.substring(0, 1) + (name.substring(name.indexOf(" ") + 1)));
        } else {
            username = "default";
        }
    }

    public boolean checkName(String name) {

        if (name.contains(" ")) {
            setEmail(name);
            setUsername(name);
            return true;
        } else {
            setUsername("default");
            setEmail("user@oracleacademy.Test");
            return false;
        }
    }

    private void setEmail(String name) {
        if (name.equals("user@oracleacademy.Test") == false) {
            email = name.substring(0, name.indexOf(" ")) + "." +
                    name.substring(name.indexOf(" ") + 1) + "@oracleacademy.Test";
        } else {
            email = "user@oracleacademy.Test";
        }
    }

    // https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
    public void isValidPassword(String password) {


        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        if (hasLowercase && hasUppercase && hasSpecialChar){

    } else {
            Password = "pw";

        }

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

}
