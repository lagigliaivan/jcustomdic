import java.util.HashSet;
import java.util.Set;

// Add Word: Add a word to the dictionary.
// Search Word: Check if a word exists in the dictionary.
// Auto-Complete: Given a prefix, return a list of words that start with that prefix.
// Remove Word: Remove a word from the dictionary.
// Additional items

// Create unit tests to showcase every functionality.
// Assume the dictionary would work in a concurrent environment.

public class Dictionary {
    private Set<String> words;
    
    public Dictionary() {
        words = new HashSet<>();    
    }

    public void Add(String word) {
        words.add(word);
    }

    public boolean Contains(String word) {
        return words.contains(word);
    }

    public Dictionary Prefix(String prefix) {
        Dictionary d = new Dictionary();
        for (String word : words) {
            if (word.contains(prefix)) {
                d.Add(word);
            }
        }

        return d;
    }
}
