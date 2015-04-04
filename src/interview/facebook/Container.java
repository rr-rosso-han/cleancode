package interview.facebook;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by jiahan on 1/10/15.
 */
public class Container {
    private Set<Integer> set = new HashSet<Integer>();

    public boolean add(int x) {
        if (set.contains(x)) {
            throw new IllegalArgumentException("input value already exist");
        }
        return set.add(x);
    }

    public void remove(int x) {
        if (!set.contains(x)) {
            throw new IllegalArgumentException("input value does not exist");
        }
        set.remove(x);
    }

    private int size() {
        return set.size();
    }

    public int choose() {
        int size = size();
        Integer[] array = (Integer[]) set.toArray();
        return array[new Random().nextInt(size)];
    }

}
