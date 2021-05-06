N, K = list(map(int, input().split()))
A = list(map(int, input().split()))
sum_A = A.copy()

for i in range(1, N):
    sum_A[i] += sum_A[i-1]

print(sum_A)
