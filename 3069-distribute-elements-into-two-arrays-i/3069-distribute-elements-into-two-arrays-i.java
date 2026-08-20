class Solution {
    public int[] resultArray(int[] nums) {
   Stack<Integer> ft=new Stack<>();
    Stack<Integer> sd=new Stack <>();
     ft.push(nums[0]);
     sd.push(nums[1]);
     for(int i=2;i<nums.length;i++){
        if(ft.peek()>sd.peek()){
            ft.push(nums[i]);
        }
        else{
            sd.push(nums[i]);
        }
     }
    
     int idx=nums.length-1;


     while(sd.size()>0){
nums[idx]=sd.pop();
idx--;

     }
     while(ft.size()>0){
        nums[idx]=ft.pop();
        idx--;
     }
     return nums;

    }
}