/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0008.CountWord50LocPassed;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author ADMIN
 */
public class Count {

    public static HashMap<String, Integer> countWord(String input) {
        HashMap<String, Integer> word = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            String a = st.nextToken();

            if (!word.containsKey(a)) {
                word.put(a, 1);
            } else {
                word.put(a, word.get(a) + 1);   
            }
        }
        return word;
    }

    public static void display(HashMap<String, Integer> word, HashMap<Character, Integer> character) {
        System.out.println(word);
        System.out.println(character);
    }

    public static HashMap<Character, Integer> countCharacter(String input) {
        HashMap<Character, Integer> character = new HashMap<>();
        StringTokenizer st = new StringTokenizer(input);
        char[] c = input.toCharArray();
        char a = 0;
        for (int i = 0; i < c.length; i++) {
            a = c[i];
            if (Character.isSpaceChar(a)) {
                continue;
            }
            if (!character.containsKey(a)) {
                character.put(a, 1);
            } else {
                character.put(a, character.get(a) + 1);
            }
        }
        return character;
    }
}
