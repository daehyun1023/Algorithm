from collections import deque

arr = list(map(int,input().split()))
N = len(arr)
res = 0
q = deque([[0,0]])


while q:
    curr = q.popleft()
    if curr[0] == N:
        res = curr[1]
        break

    left = curr[0] - arr[curr[0]]
    right = curr[0] + arr[curr[0]]
    if left >= 0 and left <= N-1:
        q.append([left,curr[1]+1])
    if right >= 0 and left <= N-1:
        q.append([right,curr[1]+1])

print(res)

# 4 1 2 3 1 2 5