/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VALIDATIONS;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author BUWANEKA
 */
public class MyValidator {

    public static String format = "";

    public MyValidator() {

    }

    public MyValidator(String Format) {

        this.format = Format;
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public String replacer(String value) {

        if (value != null) {
            return value.replaceAll("\'", "\''");
        } else {
            return "";
        }

    }

    public void NumbersOnly(JTextField tf, java.awt.event.KeyEvent e) {
        char c = e.getKeyChar();
      if (!((c >= '0') && (c <= '9') ||
         (c == KeyEvent.VK_BACK_SPACE) ||
         (c == KeyEvent.VK_DELETE))) {
        
        e.consume();
      }
    }

    public void NumbersOnly(JTextField tf, int MaximumChars, java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar()) || tf.getText().length() >= MaximumChars) {
            evt.consume();
        }

    }

    public void LimitForChars(JTextField tf, int MaximumChars, java.awt.event.KeyEvent evt) {
        if (tf.getText().length() >= MaximumChars) {
            evt.consume();
        }
    }

    public void disableSpecialCharacters(JTextField tf, java.awt.event.KeyEvent e) {
        /*
        
         222 sigle double " /'
         59   semi colen ;
         46 dot
         44 coma
         47 question mark
         32 space
         91  [
         93  ]
        
         */
        char c = e.getKeyChar();
        if (((c == ',') || (c == '<') || (c == '[') || (c == ']') || (c == '{') || (c == '}') || (c == '>') || (c == '?') || (c == '/') || (c == ';') || (c == ':') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            e.consume();
        } else {

        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean isSpecialCharactersIN(String txt) {
        /*
        
         222 sigle double " /'
         59   semi colen ;
         46 dot
         44 coma
         47 question mark
         32 space
         91  [
         93  ]
        
         */

        boolean state = false;
        char[] ar_txt = txt.toCharArray();
        for (int i = 0; i < ar_txt.length; i++) {
            char c = ar_txt[i];
            if (((c == ',') || (c == '<') || (c == '[') || (c == ']') || (c == '{') || (c == '}') || (c == '>') || (c == '?') || (c == '/') || (c == ';') || (c == ':') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                state = true;
            }
        }
        return state;
    }

    /*
     Create Mask format Eg: ####-#  1234-5
     */
    public String createMaskValidator(String format) {
        System.out.println("format:" + format);
        String value = format;
        //  System.out.println("Value:"+value);
        char[] ar_val = value.toCharArray();
        System.out.println("arLe:" + ar_val.length);
        String mask = "";
        for (int i = 0; i < ar_val.length; i++) {
            String tem_mask = "";

            int val = Integer.parseInt("" + ar_val[i]);
            for (int j = 0; j < val; j++) {
                tem_mask = tem_mask + "#";
            }
            mask = mask + tem_mask + "-";

        }

        return mask.substring(0, mask.length() - 1);
    }

    public void validateforFloatingPoints(JTextField tf, KeyEvent evt, int digits_after_Dot) {
        String text = tf.getText();
        if (text.equals("")) {
            if (!Character.isDigit(evt.getKeyChar())) {
                evt.consume();
            } else if (evt.getKeyChar() == '-') {

            }
        } else {
            if (isDotAvailable(text)) {
                int digitsAfterDot = digitsAfterDot(text);
                System.out.println("afterDot:" + digitsAfterDot);
                if (digitsAfterDot(text) < digits_after_Dot) {
                    if (!Character.isDigit(evt.getKeyChar())) {
                        evt.consume();
                    }
                } else {
                    evt.consume();
                }
            } else {
                if (evt.getKeyChar() != '.' && !Character.isDigit(evt.getKeyChar())) {
                    evt.consume();
                }
            }
        }
    }

    /*
     Validate for floating point in touchmode
    
     */
    public String validateforFloatingPoints_touch(JTextField tf, char key, int digits_after_Dot) {
        String text = tf.getText();
        if (text.equals("")) {
            if (Character.isDigit(key)) {
                text += key;
            } else if (key == '-') {

                text += key;
            }
        } else {
            if (isDotAvailable(text)) {
                if (digitsAfterDot(text) < digits_after_Dot) {
                    if (Character.isDigit(key)) {
                        text += key;
                    }
                }
            } else {
                if (key == '.' || Character.isDigit(key)) {
                    text += key;
                }
            }
        }

        return text;
    }

    /*
      
     */
    private boolean isDotAvailable(String txt) {
        int count = 0;
        for (int i = 0; i < txt.length(); i++) {
            char charAt = txt.charAt(i);
            if (charAt == '.') {
                count++;
                break;
            }
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }

    /* Dots after digit */
    private int digitsAfterDot(String txt) {

        int DotPos = 0;
        for (int i = 0; i < txt.length(); i++) {
            char charAt = txt.charAt(i);
            if (charAt == '.') {
                DotPos = i;
                break;
            }
        }

        return txt.length() - (DotPos + 1);

    }
}
