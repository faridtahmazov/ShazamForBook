import service.FileService;

public class Main {
    public static void main(String[] args) {
      String result = new FileService().findSentenceInBook("Ohh sentences are long very");
        System.out.println(result);
    }
}
