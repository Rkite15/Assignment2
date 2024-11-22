// started by defining the datasource interface
interface RoselineDataSource {
    void execute_something();
}

// then Implementing the DataSource interface in Update, View, and Delete classes
class Update implements RoselineDataSource {
    @Override
    public void execute_something() {
        System.out.println("Update operation done");
    }
}

class View implements RoselineDataSource {
    @Override
    public void execute_something() {
        System.out.println("View operation done");
    }
}

class Delete implements RoselineDataSource {
    @Override
    public void execute_something() {
        System.out.println("Delete operation done");
    }
}

// Abstract Account class
abstract class Account {
    protected int id;
    protected String name;
    private RoselineDataSource myData;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void performOperation(RoselineDataSource myData) {
        this.myData = myData;
        System.out.println(name + " is performing some operation:");
        myData.execute_something();
    }
}

// Admin class extending Account
class Admin extends Account {
    private String authPassword;

    public Admin(int id, String name, String authPassword) {
        super(id, name);
        this.authPassword = authPassword;
    }

    public String getAuthPassword() {
        return authPassword;
    }
}

// User class extending Account
class User extends Account {
    public User(int id, String name) {
        super(id, name);
    }
}

// Main class to demonstrate functionality
public class Main {
    public static void main(String[] args) {
        // Creating Admin and User objects
        Admin admin = new Admin(1, "AdminUser", "admin123");
        User user = new User(2, "NormalUser");

        // Creating instances of Update, View, and Delete operations
        RoselineDataSource updateOperation = new Update();
        RoselineDataSource viewOperation = new View();
        RoselineDataSource deleteOperation = new Delete();

        // Performing operations
        admin.performOperation(updateOperation); // Admin performing update
        user.performOperation(viewOperation);   // User performing view
        admin.performOperation(deleteOperation); // Admin performing delete
    }
}
