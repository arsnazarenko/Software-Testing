package com.arsnaz.testing.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BTreeTest {

    private BTree bTree;

    @BeforeEach
    void setUp() {
        bTree = new BTree(2);

    }

    private int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private void insertAndFind(int key) {
        bTree.insert(key);
        BTreeNode node = bTree.search(key);
        Assertions.assertTrue(keyIsFound(key, node));
    }

    private boolean keyIsFound(int key, BTreeNode node) {
        return Arrays.stream(node.getKeys()).anyMatch(k -> k == key);
    }

    @Test
    public void changeTreeAndSizeCheck() {
        bTree.insert(1);
        assertEquals(bTree.length(), 1L);
        bTree.insert(2);
        bTree.insert(3);
        assertEquals(bTree.length(), 3L);
        bTree.remove(1);
        bTree.remove(2);
        bTree.remove(3);
        assertEquals(bTree.length(), 0L);
    }

    @Test
    void changeTreeAndSearchCheck() {
        insertAndFind(1);
        insertAndFind(2);
        insertAndFind(3);
        insertAndFind(123);
        insertAndFind(222);
        insertAndFind(6);
        insertAndFind(8);
        insertAndFind(7);

        bTree.remove(1);
        Assertions.assertNull(bTree.search(1));
        bTree.remove(2);
        Assertions.assertNull(bTree.search(2));
        bTree.remove(3);
        Assertions.assertNull(bTree.search(3));
        bTree.remove(6);
        Assertions.assertNull(bTree.search(6));
        bTree.remove(7);
        Assertions.assertNull(bTree.search(7));
        bTree.remove(123);
        Assertions.assertNull(bTree.search(123));
        bTree.remove(8);
        Assertions.assertNull(bTree.search(8));
        bTree.remove(222);
        Assertions.assertNull(bTree.search(222));
    }

    @Test
    void emptyTreeSearchCheck() {
        Assertions.assertNull(bTree.search(123));
        Assertions.assertNull(bTree.search(0));
        Assertions.assertNull(bTree.search(-1));
    }

    @Test
    void removeCheck() {
        assertEquals("[]", bTree.traverse().toString());
        List<Integer> keys = new ArrayList<>();
        for(long i = 0; i < 50; ++i) {
            int randomInt = getRandomInt(1, 500);
            keys.add(randomInt);
            bTree.insert(randomInt);
        }
        for(Integer e : keys) {
            bTree.remove(e);
        }
        assertEquals("[]", bTree.traverse().toString());
    }

    @Test
    void removeAllCheck() {
        assertEquals("[]", bTree.traverse().toString());
        for(long i = 0; i < 50; ++i) {
            int randomInt = getRandomInt(1, 500);
            bTree.insert(randomInt);
        }
        bTree.removeAll();
        assertEquals("[]", bTree.traverse().toString());
    }


    @Test
    void changeAndCheckElements() {
        bTree.insert(1);
        assertEquals(bTree.search(1).getKeys()[0],1);
        bTree.insert(3);
        bTree.insert(7);
        bTree.insert(10);
        bTree.insert(11);
        bTree.insert(4);
        bTree.insert(5);
        bTree.insert(2);
        bTree.insert(12);
        bTree.insert(6);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 10, 11, 12]", bTree.traverse().toString());
        bTree.remove(3);
        assertEquals("[1, 2, 4, 5, 6, 7, 10, 11, 12]", bTree.traverse().toString());
        bTree.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", bTree.traverse().toString());
        bTree.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", bTree.traverse().toString());
        bTree.insert(3);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12]", bTree.traverse().toString());
        bTree.insert(55);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12, 55]", bTree.traverse().toString());
        bTree.insert(555);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12, 55, 555]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[2, 3, 5, 6, 7, 10, 11, 12, 55, 555]", bTree.traverse().toString());
        bTree.remove(555);
        assertEquals("[2, 3, 5, 6, 7, 10, 11, 12, 55]", bTree.traverse().toString());
    }

    @Test
    void changeTreeWithRepeatedKeys() {
        bTree.insert(1);
        bTree.insert(1);
        bTree.insert(1);
        bTree.insert(1);
        bTree.insert(1);
        assertEquals("[1, 1, 1, 1, 1]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[1, 1, 1, 1]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[1, 1, 1]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[1, 1]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[1]", bTree.traverse().toString());
        bTree.remove(1);
        assertEquals("[]", bTree.traverse().toString());
    }


}
