package utils.data;

import com.google.gson.Gson;
import testdata.purchasing.CheapComputer;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComputerTestDataGenerator {

    public static CheapComputer[] getTestDataFrom(String jsonDataFileLocation) {
        CheapComputer[] cheapComputers = new CheapComputer[]{};
        try {
            // create Gson instance
            Gson gson = new Gson();

            // Read file content
            String currentProjectLocation = System.getProperty("user.dir");
            Reader reader = Files.newBufferedReader(Paths.get(currentProjectLocation + jsonDataFileLocation));

            // Convert to array of Computer instances
            cheapComputers = gson.fromJson(reader, CheapComputer[].class);

            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cheapComputers;
    }

}
