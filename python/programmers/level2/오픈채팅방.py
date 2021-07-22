def solution(records):
    answer=[]
    id_name = {}

    for record in records:
        record = record.split(' ')
        if record[0] == 'Enter':
            id_name[record[1]] = record[2]
            answer.append(record[1] + "님이 들어왔습니다.")
        elif record[0] == 'Change':
            id_name[record[1]] = record[2]
        else:
            answer.append(record[1] + "님이 나갔습니다.")

    for i in range(len(answer)):
        idx = answer[i].index('님')
        answer[i] = id_name[answer[i][:idx]]+answer[i][idx:]
        
    return answer