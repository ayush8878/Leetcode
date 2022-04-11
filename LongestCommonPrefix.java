public class LongestCommonPrefix {
    /*Sol1:
     This problem can be solved using the prefix comparision where the prefix
     identified from first 2 srings will get compared to the 3rd one result will get compated to 4th one
     Logic:
     */

    /*
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++)
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
    */

    /*Sol2:
    * Another solution is to perform vertical scan of char before moving to another one
    * and the moment a char did not match we can return , this approach will be helpful when prefix are short
    * Worst case scenario when strings are identical then O(S) where S is sum of len of string
    * */

    /*Sol3: Divide and Concur*/

    /*Sol4: Binary search
    * In binary search we divide string in equal part and then check if that's a prefix for all others strings
    * Once it has been identified that first half is a prefix then remaining half we will divide and the moment
    * and prefix fails then the prev one is ans
    *  */

    /*Sol5: Use a Trie
    * Best solution
    * */
    public String longestCommonPrefix(String[] strs) {
        // handle edge case
        if(strs.length == 1)
        {
            return strs[0];
        }
        // prefix count
        int prefixCount = Integer.MAX_VALUE;
        String base = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            String str = strs[i];
            int temp = 0;
            // compare matching characters
            int maxLen = base.length() < str.length()?base.length():str.length();
            for(int j=0;j<maxLen;j++)
            {
                // break the loop if char does not match
                if(str.charAt(j)!=base.charAt(j))
                {
                    break;
                }
                else
                {
                    temp++;
                }
            }
            // update prefix count
            prefixCount=Math.min(temp,prefixCount);
        }
        return base.substring(0,prefixCount);
    }

}
