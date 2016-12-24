package SECURITY;



/**
 *
 * @author BUWANEKA
 */
public class myEncript {

    /*Encript Method*/
    public static String encript(String str_word) {
        String enwrd = "";//encript word
        for (int i = 0; i < str_word.length(); i++) {
            int j = (int) str_word.charAt(i) + 97 + i;
            enwrd = enwrd + "" + Character.toChars(j)[0];
        }
        return enwrd;
    }

    /*Decript Method*/
    public static String decript(String str_enword) {
        String dewrd = "";//decript word
        for (int i = 0; i < str_enword.length(); i++) {
            int j = (int) str_enword.charAt(i) - 97 - i;
            dewrd = dewrd + "" + Character.toChars(j)[0];

        }
        return dewrd;
    }
    
    public static void main(String[] args) {
        System.out.println(encript("bizadmin"));
    }
}
