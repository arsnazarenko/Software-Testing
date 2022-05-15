package com.arsnaz.testing.task2;

import java.util.List;

public class BTree {
    private BTreeNode root;
    private final int MinDeg;

    public BTree(int deg) {
        this.root = null;
        this.MinDeg = deg;
    }

    public List<Integer> traverse(){
        if (root != null){
            return root.traverse();
        } else {
            return List.of();
        }
    }

    public BTreeNode search(int key){
        return root == null ? null : root.search(key);
    }


    public void insert(int key){
        if (root == null){
            root = new BTreeNode(MinDeg, true);
            root.getKeys()[0] = key;
            root.setNum(1);
        }
        else {
            if (root.getNum() == 2 * MinDeg - 1){
                BTreeNode s = new BTreeNode(MinDeg, false);
                s.getChildren()[0] = root;
                s.splitChild(0,root);
                int i = 0;
                if (s.getKeys()[0]< key)
                    i++;
                s.getChildren()[i].insertNotFull(key);
                root = s;
            }
            else {
                root.insertNotFull(key);
            }
        }
    }

    public void remove(int key){
        if (root == null){
            return;
        }
        root.remove(key);
        if (root.getNum() == 0){
            if (root.isLeaf())
                root = null;
            else
                root = root.getChildren()[0];
        }
    }

    public long length() {
        return traverse().size();
    }

    public void removeAll() {
        List<Integer> keys = traverse();
        for(Integer k: keys) {
            remove(k);
        }
    }
}