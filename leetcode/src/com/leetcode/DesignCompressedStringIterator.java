package com.leetcode;

import java.util.ArrayList;

public class DesignCompressedStringIterator {
    class StringIterator {
        private int unCompressedStringLength;
        private int unCompressedStringIndex;
        private ArrayList<CustomPair> unCompressedString;

        public StringIterator(String compressedString) {
            int n = compressedString.length();
            unCompressedStringIndex = 0;
            int charIndex = 0;
            long curCharCount = 0;
            for (int i = 0; i < n; i++) {
                if (Character.isLetter(compressedString.charAt(i))) {
                    if (curCharCount > 0) {
                        unCompressedString.add(new CustomPair(compressedString.charAt(charIndex), curCharCount));
                        curCharCount = 0;
                    }
                    charIndex = i;
                } else {
                    curCharCount = curCharCount * 10 + (compressedString.charAt(i) - '0');
                }
            }
            if (curCharCount > 0) {
                unCompressedString.add(new CustomPair(compressedString.charAt(charIndex), curCharCount));
            }
            for (int i = 0; i < unCompressedString.size(); i++) {
                unCompressedStringLength += unCompressedString.get(i).getCount();
            }

        }

        public char next() {
            if (unCompressedStringIndex >= unCompressedStringLength) {
                return ' ';
            }
            return unCompressedString.get(unCompressedStringIndex++).getCh();
        }

        public boolean hasNext() {
            return unCompressedStringIndex < unCompressedStringLength;
        }
    }

    class CustomPair {
        private char ch;
        private long count;

        public CustomPair(char ch, long count) {
            this.ch = ch;
            this.count = count;
        }

        public char getCh() {
            return ch;
        }

        public void setCh(char ch) {
            this.ch = ch;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }
    }
}
