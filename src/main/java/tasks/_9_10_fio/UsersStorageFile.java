package tasks._9_10_fio;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UsersStorageFile {
    private final String filePath;

    public UsersStorageFile(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void write(tasks._9_10_fio.User... users) {
        try {
            Path path = Path.of(filePath);

            if(!Files.exists(path)) {
                Files.createFile(path);
            }

            Gson gson = new Gson();
            var json = gson.toJson(users);

            Files.writeString(path, json);
        } catch (IOException exception) {
            throw new UnsupportedOperationException("Cannot write the users to file " + filePath + ", because of " + exception);
        }
    }

    public tasks._9_10_fio.User[] read() {
        try {
            return new Gson().fromJson(new FileReader(filePath), tasks._9_10_fio.User[].class);
        } catch (FileNotFoundException exception) {
            throw new UnsupportedOperationException("Cannot read the users from file " + filePath + ", because of " + exception);
        }
    }
}
