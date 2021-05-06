t = int(input())

for _ in range(t):
    min_value = 1e11
    max_value = -1
    W = input()
    K = int(input())

    alpha = [[] for i in range(26)]
    for idx, char in enumerate(W):
        alpha[ord(char)-ord('a')].append(idx)

    for idx_list in alpha:
        if len(idx_list) >= K:
            for idx in range(len(idx_list)):
                if idx + K > len(idx_list):
                    break
                min_value = min(min_value, idx_list[idx+K-1] - idx_list[idx]+1)
                max_value = max(max_value, idx_list[idx+K-1] - idx_list[idx]+1)

    if max_value == -1:
        print(max_value)
        continue
    print(min_value, max_value)
