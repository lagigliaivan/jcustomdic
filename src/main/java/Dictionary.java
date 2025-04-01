import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Create unit tests to showcase every functionality.
// Assume the dictionary would work in a concurrent environment.

public class Dictionary {
    private final HashSet<String> words;
    private final Lock lock;

    public Dictionary() {
        words = new HashSet<>();
        lock = new ReentrantLock();
    }

    public void Add(String word) {
        try{
            lock.lock();
            words.add(word);
        } finally {
            lock.unlock();
        }
    }

    public boolean Contains(String word) {
        return words.contains(word);
    }

    public Dictionary Prefix(String prefix) {
        Dictionary d = new Dictionary();

        try{ 
            lock.lock();
            
            for (String word : words) {
                if (word.contains(prefix)) {
                    d.Add(word);
                }
            }
        }   finally {
            lock.unlock();
        }

        return d;
    }

    public void Remove(String word) {
        try {
            lock.lock();
            words.remove(word);
        } finally {
            lock.unlock();
        }
    }
}
