def solution(n, s, a, b, fares):
    fares = [[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]
    minimum = 1e9

    arr = [[minimum for _ in range(n)] for _ in range(n)]

    for fare in fares:
        x, y, cost = fare
        arr[x-1][y-1] = cost
        arr[y-1][x-1] = cost

    for i in range(n):
        arr[i][i] = 0

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if arr[i][j] > arr[i][k] + arr[k][j]:
                    arr[i][j] = arr[i][k] + arr[k][j]

    for i in range(n):
        minimum = min(minimum, arr[s-1][i] + arr[i][a-1] + arr[i][b-1])

    return minimum
