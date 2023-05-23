package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private class Node {
        Node(K k, V v) {
            key = k;
            val = v;
        }
        K key;
        V val;
        Node left, right;
    }

    public BSTMap() {
        this.clear();
    }

    private Node root;

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    private V getHelper(Node node, K key) {
        if (node == null) return null;

        if (key.compareTo(node.key) == 0) return node.val;
        else if (key.compareTo(node.key) > 0) return getHelper(node.right, key);
        else return getHelper(node.left, key);
    }

    @Override
    public V get(K key) {
        return getHelper(root, key);
    }

    private boolean containsKeyHelper(Node node, K key) {
        if (node == null) return false;

        if (key.compareTo(node.key) == 0) return true;
        else if (key.compareTo(node.key) > 0) return containsKeyHelper(node.right, key);
        else return containsKeyHelper(node.left, key);
    }

    @Override
    public boolean containsKey(K key) {
        return containsKeyHelper(root, key);
    }

    private void sizeHelper() {
        size++;
    }

    private Node putHelper(Node node, K key, V value) {
        if (node == null) {
            sizeHelper();
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.val = value;
        } else if (key.compareTo(node.key) > 0) {
            node.right = putHelper(node.right, key, value);
        } else {
            node.left = putHelper(node.left, key, value);
        }

        return node;
    }

    @Override
    public void put(K key, V value) {
        root = putHelper(root, key, value);
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public void putInOrderHelper(Node node) {
        if (node.left != null) {
            putInOrderHelper(node.left);
        }
        System.out.print(node.val + " ");
        if (node.right != null) {
            putInOrderHelper(node.right);
        }
    }

    public void printInOrder() {
        if (root == null) return;
        putInOrderHelper(root);
    }
}
