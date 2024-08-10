package com.leetcode;

public class RemovesSpaces {
    private static String removeSpacesInString(String s) {
        char ch[] = s.toCharArray();
        int n, index, left, right;
        index = 0;
        n = s.length();
        left = 0;
        right = n - 1;
        while (left <= right && ch[left] == ' '){
            left++;
        }
        while (right >= left && ch[right] == ' '){
            right--;
        } 
        while(left <= right){
            if(ch[left] == ' ' && left+1 <= right && ch[left+1] == ' '){
            }
            else{
                ch[index++] = ch[left];
            }
            left++;
        }

        return String.valueOf(ch, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(removeSpacesInString("the sky is blue"));
        System.out.println(removeSpacesInString("  hello world  $"));
        System.out.println(removeSpacesInString("a good   example"));
    }
}
