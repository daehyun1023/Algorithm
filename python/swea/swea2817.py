def btr(x, depth, end):
    global cnt
    if depth == end:
        num = sum(check)
        if num == K:
            cnt += 1
        return

    for i in range(x, len(check)):
        if check[i] == 0 and sum(check) < K:
            check[i] = numbers[i]
            btr(i, depth+1, end)
            check[i] = 0

T = int(input())
for t in range(T):
    N, K = list(map(int, input().split()))
    numbers = list(map(int, input().split()))
    check = [0] * len(numbers)
    cnt = 0

    for i in range(1, N+1):
        btr(0, 0, i)

    print(f'#{t+1} {cnt}')
