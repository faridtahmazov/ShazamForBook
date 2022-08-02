package service;

public class SentenceService {
    /*
    Başda cümləni düzgünlüyünə görə tənzimləmək istədim sonra isə dedim ki, onsuz kombinasiya edirik.
    Bir şey dəyişməyəcək.
     */
    public static boolean validateSentence(char[] characters){
        int index = 0;
        if (Character.isLowerCase(characters[index])){
            System.out.println(1);
            return false;
        }
        while (index<characters.length){
            if (Character.isUpperCase(characters[index])){
                if (Character.isUpperCase(characters[index+1])){
                    return false;
                }
                if (index-1>=0 && characters[index-1]!=' '){
                    return false;
                }
            }
            if (characters[index]==' ' && characters[index+1]==' '){
                return false;
            }
            index++;
        }
        if (characters[index-2]==' ' || characters[index-1]!='.' && characters[index-1]!='?' && characters[index-1]!='!'){
            System.out.println(2);
            return false;
        }
        return true;
    }
}
