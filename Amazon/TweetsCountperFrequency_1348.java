import java.util.*;
class TweetCounts {
    
    private class TreeNode {
        
        private int val;
        private TreeNode left;
        private TreeNode right;
        
        private TreeNode(int data) {
            val = data;
            left = null;
            right = null;
        }
        
    }
    
    private Map<String, TreeNode> map;

    public TweetCounts() {
        map = new HashMap<>();
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        else if (root.val <= val) {
            root.right = insert(root.right, val);
        }
        else {
            root.left = insert(root.left, val);
        }
        return root;
    }
    
    public void recordTweet(String name, int time) {
        TreeNode root = map.get(name);
        root = insert(root, time);
        map.put(name, root);
    }
    
    private int treverse(TreeNode root, int l, int r) {
        if (root == null || l >= r) {
            return 0;
        }
        if (root.val <= l) {
            int add = root.val == l ? 1 : 0;
            return add + treverse(root.right, l, r);
        }
        if (root.val >= r) {
            return treverse(root.left, l, r);
        }
        return 1 + treverse(root.left, l, r) + treverse(root.right, l, r);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String name, int start, int end) {
        int d = 0;
        TreeNode root = map.get(name);
        List<Integer> res = new ArrayList<>();
        if (freq.equals("minute")) {
            d = 60;
        }
        else if (freq.equals("hour")) {
            d = 3600;
        }
        else {
            d = 86400;
        }
        while (start + d <= end) {
            int count = treverse(root, start, start + d);
            start = start + d;
            res.add(count);
        }
        if (start <= end) {
            int count = treverse(root, start, end + 1);
            res.add(count);
            start = end + 1;
        }
        return res;
    }
    
}