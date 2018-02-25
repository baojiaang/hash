package lintcode;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if(S==null || S.length()==0)
            return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<T.length();i++)
        {
            if(map.containsKey(T.charAt(i)))
            {
                map.put(T.charAt(i),map.get(T.charAt(i))+1);
            }
            else
            {
                map.put(T.charAt(i),1);
            }
        }
        int left = 0;
        int count = 0;
        int minLen = S.length()+1;
        int minStart = 0;
        for(int right=0; right<S.length();right++)
        {
            if(map.containsKey(S.charAt(right)))
            {
                map.put(S.charAt(right),map.get(S.charAt(right))-1);
                if(map.get(S.charAt(right))>=0)
                {
                    count++;
                }
                while(count == T.length())
                {
                    if(right-left+1<minLen)
                    {
                        minLen = right-left+1;
                        minStart = left;
                    }
                    if(map.containsKey(S.charAt(left)))
                    {
                        map.put(S.charAt(left), map.get(S.charAt(left))+1);
                        if(map.get(S.charAt(left))>0)
                        {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen>S.length())
        {
            return "";
        }
        return S.substring(minStart,minStart+minLen);
    }
//    这道题的要求是要在O(n)的时间度里实现找到这个最小窗口字串，那么暴力搜索Brute Force肯定是不能用的，我们可以考虑哈希表，其中key是T中的字符，value是该字符出现的次数。
//
//            - 我们最开始先扫描一遍T，把对应的字符及其出现的次数存到哈希表中。
//
//            - 然后开始遍历S，遇到T中的字符，就把对应的哈希表中的value减一，直到包含了T中的所有的字符，纪录一个字串并更新最小字串值。
//
//            - 将子窗口的左边界向右移，略掉不在T中的字符，如果某个在T中的字符出现的次数大于哈希表中的value，则也可以跳过该字符。
}
