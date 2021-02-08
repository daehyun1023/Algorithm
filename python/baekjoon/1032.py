# 1032번 명령프롬프트
N = int(input())
words = input()
for i in range(N - 1):
    temps = input()
    for j in range(len(words)):
        if words[j] is not temps[j]:
            words = list(words)
            words[j] = '?'

print(''.join(words))
