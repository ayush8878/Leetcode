public class RemoveElementsFromArray {
    public int removeElement(int[] nums, int val)
    {
        int removedCount = 0;
        int last = nums.length -1;
        int i=0;
        while(i<=last)
        {
            if(nums[i] == val)
            {
                if(nums[last] != val)
                {
                    nums[i] = nums[last];
                    i++;
                }
                last--;
                removedCount++;
            }
            else
            {
                i++;
            }
        }
        return nums.length-removedCount;
    }
}
