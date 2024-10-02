def numIslands(grid):

    m, n = len(grid), len(grid[0])

    def dfs(i, j):
        if i < 0 or j < 0 or i >= m or j >= n or grid[i][j] != '1':
            return 
        else:
            grid[i][j] = '0'  # Mark the cell as visited
            dfs(i, j+1)  # Move right
            dfs(i, j-1)  # Move left
            dfs(i+1, j)  # Move down
            dfs(i-1, j)  # Move up

    islands = 0
    for i in range(m):
        for j in range(n):
            if grid[i][j] == '1':
                islands += 1
                dfs(i, j)

    return islands

# Testing the function
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]

print(numIslands(grid))  # Output should be 1
