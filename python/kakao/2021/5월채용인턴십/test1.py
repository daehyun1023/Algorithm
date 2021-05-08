def solution(s):
    answer = 0
    return answer


s = "one4seveneight"

dic = {'zero': '0', 'one': '1', 'two': '2', 'three': '3', 'four': '4',
       'five': '5', 'six': '6', 'seven': '7', 'eight': '8', 'nine': '9', }

st = ''
answer = ''

for char in s:
    if char in '0123456789':
        answer += char
        st = ''
    else:
        st += char
        print(st)
        if st in dic:
            answer += dic[st]
            st = ''

print(answer)
