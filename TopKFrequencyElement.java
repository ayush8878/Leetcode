import java.util.*;
class Pair implements Comparable<Pair>
{
    public int key;
    public int value;

    public Pair(int key,int value)
    {
        this.key = key;
        this.value = value;
    }

    // Comparable contract for reverse sort
    public int compareTo(Pair p)
    {
        return p.key - this.key;
    }

}
public class TopKFrequencyElement
{
    public int[] topKFrequent(int[] nums, int k)
    {
// create heap with pair
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();

        Map<Integer,Integer> countMap = new HashMap<>();

        // Prepare a map of frequenceies of number

        for(int num:nums)
        {
            // update the count by 1 if already exists otherwis add
            if(countMap.containsKey(num))
            {
                int existingValue = countMap.get(num);
                countMap.put(num,existingValue+1);
            }
            else
            {
                countMap.put(num,1);
            }
            //countMap.put(num,countMap.getOrDefault(countMap.get(num),0)+1);
            System.out.println("nu:"+num+"count:"+countMap.get(num));
        }
        // iterate over map and offer pair to heap
        for(Map.Entry<Integer,Integer> entry : countMap.entrySet())
        {
            // add pairs with key as count
            heap.offer(new Pair(entry.getValue(),entry.getKey()));
        }
        int[] result = new int[k];
        // poll from heap until k elements have been extracted
        for(int i = 0 ; i< k; i++)
        {
            result[i] = heap.poll().value;
        }
        return result;
    }
}



