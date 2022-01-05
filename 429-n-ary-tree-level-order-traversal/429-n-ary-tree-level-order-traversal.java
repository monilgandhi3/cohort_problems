/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        // start with root
        // maintain list or height map
        // add all the children to queue and to the result with the correct height map
        // when processing the current element from the queue, how to know the height. 
            // check the map. this could be a set. but set is unordered. so output will be off.
            // need to maintain only current and next set. 
        // another option is to poll the list until current level. 
            // for instance in the beginning we will have 3,2,4. This is the current level. We visit all the child nodes till we empty the queue. Maintain a separate list. and then insert the list into the queue. This is bit more time complexity
        // keep processing till no item in queue
        // return height map
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(root == null) {
            return results;
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        HashSet<Node> currentLevel = new HashSet<>();
        queue.add(root);
        currentLevel.add(root);
        HashSet<Node> nextLevel = new HashSet<>();
        
        List<Integer> currentLevelResult = new ArrayList<>();
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if(nextLevel.contains(currentNode)) {
                // we have reached the end of the level. add the current list to result. create new list
                results.add(currentLevelResult);
                currentLevelResult = new ArrayList<>();
                
                // reset current level and next level
                currentLevel = nextLevel;
                nextLevel = new HashSet<>();
            }
            
            currentLevelResult.add(currentNode.val);
            currentLevel.remove(currentNode);
            // add all the children
            nextLevel.addAll(currentNode.children);
            queue.addAll(currentNode.children);
        }
        
        results.add(currentLevelResult);
        return results;
    }
}