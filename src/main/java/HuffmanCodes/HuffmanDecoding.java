package HuffmanCodes;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanDecoding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfCharacters = scanner.nextInt();
        int length = scanner.nextInt();
        Map<String, Character> charactersCodes = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < amountOfCharacters; i++) {
            String input = scanner.nextLine();
            String[] letterAndCode = input.split(":");
            charactersCodes.put(letterAndCode[1].trim(), letterAndCode[0].charAt(0));

        }

        System.out.println(charactersCodes);
        String encodedString = scanner.nextLine();
        String decodedString = decode(encodedString, charactersCodes);
        System.out.println(decodedString);


    }

    private static String decode(String encodedString, Map<String, Character> charactersCodes) {
        StringBuilder builder = new StringBuilder();
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encodedString.length(); i++) {
            builder.append(encodedString.charAt(i));
            if (charactersCodes.containsKey(builder.toString())) {
                decodedString.append(charactersCodes.get(builder.toString()));
                builder = new StringBuilder();
            }
        }
        return decodedString.toString();
    }

}
