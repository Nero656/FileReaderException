import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Options:");
        System.out.println("1: Create and Read file ");
        System.out.println("2: Create new file");
        System.out.println("3: Read file");
        System.out.println("4: Delete file");
        System.out.print("What u want to do? : ");
        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Name ur file");
        String newFileName = scanner.next();
        System.out.println("Input file type");
        String newFileType = scanner.next();

        FileHandler fileHandler = new FileHandler(newFileName, newFileType);
        scanner.nextLine();
        switch (option) {
            case 1: {
                System.out.println("Input the data: ");
                String newData = scanner.nextLine();
                fileHandler.createFile(newData);

                fileHandler.fileReader();
                break;
            }
            case 2: {
                System.out.println("Input the data: ");
                String newData = scanner.nextLine();

                fileHandler.createFile(newData);
                break;
            }
            case 3: {
                fileHandler.fileReader();
                break;
            }
            case 4:{
                fileHandler.deleteFile();
            }
        }
    }
}