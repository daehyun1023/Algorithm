T = int(input())
for t in range(1, T + 1):
    D, L, N = map(int, input().split())
    answer = D
    for i in range(1, N):
        answer += D * (1 + i * (L) * 0.01)
    print(f'#{t} {int(answer)}')
