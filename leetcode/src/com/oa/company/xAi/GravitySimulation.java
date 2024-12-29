package com.oa.company.xAi;

public class GravitySimulation {
    public static char[][] solution(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Helper function to check inbound
        java.util.function.BiPredicate<Integer, Integer> inBounds = (r,
                c) -> (r >= 0 && r < rows && c >= 0 && c < cols);

        boolean changed = true;
        while (changed) {
            changed = false;
            java.util.List<Move> moves = new java.util.ArrayList<>();
            java.util.Set<Position> explosions = new java.util.HashSet<>();

            // Identify moves and explosions:
            // Traverse bottom-to-top so we don't double-move the same box
            for (int r = rows - 1; r >= 0; r--) {
                for (int c = 0; c < cols; c++) {
                    if (board[r][c] == '#') {
                        int nr = r + 1;
                        int nc = c;
                        if (nr < rows) {
                            if (board[nr][nc] == '-') {
                                // Box can fall down
                                moves.add(new Move(r, c, nr, nc));
                            } else if (board[nr][nc] == '*') {
                                // Box hits obstacle => explosion
                                explosions.add(new Position(nr, nc));
                            }
                            // if it's '#' or out of bounds, do nothing (box stays)
                        }
                    }
                }
            }

            // If we have moves, apply them
            if (!moves.isEmpty()) {
                changed = true;
                // Clear old positions
                for (Move m : moves) {
                    board[m.fromR][m.fromC] = '-';
                }
                // Set new positions
                for (Move m : moves) {
                    board[m.toR][m.toC] = '#';
                }
            }

            // Apply explosions
            if (!explosions.isEmpty()) {
                changed = true;
                // Remove boxes in 3x3 area around each exploding obstacle
                java.util.List<Position> boxesToRemove = new java.util.ArrayList<>();
                for (Position exp : explosions) {
                    for (int rr = exp.r - 1; rr <= exp.r + 1; rr++) {
                        for (int cc = exp.c - 1; cc <= exp.c + 1; cc++) {
                            if (inBounds.test(rr, cc) && board[rr][cc] == '#') {
                                boxesToRemove.add(new Position(rr, cc));
                            }
                        }
                    }
                }

                for (Position rem : boxesToRemove) {
                    board[rem.r][rem.c] = '-';
                }
            }
        }

        return board;
    }

    // Helper classes for clarity
    static class Move {
        int fromR, fromC;
        int toR, toC;

        Move(int fromR, int fromC, int toR, int toC) {
            this.fromR = fromR;
            this.fromC = fromC;
            this.toR = toR;
            this.toC = toC;
        }
    }

    static class Position {
        int r, c;

        Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Position))
                return false;
            Position p = (Position) o;
            return this.r == p.r && this.c == p.c;
        }

        @Override
        public int hashCode() {
            return r * 31 + c;
        }
    }

    // For testing
    public static void main(String[] args) {
        char[][] board = {
                { '#', '-', '#', '#', '*' },
                { '#', '-', '-', '#', '#' },
                { '-', '#', '-', '#', '-' },
                { '-', '-', '#', '-', '#' },
                { '#', '*', '-', '-', '-' },
                { '-', '-', '*', '#', '-' }
        };

        char[][] result = solution(board);

        for (char[] row : result) {
            System.out.println(java.util.Arrays.toString(row));
        }
        // Expected:
        // ['-','-','-','-','*']
        // ['-','-','-','-','-']
        // ['-','-','-','-','-']
        // ['-','-','-','-','-']
        // ['-','*','-','-','#']
        // ['#','-','*','-','#']
    }
}
