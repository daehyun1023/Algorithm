def solution(infos, querys):
    pass


infos = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
         "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"]
querys = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
          "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"]

subject = ['-', 'cpp', 'java', 'python']
duty = ['-', 'backend', 'frontend']
experience = ['-', 'junior', 'senior']
food = ['-', 'chicken', 'pizza']

L = [[] for i in range(108)]
print(L)
for i in infos:
    info = i.split(' ')
    v1 = subject.index(info[0])
    v2 = duty.index(info[1])
    v3 = experience.index(info[2])
    v4 = food.index(info[3])
    v5 = int(info[4])
    for c1 in [0, v1]:
        for c2 in [0, v2]:
            for c3 in [0, v3]:
                for c4 in [0, v4]:
                    idx = c1*27 + c2*9 + c3*3 + c4
                    L[idx].append(v5)

    for i in range(108):
        L[i].sort()

print(L)
