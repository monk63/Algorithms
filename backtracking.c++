#include<cstdio>
#define N 201
int n, m , r;
int used[N][N];
int grid[N][N] ;  // 1 is coin is placed . 0 otherwise. // -1 undecided.

bool isOk()
{
    int rows[N];
    int cols[N];

    for(int i = 0 ; i < n ; i++) rows[i] = 0;
    for(int i = 0 ; i < m ; i++) cols[i] = 0;
    int sum = 0;
    for(int i = 0 ; i < n ; i++)for(int j = 0; j < m ; j++)
    {
        if(grid[i][j]==1)
        {
            rows[i]++;
            cols[j]++;
            sum++;  
        }
    }
    for(int i = 0 ; i < n ; i++) 
    {
        if(rows[i]==0) return false;
    }

    for(int j = 0 ; j < n ; j++)
    {
        if(cols[j]==0) return false;
    }
    if(sum==r) return true;
    else return false;
}

int calc_ways(int row , int col,  int coins)
{
    if(row >= n) return 0;
    if(col >= m) return 0;
    if(coins > r) return 0;
    if(coins == r) 
    {
        bool res = isOk();
        if(res) return 1; 
        else 0;
    }

    if(row == n - 1 and col== m- 1) 
    {
        bool res = isOk();
        if(res) return 1;
        else return 0;
    }

    int nrow, ncol;

    if(col + 1 >= m)
    {
        nrow = row + 1;
        ncol = 0;
    }
    else
    {
        nrow = row;
        ncol = col + 1;
    }
    if(used[row][col]) return calc_ways(nrow, ncol, coins);
    int ans =  0;
    used[row][col] = 1;
    grid[row][col] = 0;
    ans += calc_ways(nrow , ncol , coins);

    grid[row][col] = 1;
    ans += calc_ways(nrow , ncol , coins + 1);

    return ans;
}

int main()
{
    int t;
    scanf("%d" , &t);
    while(t--)
    {
        scanf("%d %d %d" , &n , &m , &r);
        for(int i = 0 ; i <= n ; i++)
        {
            for(int j = 0; j <= m ; j++)
            {
                used[i][j] = 0;
                grid[i][j] = -1;
            }
        }
        printf("%d\n" , calc_ways(0  ,  0 , 0 ));
    }
    return 0;
}