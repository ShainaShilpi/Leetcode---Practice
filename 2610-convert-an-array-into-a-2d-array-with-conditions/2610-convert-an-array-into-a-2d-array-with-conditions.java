class Solution {
  public List<List<Integer>> findMatrix(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int[] count = new int[nums.length + 1];

    for (final int num : nums) {
      if (++count[num] > ans.size())
        ans.add(new ArrayList<>());
      ans.get(count[num] - 1).add(num);
    }

    return ans;
  }
}