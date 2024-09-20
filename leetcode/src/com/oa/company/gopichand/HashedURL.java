package com.oa.company.gopichand;

public class HashedURL {
    public String getHashedUrl(String url, String hash_string, int k) {
        int n = url.length(), m = hash_string.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i += k) {
            int hashValue = 0;
            for (int j = i; j < Math.min(n, i + k); j++) {
                char c = url.charAt(j);
                int val = 0;
                if (c >= 'a' && c <= 'z') {
                    val = c - 'a';
                } else if (c == ':') {
                    val = 26;
                } else if (c == '/') {
                    val = 27;
                } else if (c == '.') {
                    val = 28;
                }
                hashValue += val;
            }
            int index = getHashCharIndex(hashValue, m);
            result.append(hash_string.charAt(index));
        }

        return result.toString();
    }

    private int getHashCharIndex(int value, int m) {
        return (value % m);
    }

    public static void main(String[] args) {
        HashedURL hashedURL = new HashedURL();
        System.out.println(hashedURL.getHashedUrl("https://xyz.com", "pqrst", 4));
    }

}
