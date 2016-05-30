package com.beloglazov.example.tictactoe;

import android.widget.Button;

public class Game {
    public enum EndState {
        WONX, WONO, DRAW, NOEND
    }

    private enum StateX {
        X, O, EMPTY
    }

    private StateX[][] map;
    private boolean isPlayerXGoes, isEnd;
    private int count;

    public Game() {
        map = new StateX[3][3];
        isPlayerXGoes = true;
        isEnd = false;
        count = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                map[i][j] = StateX.EMPTY;
            }

    }

    public int whoGoes() {
        if (isPlayerXGoes) {
            return R.string.playerXgoes;
        } else {
            return R.string.playerOgoes;
        }
    }

    public int step(int x, int y) {
        if (!isEnd && map[x][y] == StateX.EMPTY) {
            if (isPlayerXGoes) {
                map[x][y] = StateX.X;
                isPlayerXGoes = !isPlayerXGoes;
                count++;
                return R.string.X;
            } else {
                map[x][y] = StateX.O;
                isPlayerXGoes = !isPlayerXGoes;
                count++;
                return R.string.O;
            }
        }
        return 0;
    }

    public EndState isEnd() {
        for (int i = 0; i < 3; i++) {
            if (equalsThreeMap(i, 0, i, 1, i, 2)) {
                if (map[i][0].equals(StateX.X)){
                    isEnd = true;
                    return EndState.WONX;
                }
                if (map[i][0].equals(StateX.O)){
                    isEnd = true;
                    return EndState.WONO;
                }
            }
            if (equalsThreeMap(0, i, 1, i, 2, i)) {
                if (map[0][i].equals(StateX.X)){
                    isEnd = true;
                    return EndState.WONX;
                }
                if (map[0][i].equals(StateX.O)){
                    isEnd = true;
                    return EndState.WONO;
                }
            }
        }
        if (equalsThreeMap(0, 0, 1, 1, 2, 2)) {
            if (map[1][1].equals(StateX.X)){
                isEnd = true;
                return EndState.WONX;
            }
            if (map[1][1].equals(StateX.O)){
                isEnd = true;
                return EndState.WONO;
            }
        }
        if (equalsThreeMap(0, 2, 1, 1, 2, 0)) {
            if (map[1][1].equals(StateX.X)){
                isEnd = true;
                return EndState.WONX;
            }
            if (map[1][1].equals(StateX.O)){
                isEnd = true;
                return EndState.WONO;
            }
        }
        if (count == 9) {
            isEnd = true;
            return EndState.DRAW;
        }
        return EndState.NOEND;
    }

    private boolean equalsThreeMap(int x1, int y1, int x2, int y2, int x3, int y3) {
        return map[x1][y1].equals(map[x2][y2]) && map[x1][y1].equals(map[x3][y3]);
    }
}

