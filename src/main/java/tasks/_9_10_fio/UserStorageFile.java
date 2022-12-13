package tasks._9_10_fio;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class UserStorageFile {
    private final String filePath;

    public UserStorageFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void write(tasks._9_10_fio.User user) {
        try {
            Path path = Path.of(filePath);

            if(!Files.exists(path)) {
                Files.createFile(path);
            }

            var objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(user);
        } catch (IOException exception) {
            throw new UnsupportedOperationException("Cannot write the user to file " + filePath + ", because of " + exception);
        }
    }

    public User read() {
        try {
            var objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            return (User) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
            throw new UnsupportedOperationException("Cannot read the user from file " + filePath + ", because of " + exception);
        }
    }
}
