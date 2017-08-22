package com.inuker.solution;

import java.util.HashMap;

/**
 * Created by dingjikerbo on 16/11/27.
 */

public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * 思路跟Longest Substring With At Most Two Distinct Characters一样，只是给2改成k，要注意k等于0时返回0
     */
    // 耗时9ms
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }

        int[] count = new int[256];
        int distinct = 0, longest = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {
                distinct++;
            }

            for ( ; i < j && distinct > k; ) {
                if (--count[s.charAt(i++)] == 0) {
                    --distinct;
                }
            }

            longest = Math.max(longest, j - i + 1);
        }

        return longest;
    }

}
