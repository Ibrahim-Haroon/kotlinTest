package com.example

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.test.*


class LinkedListTest {

    @Test
    fun `test LinkedList isEmpty`() {
        val linkedList = mockk<LinkedList<Int>>()

        every { linkedList.isEmpty() } returns true

        assertTrue(linkedList.isEmpty())
        verify { linkedList.isEmpty() }
    }

    @Test
    fun `test LinkedList push and peek`() {
        val linkedList = mockk<LinkedList<Int>>()

        every { linkedList.add(any()) } answers { }
        every { linkedList.peek() } returns 42

        linkedList.add(42)
        assertEquals(42, linkedList.peek())

        verify { linkedList.add(42) }
        verify { linkedList.peek() }
    }

    @Test
    fun `test LinkedList peek throws exception`() {
        val linkedList = mockk<LinkedList<Int>>()

        every { linkedList.peek() } throws Exception("Empty")

        val exception = assertFailsWith<Exception> {
            linkedList.peek()
        }

        assertEquals("Empty", exception.message)
        verify { linkedList.peek() }
    }

    @Test
    fun `test LinkedList delete`() {
        val linkedList = mockk<LinkedList<Int>>()

        every { linkedList.delete() } returns Unit
        assertEquals(Unit, linkedList.delete())
        verify { linkedList.delete() }
    }
}
