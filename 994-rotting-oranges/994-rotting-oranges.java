class Solution {
    public int orangesRotting(int[][] grid) {
        // traverse the grid in BFS manner
        // queue starts with rotten oranges
        // rot oranges until queue is empty
        // replinish the queue with new rotten oranges. repeat
        // rotten can indicate visited
        
        Queue<RottenOrange> rottenQueue = new LinkedList<>();
        int freshOranges = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.println("Checking " + grid[i][j]);
                if(grid[i][j] == 2){
                    rottenQueue.add(new RottenOrange(i, j));
                } else if (grid[i][j] == 1) {
                    ++freshOranges;
                }
            }
        }
        
        List<RottenOrange> justRotten = new ArrayList<>();
        int timeTaken = 0;
        while(!rottenQueue.isEmpty())
        {
            System.out.println("processing queue");
            RottenOrange r = rottenQueue.poll();
            
            // down
            if(r.y+1 < grid[r.x].length && grid[r.x][r.y+1] == 1) {
                System.out.println("Adding down");
                justRotten.add(new RottenOrange(r.x, r.y+1));
                grid[r.x][r.y+1] = 2; 
                --freshOranges;
            }
            
            // left
            if(r.x-1 >= 0 && grid[r.x-1][r.y] == 1) {
                System.out.println("Adding left");
                justRotten.add(new RottenOrange(r.x-1, r.y));
                grid[r.x-1][r.y] = 2; 
                --freshOranges;
            }
            
            // right
            if(r.x+1 < grid.length && grid[r.x+1][r.y] == 1) {
                System.out.println("adding right");
                justRotten.add(new RottenOrange(r.x+1, r.y));
                grid[r.x+1][r.y] = 2;
                --freshOranges;
            }
            
            // up
            if(r.y-1 >= 0 && grid[r.x][r.y-1] == 1) {
                System.out.println("Adding up");
                justRotten.add(new RottenOrange(r.x, r.y-1));
                grid[r.x][r.y-1] = 2;
                --freshOranges;
            }            
            
            if(rottenQueue.isEmpty() && justRotten.size() > 0){
                ++timeTaken;
                rottenQueue.addAll(justRotten);
                System.out.println("Adding new " + justRotten.size());
                justRotten = new ArrayList<>();
                System.out.println("------------");
            }
        }
        
        return freshOranges > 0 ? -1 : timeTaken;
        
    }
    
    class RottenOrange {
        public int x;
        public int y;
        
        public RottenOrange(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

