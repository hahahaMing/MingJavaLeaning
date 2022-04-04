package com.mldn.listnode;

public class LinkImpl<E> implements ILink<E> {
    private Node<E> root;
    private int count;
    private int foot;
    private Object[] returnData;

    private class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public void addNode(Node<E> newNode) {
            if (this.next == null) {
                this.next = newNode;
            } else {
                this.next.addNode(newNode);
            }
        }

        public void toArrayNode() {
            LinkImpl.this.returnData[LinkImpl.this.foot++] = this.data;
            if (this.next != null) {
                this.next.toArrayNode();
            }
        }

        public E getNode(int index) {
            if (LinkImpl.this.foot == index) {
                return this.data;
            }
            if (this.next != null) {
                LinkImpl.this.foot++;
                return this.next.getNode(index);
            }
            return null;
        }

        public void setNode(int index, E data) {
            if (LinkImpl.this.foot == index) {
                this.data = data;
                return;
            }
            if (this.next != null) {
                LinkImpl.this.foot++;
                this.next.setNode(index, data);
            }
        }

        public boolean containsNode(E data) {
            if (this.data.equals(data)) {
                return true;
            }
            if (this.next != null) {
                return this.next.containsNode(data);
            }
            return false;
        }

        public void removeNode(Node<E> previous, E data) {
            if (this.data.equals(data)) {
                previous.next = this.next;
            } else {
                this.next.removeNode(this, data);
            }
        }
    }

    @Override
    public void add(E e) {
        if (e == null) {
            return;
        }
        Node<E> newNode = new Node<E>(e);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }
        this.foot = 0;
        this.returnData = new Object[this.count];
        this.root.toArrayNode();
        return this.returnData;
    }

    @Override
    public E get(int index) {
        if (index > this.count || index < 0) {
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);
    }

    @Override
    public void set(int index, E data) {
        if (index > this.count || index < 0) {
            return;
        }
        this.foot = 0;
        this.root.setNode(index, data);
    }

    @Override
    public boolean contains(E data) {
        if (this.root == null) {
            return false;
        }
        return this.root.containsNode(data);
    }

    @Override
    public void remove(E e) {
        if (this.contains(e)) {
            if (this.root.data.equals(e)) {
                this.root = this.root.next;
            } else {
                this.root.removeNode(this.root, e);
            }

            this.count--;
        }
    }

    @Override
    public void clean() {
        this.root = null;
        this.count = 0;
    }
}
