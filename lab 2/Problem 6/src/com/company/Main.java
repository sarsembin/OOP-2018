package com.company;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public String inWords(int number){
        String s = "" + number;
        String nums[] = {"and", "one", "two", "three", "four", "five", "six","seven", "eight", "nine"};
        String nums1[] = {"and", "ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String deci[] = {"hundred", "thousands", "thousand"};
        List <String> ans = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--){
            int n = s[i] - '0';
            if (i == (s.length()-1) - 3){
                ans.add(deci[0]);
            }

            ans.add(nums[n]);

        }
        return s;
    }
    public static void main(String[] args) {

    }
}
