from collections import deque


def solution(places):
    answer = []
    return answer


places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPXX",
                                                                                                         "OXXXP", "POOXX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]

# places = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]]

answer = []


def bfs(x, y, arr, P_cnt):
    dx = [-1, 0, 0, 1]
    dy = [0, -1, 1, 0]
    q = deque()
    q.append([x, y, 0])
    check = [[False]*5 for i in range(5)]
    check[x][y] = True
    # print(P_cnt, "----------------------------")

    while q:
        p = q.popleft()
        # print(p[0], p[1])
        for i in range(4):
            nx = p[0] + dx[i]
            ny = p[1] + dy[i]
            if nx < 0 or ny < 0 or nx >= 5 or ny >= 5 or check[nx][ny]:
                continue
            if arr[nx][ny] == 'X':
                continue
            p[2] += 1
            if p[2] <= 2 and arr[nx][ny] == 'P':
                # print(p[2], ';;;;;;')
                return 0
            check[nx][ny] = True
            q.append([nx, ny, p[2]])

    return 1


for place in places:
    arr = [[0]*5 for i in range(5)]
    P_cnt = 0
    good_cnt = 0
    for i in range(5):
        for j in range(5):
            arr[i][j] = place[i][j]

    for i in range(5):
        for j in range(5):
            arr[i][j] = place[i][j]
            if arr[i][j] == 'P':
                P_cnt += 1
                good_cnt += bfs(i, j, arr, P_cnt)

    if good_cnt == P_cnt:
        answer.append(1)
    else:
        answer.append(0)

print(answer)
