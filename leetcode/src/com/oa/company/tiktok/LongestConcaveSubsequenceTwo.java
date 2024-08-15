package com.oa.company.tiktok;

import java.util.*;

class SegTree {
    private int[] T;
    private int N;

    public SegTree(int sz) {
        this.N = sz;
        T = new int[2 * N];
        Arrays.fill(T, 0);
    }

    public void add(int p) {
        T[p += N] = 1;

        for (; p > 1; p >>= 1) {
            T[p >> 1] = T[p] + T[p ^ 1];
        }
    }

    public int get(int a, int b) {
        int res = 0;
        for (a += N, b += N + 1; a < b; a >>= 1, b >>= 1) {
            if ((a & 1) == 1)
                res += T[a++];
            if ((b & 1) == 1)
                res += T[--b];
        }
        return res;
    }
}

public class LongestConcaveSubsequenceTwo {

    public static void main(String[] args) {
        int[] A = { 4, 2, 6, 5, 3, 1 };
        int N = A.length;

        Map<Integer, Integer> mp = new HashMap<>(); // stores the index of value
        for (int i = 0; i < N; i++) {
            mp.put(A[i], i);
        }

        TreeSet<Integer> zero = new TreeSet<>(); // contains the index of unfilled values
        for (int i = 0; i < N; i++) {
            zero.add(i);
        }

        SegTree st = new SegTree(N);
        int res = Math.min(2, N);

        for (int i = 0; i < N; i++) {
            int in = mp.getOrDefault(i, 0);

            zero.remove(in);
            st.add(in);

            if (zero.size() < 2)
                continue;

            int a = zero.first(); // first unfilled position
            int b = zero.last(); // last unfilled position

            res = Math.max(res, 2 + st.get(a, b));
        }

        System.out.println(res);
    }
}
