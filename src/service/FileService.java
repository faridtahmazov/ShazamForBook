package service;

import java.io.*;
import java.util.*;

import static service.FindService.*;

public class FileService {

    private String fileRead(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String fileText = "";
        String line = "";
        while ((line=bufferedReader.readLine())!=null){
            fileText+=line;
        }
        return fileText;
    }

    public static String[] getTextInFile(String fileName){
        FileService fileService = new FileService();
        String[] textArr;
        File file = new File("D:\\TahmazovFarid\\OneDrive\\Belgeler\\Workspace\\IdeaProjects\\ShazamForBook\\src\\file\\"
        + fileName);
        if (!file.exists()){
            System.out.println("File not exists!");
            return null;
        }
        try {
            textArr = fileService.fileRead(file).split("\\.");
            return textArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, String> searchFile(String sentence){
        List<String> fileNames = Arrays.asList("book1.txt", "book2.txt");
        HashMap<String, String> hashMap = new HashMap();
        String[] fileText;
        for (int i=0; i<fileNames.size(); i++){
            fileText = FileService.getTextInFile(fileNames.get(i));
            for (int j=0; j<fileText.length; j++){
                int asciiSumInFile = getAsciiSum(fileText[j]);
                int asciiSumInInput = getAsciiSum(sentence);
                int maxSum = asciiSumInInput+50;
                int minSum = asciiSumInInput-50;
                if (asciiSumInFile==asciiSumInInput || (asciiSumInFile>=minSum && asciiSumInFile<=maxSum)){
                    hashMap.put(fileText[j], fileNames.get(i));
                }
            }
        }
        return hashMap;
    }

    public String findSentenceInBook(String sentence){
        int count=0;
        int index=0;
        boolean isFind = false;
        FileService fileService = new FileService();
        HashMap<String, String> hashMap = fileService.searchFile(sentence);
        for (Map.Entry entry: hashMap.entrySet()){
            char[] fileChar = entry.getKey().toString().toCharArray();
            char[] inputChar = sentence.toCharArray();
            for (int j=0; j<inputChar.length; j++){
                int f = fileChar[index];
                int i = inputChar[j];
                if (f==i){
                    count++;
                }
            }
            index++;
            if (count>0){
                isFind = true;
            }
        }

        if (isFind==true){
            String sentenceFind = "";
            String bookFind = "";
            for (Map.Entry entry: hashMap.entrySet()){
                sentenceFind = entry.getKey().toString();
                bookFind = entry.getValue().toString();
            }
            return "Search sentence: " + sentenceFind + "\n" +
                    "At this book: " + bookFind;
        }

        return "Don't find!";
    }

}
