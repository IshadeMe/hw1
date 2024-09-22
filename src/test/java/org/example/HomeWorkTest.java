package org.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class HomeWorkTest {

    private final HomeWork homeWork = new HomeWork();

    @Test
    void partitionLess_4() {
        var node = new Node<>(1);
        node.add(2).add(3).add(4).add(5);
        var pred = (Predicate<Integer>) (x) -> x < 4;
        var result = homeWork.partitionBy(node, pred);
        assertEquals(3, result);
    }

    @Test
    void partitionLess_0() {
        var node = new Node<>(1);
        node.add(2).add(3).add(4).add(5);
        var pred = (Predicate<Integer>) (x) -> x < 0;
        var result = homeWork.partitionBy(node, pred);
        assertEquals(0, result);
    }

    @Test
    void findValue() {
        var node = new Node<>(10);
        node.add(20).add(30).add(40).add(50);
        var result = homeWork.findNthElement(node, 3);
        assertEquals(30, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void findNth(int pos) {
        var node = new Node<>(1);
        node.add(2).add(3).add(4).add(5);
        var result = homeWork.findNthElement(node, pos);
        assertEquals(pos, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 6})
    void findOutOfBound() {
        var node = new Node<>(1);
        node.add(2).add(3).add(4).add(5);
        var result = homeWork.findNthElement(node, 6);
        assertNull(result);
    }

}