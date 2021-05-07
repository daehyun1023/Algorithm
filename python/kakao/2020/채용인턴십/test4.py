import math
from collections import deque
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
board = [[0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 0], [0, 0, 1, 0, 0, 0],
         [1, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0]]

N = len(board)
check = [[0] * N for i in range(N)]


def bfs():
    global board

    q = deque()
    q.append([0, 0, 0, 0])
    # x, y, 방향, 가격
    check[0][0] = 100

    while q:
        x, y, d, p = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= N or ny >= N:
                continue
            if board[nx][ny] == 1:
                continue

            if x == 0 and y == 0:
                price = 100
            elif d == i:
                price = p + 100
            else:
                price = p + 600

            if check[nx][ny] == 0:
                check[nx][ny] = price
                q.append([nx, ny, i, price])
            elif price < check[nx][ny]:
                q.append([nx, ny, i, price])
                check[nx][ny] = price


bfs()

print(check[N-1][N-1])
