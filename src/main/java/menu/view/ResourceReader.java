package menu.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResourceReader {

    public List<String> read() {
        List<String> menus = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/category.md"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                menus.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return menus;
    }
}
