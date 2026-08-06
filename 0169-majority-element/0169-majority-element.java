class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
        if(hm.containsKey(nums[i])){
            hm.put(nums[i],hm.get(nums[i])+1);
        }
        else{
        hm.put(nums[i],1);
        }
    }
    for(int num:hm.keySet()){
        if(hm.get(num)>n/2){
            return num;
        }

    }
    return -1;
    }
   
}