/**
 *
 * @author Trevor Hartman
 * @author Jeff Grimm
 *
 * @since Version 1.0
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create a scanner object

        // Write a loop - that will ask the user - to enter a file path - to gather stats on,
        // and continue until "Q" is entered.

        // Reference Java-Assignment-003 to see how to use the java.nio libraries to turn a String path into a File

        // Ask the user if they would like to skip whitespace

        // Create a variable called skipWs that stores the user's response as a boolean

        while (true) {

            Scanner in = new Scanner(System.in); // New Scanner object

            String fp; // Declares new var filePath
            boolean skipWs; // Declares boolean var skipWs

            System.out.println("Enter file path (Q to quit): "); // Asks for user to enter file path

            fp = in.nextLine(); // Stores user input as var filePath

            if (fp.equalsIgnoreCase("q")) {
                break;
            }

            Path path = Paths.get(fp);
            // Creates object path of type Path and passes value stored in filePath

            //System.out.println("path is equal to " + path); // scaffolding

            System.out.println("Would you like to skip whitespace (Y/N)? "); // Asks user to skip whitespace
            String sws = in.nextLine(); // Stores user response as var skip white space (sws)

            //System.out.println("sws before skipWs is equal to " + sws); // Scaffolding

            // Converts user response to boolean T/F and stores as var skipWs
            if (sws.equalsIgnoreCase("Y")) {
                skipWs = true;
            } else if (sws.equalsIgnoreCase("N")) {
                skipWs = false;
            } else {
                System.out.println("Invalid input");
                continue;
            }

            //System.out.println("skipWs after assignment is equal to " + skipWs); // Scaffolding

            /*
             * Within this try/catch block, which is used to handle possible errors thrown by the code in the try block,
             * write code to get the line, word, and character count of the File object created above!
             */
            try {

                // You will need to create a FileStats object by passing it the File object and your skipWs variable as args

                FileStats fs = new FileStats(path.toFile(), skipWs);

                // You will need to call the fs.read method, which you need to implement!

                fs.read(); // How do I pass fs.read the path object !!!!!!!!!!!!!!!!!!!!!!!!!!!

                /*
                 * You will access the FileStats object's getter methods to get the file's line, word, character count and
                 * the files name. You should use a format specifier to print it all out similar to the following example:
                 *
                 * Stats: lines - 6, words - 46, chars - 237 /path/to/file/fileName.txt
                 */

                int lines = fs.getNumLines(); // lines is equal to fs object's method - getNumLines

                int words = fs.getNumWords(); // words are equal to fs object's method getNumWords

                int chars = fs.getNumChars(); // chars is equal to fs object's method getNumChars

                Path filename = Path.of(fs.getFileName()); // "" but lists file's path

                System.out.printf("Stats: lines - %d, words - %d, chars - %d %s", lines, words, chars, filename);

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
