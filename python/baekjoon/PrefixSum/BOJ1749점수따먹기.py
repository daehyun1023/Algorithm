N, M = map(int, input().split())
arr = [ [0] * M for i in range(N) ]

for i in range(N):
    nums = list(map(int,input().split()))
    for j in range(M):
        arr[i][j] = nums[j]

