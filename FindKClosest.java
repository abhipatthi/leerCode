class FindKClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int crossOver = searchPostion(arr, 0, arr.length-1, x);
        List<Integer> result = new ArrayList<Integer>();
        int left = crossOver;
        int right =crossOver +1;
        int count =0;
        while(left >=0 && right <arr.length && count < k) {
            if(x - arr[left] > arr[right]-x) {
                result.add(arr[right]);
                right++;
            }else {
                result.add(arr[left]);
                left--;
            }
            count++;
        }
        // If there are no more elements on right side, then 
        // print left elements 
        while (count < k && left >= 0) 
        { 
            result.add(arr[left]);
            left--;
            count++; 
        } 
  
  
        // If there are no more elements on left side, then 
        // print right elements 
        while (count < k && right < arr.length-1) 
        { 
            result.add(arr[right]);
            right++;
            count++; 
        } 
       
        Collections.sort(result);
        return result;
    }
    
    
    public int searchPostion(int[] arr, int low, int high, int x) {
        
        if(x > arr[high]) return high;
        if(x < arr[low]) return low;
        int mid = (high + low)/2;
        //System.out.println(mid);
        if(arr[mid] == x) {
            return mid;
        }
        
        if(arr[mid] > x) 
            return  searchPostion(arr, low, mid-1, x);
        else 
            return searchPostion(arr, mid+1, high, x);
       
    }
}