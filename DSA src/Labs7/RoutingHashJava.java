package Labs7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntrance<K extends Comparable<K>, E> implements Comparable<K> {

    K key;
    E value;

    public MapEntrance(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        @SuppressWarnings("unchecked")
        MapEntrance<K, E> other = (MapEntrance<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }


    @Override
    public String toString() {
        return element.toString();
    }
}


class CBHT<K extends Comparable<K>, E> {
    private SLLNode<MapEntrance<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        buckets = (SLLNode<MapEntrance<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntrance<K, E>> search(K targetKey) {
        int b = hash(targetKey);
        for (SLLNode<MapEntrance<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntrance<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {
        MapEntrance<K, E> newEntry = new MapEntrance<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntrance<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntrance<K, E>) curr.element).key)) {
                curr.element = newEntry;
                return;
            }
        }
        buckets[b] = new SLLNode<MapEntrance<K, E>>(newEntry, buckets[b]);
    }


    public void delete(K key) {
        int b = hash(key);
        for (SLLNode<MapEntrance<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntrance<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntrance<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }
}

public class RoutingHashJava {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CBHT<String, String[]> hash = new CBHT<>(2 * n);

        for (int i = 0; i < n; i++) {
            String inputInterface = br.readLine();
            String[] netAddresses = br.readLine().split(",");
            hash.insert(inputInterface, netAddresses);
        }

        int numAttempts = Integer.parseInt(br.readLine());

        for (int i = 0; i < numAttempts; i++) {
            String inputInterface = br.readLine();
            String staticIPAddress = br.readLine();

            SLLNode<MapEntrance<String, String[]>> entry = hash.search(inputInterface);

            if (entry == null) {
                System.out.println("ne postoi");
                continue;
            }

            String[] staticRoutes = entry.element.value;
            boolean condition = false;

            for (String route : staticRoutes) {
                if (staticIPAddress.startsWith(route.substring(0, route.lastIndexOf('.')))) {
                    condition = true;
                    break;
                }
            }

            System.out.println(condition ? "postoi" : "ne postoi");
        }
    }
}