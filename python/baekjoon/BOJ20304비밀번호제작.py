from collections import deque
N = int(input())
M = int(input())
passwords = list(map(int, input().split()))
q = deque()
visit = [-1] * (N+1)


def bfs():
    while q:
        curr = q.popleft()
        for i in range(20):
            temp = 1 << i
            new = temp ^ curr
            if new > N:
                continue
            if visit[new] == -1:
                visit[new] = visit[curr] + 1
                q.append(new)


for i, password in enumerate(passwords):
    q.append(password)
    visit[password] = 0

bfs()
print(max(visit))
