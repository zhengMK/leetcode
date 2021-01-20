// Turns out that priority queue is not needed.
// When meet a rest name with smaller index sum than the smallest, we clear the list, then add the new rest name into it.
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map_lst1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map_lst1.put(list1[i], i);
        
        List<String> lst = new LinkedList<>();
        int smallest = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < list2.length; i++){
            if (map_lst1.containsKey(list2[i])) {
                sum = map_lst1.get(list2[i]) + i;
                if (sum < smallest) {
                    lst.clear();
                    lst.add(list2[i]);
                    smallest = sum;
                } else if (sum == smallest) {
                    lst.add(list2[i]);
                }
            }
        }
        return lst.toArray(new String[0]);
    }
}