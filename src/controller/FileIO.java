package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO<T> {
    public void writeToFile(String filePath, List<T> list) throws IOException {
      FileWriter fileWriter = new FileWriter(filePath);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(list.toString());
      bufferedWriter.flush();
      bufferedWriter.close();
      fileWriter.close();
    }

    public List<T> readFromFile(String content) throws IOException, ClassNotFoundException {
        List<T> list = new ArrayList<>();
        FileReader fileReader = new FileReader(content);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            list.add((T) line);
        }
        bufferedReader.close();
        fileReader.close();
        return list;
    }
}
