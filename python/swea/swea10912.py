# 10912번
# 3. 외로운 문자
T = int(input())
for t in range(1, T+1):
    words = list(input())
    words.sort()
    answer = []
    for word in words:
        if word not in answer:
            answer.append(word)
        else:
            answer.remove(word)

    answer = ''.join(answer)

    if answer == '':
        answer = 'Good'

    print(f'#{t} {answer}')
