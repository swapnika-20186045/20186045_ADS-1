/**
 * Binary Search Tree.
 */
import java.util.Scanner;
/**
 * Class for book details.
 */
class Book implements Comparable {
    /**
     * variable declaration.
     */
    private String name;
    /**
     * variable declaration.
     */
    private String author;
    /**
     * variable declaration.
     */
    private float price;
    /**
     * Constructs the object.
     *
     * @param      name    The name
     * @param      author  The author
     * @param      price   The price
     */
    Book(final String name,
                final String author, final float price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Gets the author.
     *
     * @return     The author.
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return this.price;
    }
    /**
     * compare to method that returns integer.
     *
     * @param      object  The object
     *
     * @return  integer.
     */
    public int compareTo(final Object object) {
        Book that = (Book) object;
        return this.name.compareTo(that.name);
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return getName() + ", " + getAuthor() + ", " + getPrice();
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * variable declaration.
     */
    private Node root;
    /**
     * Class for node.
     */
    private final class Node {
        /**
         * variable declaration.
         */
        private Book key;
        /**
         * variable declaration.
         */
        private int value;
        /**
         * variable declaration.
         */
        private Node left;
        /**
         * variable declaration.
         */
        private Node right;
        /**
         * variable declaration.
         */
        private int size;
        /**
         * Constructs the object.
         *
         * @param      key   The key
         * @param      value  The valueue
         * @param s int size
         */
        private Node(final Book key, final int value, final int s) {
            this.key = key;
            this.value = value;
            this.size = s;
            left = null;
            right = null;
        }
    }
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * size method.
     *
     * @return size.
     */
    public int size() {
        return size(root);
    }
    /**
     * overloaded constructor..
     *
     * @param      x Node
     *
     * @return size.
     */
    private int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }
    /**
     * get method.
     * @param      key   The key
     *
     * @return  integer.
     */
    public int get(final Book key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else if (cmp == 0) {
                return x.value;
            }
        }
        return -1;
    }
    /**
     * put method to insert the key, value.
     * @param      key   The key
     * @param      value   The valueue
     */
    public void put(final Book key, final int value) {
        root = put(root, key, value);
    }
    /**
     * overloaded constructor.
     * @param      x   root node.
     * @param      key   The key
     * @param      value   The value
     *
     * @return root
     */
    private Node put(final Node x, final Book key, final int value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else if (cmp == 0) {
            x.value = value;
        }
        return x;
    }
    /**
     * min element.
     * @return minimum.
     */
    public Book min() {
        return min(root).key;
    }
    /**
     * overloaded constructor.
     * @param      x Node
     *
     * @return minimum.
     */
    private Node min(final Node x) {
        if (x.left == null) {
            return x;
        } else {
            return min(x.left);
        }
    }
    /**
     * maximum element.
     * @return maximum.
     */
    public Book max() {
        return max(root).key;
    }
    /**
     * overloaded constructor.
     * @param      x Node
     *
     * @return maximum.
     */
    private Node max(final Node x) {
        if (x.right == null) {
            return x;
        } else {
            return max(x.right);
        }
    }
    /**
     * floor method.
     * @param      key   The key
     *
     * @return  key
     */
    public Book floor(final Book key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     *
     *overloaded constructor.
     * @param      x Node
     * @param      key   The key
     *
     * @return floor.
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * ceiling method.
     * @param      key   The key
     *
     * @return key.
     */
    public Book ceiling(final Book key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * overloaded constructor.
     * @param      x Node
     * @param      key   The key
     *
     * @return     { description_of_the_return_valueue }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
    /**
     * Select Method.
     * @param      k     Integer
     *
     * @return     Book Object
     */
    public Book select(final int k) {
        Node x = select(root, k);
        return x.key;
    }
    /**
     * Select Method.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }
    /**
     * Rank.
     * @param      key   The key
     *
     * @return     {Integer}
     */
    public int rank(final Book key) {
        return rank(key, root);
    }
    /**
     * Method of rank.
     * @param      key   The key
     * @param      x     {Node}
     *
     * @return     {Integer}
     */
    private int rank(final Book key, final Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(key, x.left);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(key, x.right);
        } else {
            return size(x.left);
        }
    }
}
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            switch (tokens[0]) {
            case "put":
                Book obj = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
                bst.put(obj, Integer.parseInt(tokens[2 + 2]));
                break;
            case "get":
                obj = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
                if (bst.get(obj) == -1) {
                    System.out.println("null");
                } else {
                    System.out.println(bst.get(obj));
                }
                break;
            case "max":
                System.out.println(bst.max());
                break;
            case "min":
                System.out.println(bst.min());
                break;
            case "select":
                System.out.println(bst.select(Integer.parseInt(tokens[1])));
                break;
            case "floor":
                obj = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.floor(obj));
                break;
            case "ceiling":
                obj = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[2 + 1]));
                System.out.println(bst.ceiling(obj));
                break;
            default:
                break;
            }
        }
    }
}
