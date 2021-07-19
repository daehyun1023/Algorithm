n = 1
t = 1
m = 5
timetable = ["00:01", "00:01", "00:01", "00:01", "00:01"]

from collections import deque

def date_convert_num(date):
    hour = int(date[:2])
    minute = int(date[3:])
    num = hour * 60 + minute
    return num

def num_convert_date(num):
    hour = str(num // 60)
    minute = str(num % 60)
    if int(hour) // 10 == 0:
        hour = '0' + hour
    if int(minute) // 10 == 0:
        minute = '0' + minute
    return hour + ':' + minute

def solution(n, t, m, timetable):
    answer = ''
    bus_time = date_convert_num('09:00') - t
    last_time = 1e9
    timetable = list(map(date_convert_num, timetable)).sort()
    timetable = deque(timetable)
    cnt = 0
    for _ in range(n):
        cnt = 0
        bus_time += t
        for _ in range(m):
            if len(timetable) > 0 and timetable[0] <= bus_time:
                last_time = timetable.popleft()
                cnt += 1
            else:
                break
    
    if cnt >= m:
        answer = last_time - 1
    else:
        answer = bus_time
    
    return num_convert_date(answer)


print(solution(n, t, m, timetable))