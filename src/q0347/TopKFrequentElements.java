package q0347;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
public class TopKFrequentElements {
	/**
	给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

	示例 1:
	
	输入: nums = [1,1,1,2,2,3,3,3,4], k = 2
	输出: [1,2]
	示例 2:
	
	输入: nums = [1], k = 1
	输出: [1]
	 */
	public static List<Integer> topKFrequent1(int[] nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0) return res;
		// 使用字典，统计每个元素出现的次数，元素为key，元素出现的次数为value
		final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num : nums){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
		}
		// 遍历map，用最小堆保存频率最大的k个元素
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
		});
		
		for(Integer key: map.keySet()){
			if(queue.size()<k){
				queue.add(key);
			}else if(map.get(key) > map.get(queue.peek()) ){
				queue.remove();
				queue.add(key);
			}
		}
		// 取出最小堆中的元素
		while(!queue.isEmpty()){
			res.add(queue.remove());
		}
		return res;
    }
	
	public static List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList();
        // 使用字典，统计每个元素出现的次数，元素为key，元素出现的次数为value
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
               map.put(num, map.get(num) + 1);
             } else {
                map.put(num, 1);
             }
        }
        
        //桶排序
        //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length+1];
        for(int key : map.keySet()){
            // 获取出现的次数作为下标
            int i = map.get(key);
            if(list[i] == null){
               list[i] = new ArrayList();
            } 
            list[i].add(key);
        }
        
        // 倒序遍历数组获取出现顺序从大到小的排列
        for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
            if(list[i] == null) continue;
            res.addAll(list[i]);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3,3,3,4,5};
		int k = 3;
		List<Integer> res = topKFrequent1(nums, k);
		System.out.println(res);
	}
}
