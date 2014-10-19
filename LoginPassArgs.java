import java.io.Console;

/**
 * Created by user on 15.10.14.
 */
public class LoginPassArgs {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

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
