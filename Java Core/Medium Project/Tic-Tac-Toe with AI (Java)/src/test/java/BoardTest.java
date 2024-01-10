package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    char[][] tic;
    char tm;
    @BeforeEach
    void setUp() {
        tm = 'X';
    }
    @Test
    void statusCheckDraw() {
        tic = new char[][] {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', 'X', 'O'},
        };
        assertTrue(Board.statusCheck(tic, tm));
    }
    @Test
    void statusCheckWin() {
        tic = new char[][] {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'O', 'X', ' '},
        };
        assertTrue(Board.statusCheck(tic, tm));
    }
    @Test
    void statusCheck() {
        tic = new char[][] {
                {'X', 'X', 'O'},
                {'O', 'O', 'X'},
                {'X', ' ', 'O'},
        };
        assertFalse(Board.statusCheck(tic, tm));
    }
}
