N = 19
arr = [ [0] *19 for i in range(19) ]
check = [ [False] * 19 for i in range(19) ]
dx = [0, 1, 1, -1, 0, -1, -1, 1]
dy = [1, 0, 1, 1, -1, 0, -1, -1]
result = False

for i in range(19):
    st = list(map(int,input().split()))
    for j in range(19):
        arr[i][j] = st[j]

def dfs(x,y,value,d):
    global check
    global cnt
    check[x][y] = True

    nx = x + dx[d]
    ny = y + dy[d]
    if nx < 0 or ny < 0 or nx >= N or ny >= N or check[nx][ny] == True:
        return
    if arr[nx][ny] == value:
        cnt += 1
        dfs(nx,ny,value,d)

def solve():
    global check
    global cnt
    global result

    for i in range(19):
        for j in range(19):
            if (arr[j][i] == 1 or arr[j][i] == 2):
                for d in range(4):
                    check = [ [False] * 19 for i in range(19) ]
                    cnt = 1
                    dfs(j,i,arr[i][j],d)
                    dfs(j,i,arr[i][j],(d+4)%8)
                    if cnt == 5:
                        result = True
                        print(arr[i][j])
                        print(j+1, i+1)
                        return

solve()
if result == False:
    print(0)