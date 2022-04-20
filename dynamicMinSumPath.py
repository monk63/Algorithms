
def dynamicMinSumPath(myMatrix, i, j):
    
    if (i == len(myMatrix)):
        return 0
    
    mn = myMatrix[i][j] + min(dynamicMinSumPath(myMatrix, i + 1, j),dynamicMinSumPath(myMatrix, i + 1, j+1))
    
    return mn

def minSumPath(myMatrix):
    return dynamicMinSumPath(myMatrix, 0, 0)

myMatrix = [[2],
            [3, 4],
            [6, 5, 7],
            [4, 1, 8, 3]]

print(minSumPath(myMatrix))
        