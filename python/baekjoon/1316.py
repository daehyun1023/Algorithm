# 5. 그룹단어체크
# 1316.py
N = int(input())
cnt = 0
for i in range(N):
    chars = input()
    # 과거 문자열
    word = ''
    # 바로직전 문자
    past = ''
    for now in chars:
        # 과거 문자열안에 현재 문자가 포함되어있고 바로직전문자랑 다르다면 그룹단어가 아니기 때문에 break
        if past != now and now in word:
            break
        # 과거 문자열안에 현재 문자가 있지 않으면 word와 past 값 수정
        word += now
        past = now
    else:
        cnt += 1

print(cnt)
