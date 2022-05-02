import random
rows = int(input('Enter the number of rows:'))  # no. of rows
cols = int(input('Enter the number of columns:'))  # no. of columns
coins = int(input('Enter the number of coins:'))  # no. of coins
max_value = int(input('Enter the max value for a coin:'))  # max value of coin
l1 = [random.randint(1, max_value) for k in range(coins)]
l2 = [0 for k in range(rows*cols-coins)]
l = l1+l2
random.shuffle(l)
coin_values = []
for x in range(rows):
    coin_values.append(l[:cols])
    
l = l[cols:]

print('Distribution of the coin values')
for k in coin_values:
    for j in k:
        print(j, end=' ')
        
        print()
        
def minCostfun(cost, m, n):
    tca = [[0 for x in range(n+1)] for x in range(m+1)]
    tca[0][0] = cost[0][0]
# Initialize first column of total cost(tc) array
    for i in range(1, m+1):
        tca[i][0] = tca[i-1][0] + cost[i][0]

# Initialize first row of tc array
    for j in range(1, n+1):
        tca[0][j] = tca[0][j-1] + cost[0][j]

# Construct rest of the tc array
    for i in range(1, m+1):
        for j in range(1, n+1):
            tca[i][j] = min(tca[i-1][j], tca[i][j-1]) + cost[i][j]
        return tca
    D_P_T = minCostfun(coin_values, 9, 6)

    print('Dynamic Programming Table')
    for k in D_P_T:
        for j in k:
            print(j, end=' ')
    print()
