import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public record FileHandler(String FILENAME, String FILETYPE) implements FileService {

    @Override
    public void createFile(String data) throws FileException {
        try {
            FileWriter writer = new FileWriter(FILENAME + FILETYPE);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            throw new FileException("ERROR " + FILENAME + "!", e);
        }
    }

    @Override
    public void fileReader() throws FileException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME + FILETYPE));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileException("ERROR " + FILENAME + "!", e);
        }
    }

    public void deleteFile() throws FileException {
        File file = new File(FILENAME + FILETYPE);
        if (file.exists()) {
            if (!file.delete()) {
                throw new FileException("Не удалось удалить файл: " + FILENAME + FILETYPE);
            }
        } else {
            throw new FileException("Файл не найден: " + FILENAME + FILETYPE);
        }
    }
}
