package com.soten.test.jguen

import java.util.EmptyStackException

class MyStack<T> {

    private val elements = mutableListOf<T>()

    fun push(item: T) {
        elements.add(item)
    }

    fun isEmpty(): Boolean {
        return elements.isEmpty()
    }

    fun pop(): T {
        if (elements.isEmpty()) {
            throw EmptyStackException()
        }
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T {
        if (elements.isEmpty()) {
            throw EmptyStackException()
        }
        return elements[elements.size - 1]
    }

    fun size(): Int {
        return elements.size
    }
}