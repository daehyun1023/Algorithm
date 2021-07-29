n = 2
words = ["hello", "one", "even", "never", "now", "world", "draw"]

# n = 3
# words = ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]

from collections import deque

def solution(n, words):
    cnt = 0 # 몇 번을 했는지
    before = '' # 마지막으로 끝난 문자가 무엇인지
    word_set = set() # 이전에 말한 단어들
    words = deque(words) # words를 왼쪽에서 부터 꺼내기 위해 deque로
    person = 0
    turn = 0

    while words:
        word = words.popleft()
        cnt += 1
        if (before == '' or before == word[0]) and word not in word_set:
            before = word[-1]
            word_set.add(word)
        else:
            turn, person = divmod(cnt, n)
            turn += 1
            if person == 0:
                turn -= 1
                person = n
            break
    return [person, turn]

print(solution(n, words))