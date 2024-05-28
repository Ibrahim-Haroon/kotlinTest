package com.example

class LinkedList<T> {
    private var head: Node<T>? = null
    private var size: Int = 0;

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun add(`val`: T) {
        if (isEmpty()) {
            head = Node(`val`)
            size++;
            return
        }

        val nodeToInsert = Node(`val`);
        nodeToInsert.next = head
        head = nodeToInsert
        size++
    }


    fun contains(`val`: T): Boolean {
        var temp = head

        while (temp != null) {
            if (temp.`val` == `val`)
                return true
            temp = temp.next
        }

        return false
    }


    fun peek(): T {
        if (head == null) {
            throw Exception("Empty")
        }

        return head!!.`val`
    }


    fun delete() {
        if (isEmpty()) {
            return
        }

        head = head?.next
        size--
    }
}
