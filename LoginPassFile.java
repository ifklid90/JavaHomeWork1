import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by user on 15.10.14.
 */
public class LoginPassFile {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("user_pass");
        Scanner sc = new Scanner(file);

        String username = sc.next();
        String password = sc.next();

        Console console = System.console();

        if (console != null){

            console.printf("Enter username:");
            String user = console.readLine();
            console.printf("Enter password:");
            String p = new String(console.readPassword());

            if (user.equals(username) && password.equals(p)){
                console.printf("right\n");
            } else {
                console.printf("wrong\n");
            }

        } else {
            System.out.println("No console");
        }
    }
}
