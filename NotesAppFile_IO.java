import java.io.*;
import java.util.Scanner;

public class NotesAppFile_IO{
    static final String FILE_NAME = "notes.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--------Notes App---------");
            System.out.println("Welcome to your Study place :)");
            System.out.println("1. Write New Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Update Notes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    writeNewNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    updateNote(sc);
                    break;
                case 4:
                    System.out.println("Gret Work this time Keep it UP. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
        sc.close();
    }
    private static void writeNewNote(Scanner sc) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, false); 
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            fw.close();
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    private static void readNotes() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No notes found yet.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private static void updateNote(Scanner sc) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No existing note file found. Try writing a new note first.");
                return;
            }
            FileWriter fw = new FileWriter(FILE_NAME, true); 
            System.out.print("Enter the note to add: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            fw.close();
            System.out.println("Note updated successfully!");
        } catch (IOException e) {
            System.out.println("Error updating note: " + e.getMessage());
        }
    }
}
