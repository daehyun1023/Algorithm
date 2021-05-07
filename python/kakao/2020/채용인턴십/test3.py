gems = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
length = len(gems)
answer = [0, length-1]
n = len(set(gems))
start = 0
end = 0
dic = dict()
dic[gems[0]] = 1

while start < length and end < length:
    if len(dic) == n:
        if answer[1] - answer[0] > end - start:
            answer[0] = start
            answer[1] = end

        if dic[gems[start]] == 1:
            del dic[gems[start]]
        else:
            dic[gems[start]] -= 1
        start += 1
    else:
        end += 1
        if end == len(gems):
            break
        else:
            dic[gems[end]] = dic.get(gems[end], 0) + 1

answer[0] += 1
answer[1] += 1
print(answer)
