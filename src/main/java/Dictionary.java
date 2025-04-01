import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;
// Add Word: Add a word to the dictionary.
// Search Word: Check if a word exists in the dictionary.
// Auto-Complete: Given a prefix, return a list of words that start with that prefix.
// Remove Word: Remove a word from the dictionary.
// Additional items
import java.util.concurrent.locks.Lock;

// Create unit tests to showcase every functionality.
// Assume the dictionary would work in a concurrent environment.

public class Dictionary {
    private HashSet<String> words;
    private Lock lock;

    public Dictionary() {
        words = new HashSet<String>();
        lock = new ReentrantLock();
    }

    public void Add(String word) {
        lock.lock();
        words.add(word);
        lock.unlock();
    }

    public boolean Contains(String word) {
        return words.contains(word);
    }

    public Dictionary Prefix(String prefix) {
        Dictionary d = new Dictionary();

        lock.lock();
        for (String word : words) {
            if (word.contains(prefix)) {
                d.Add(word);
            }
        }
        lock.unlock();

        return d;
    }

    public void Remove(String word) {
        lock.lock();
        words.remove(word);
        lock.unlock();
    }
}
