
def minSumPath(myMatrix):
    arr = [None] * len(myMatrix)
    n = len(myMatrix) - 1
    
    for i in range (len(myMatrix[n])):
        arr[i] =  myMatrix[n][i]
        
    for i in range(len(myMatrix) -2, -1, -1):
        for j in range(len(myMatrix[i])):
            arr[j] = myMatrix [i][j] + min(arr[j],arr[j + 1]);
            
    return arr[0]

myMatrix = [[2],
            [3, 4],
            [6, 5, 7],
            [4, 1, 8, 3]]

print(minSumPath(myMatrix)) 