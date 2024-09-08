package com.leetcode.easy;

public class LatestTimeByReplacingHiddenDigits {
    public String maximumTime(String time) {
        /*
         * if(s[0]=='?') s[0]=(s[1]=='?'|| s[1]<='3')?'2':'1';
         * if(s[1]=='?') s[1]=s[0]=='2'?'3':'9';
         * if(s[3]=='?') s[3]='5';
         * if(s[4]=='?') s[4]='9';
         */
        char[] ch = time.toCharArray();
        if (ch[0] == '?') {
            ch[0] = (ch[1] == '?' || ch[1] <= '3') ? '2' : '1';
        }

        if (ch[1] == '?') {
            ch[1] = (ch[0] == '2') ? '3' : '9';
        }

        if (ch[3] == '?') {
            ch[3] = '5';
        }
        if (ch[4] == '?') {
            ch[4] = '9';
        }

        return new String(ch);
    }
}
