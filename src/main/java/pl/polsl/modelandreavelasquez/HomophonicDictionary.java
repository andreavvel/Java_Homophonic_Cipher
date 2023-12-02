package pl.polsl.modelandreavelasquez;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Dictionary Class of the HomophonicCipher
 * @author Andrea Velasquez
 * @version 1.0
 */
public class HomophonicDictionary {
    /**
     * This is the HashMap that contains the dictionary for the Homophonic Cipher
     */
    public final Map<Character, List<Integer>> homophones = new HashMap<>()
    {
        {
            put('a', new ArrayList<>(List.of(21, 27, 31, 40)));
            put('b', new ArrayList<>(List.of(15)));
            put('c', new ArrayList<>(List.of(50, 33)));
            put('d', new ArrayList<>(List.of(20, 34)));
            put('e', new ArrayList<>(List.of(22, 28, 32, 36, 37)));
            put('f', new ArrayList<>(List.of(57)));
            put('g', new ArrayList<>(List.of(17)));
            put('h', new ArrayList<>(List.of(14)));
            put('i', new ArrayList<>(List.of(63, 29, 38, 41)));
            put('j', new ArrayList<>(List.of(19)));
            put('k', new ArrayList<>(List.of(70)));
            put('l', new ArrayList<>(List.of(84, 39, 42)));
            put('m', new ArrayList<>(List.of(91, 43)));
            put('n', new ArrayList<>(List.of(12, 48, 97)));
            put('o', new ArrayList<>(List.of(18, 60, 85)));
            put('p', new ArrayList<>(List.of(26, 44)));
            put('q', new ArrayList<>(List.of(25)));
            put('r', new ArrayList<>(List.of(24, 49)));
            put('s', new ArrayList<>(List.of(10, 30, 45, 99)));
            put('t', new ArrayList<>(List.of(35, 96, 55)));
            put('u', new ArrayList<>(List.of(16, 94)));
            put('v', new ArrayList<>(List.of(23)));
            put('w', new ArrayList<>(List.of(13)));
            put('x', new ArrayList<>(List.of(11)));
            put('y', new ArrayList<>(List.of(98)));
            put('z', new ArrayList<>(List.of(77)));
            put(' ', new ArrayList<>(List.of(47)));
        }
    };
}
