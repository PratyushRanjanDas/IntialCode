public class Karp_Rabin_String {
    private final long PRIME = 101;

    private long calculateHash(String str) {
        long hash = 0;
        long power = 1;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * power; // Use power for each character
            power *= PRIME; // Update power for the next character
        }
        return hash; 
    }

    private long updateHash(long prevHash, char oldChar, char newChar, long primePower) {
        long newHash = (prevHash - oldChar * primePower) / PRIME; // Remove old character
        newHash += newChar; // Add new character (no multiplication since it's the last char)
        return newHash;
    }

    public void search(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));

        // Precompute power for the last character of the pattern
        long primePower = 1;
        for (int i = 0; i < patternLength - 1; i++) {
            primePower *= PRIME;
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index: " + i);
                }
            }
            if (i < textLength - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), primePower);
            }
        }
    }

    public static void main(String[] args) {
        Karp_Rabin_String k = new Karp_Rabin_String();
        k.search("hellohowRu", "how");
    }
}
