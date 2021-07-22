# lines = [
# "2016-09-15 01:00:04.001 2.0s",
# "2016-09-15 01:00:07.000 2s"
# ]
# answer = 1
# lines = [
# "2016-09-15 01:00:04.002 2.0s",
# "2016-09-15 01:00:07.000 2s"
# ]
# answer = 2

lines = [
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"
]

import heapq as hq

def time_convert_num(time):
    hour, minute, sec= list(map(float,time.split(':')))
    return int((hour * 3600 + minute * 60 + sec) * 1000)

def solution(lines):
    arr = []
    for line in lines:
        line_list = line.split(' ')
        process_time = float(line_list[2].replace('s','')) * 1000
        print(process_time)
        finish_time = time_convert_num(line_list[1])
        
        start_time = finish_time - process_time + 1
        arr.append([start_time, finish_time])
    arr.sort(key=lambda x:(x[0], x[1]))
    answer = 1
    pq = []
    hq.heappush(pq, arr[0][1])
    for i in range(1, len(arr)):
        start, end = arr[i]
        if pq[0] >= start - 999:
            hq.heappush(pq, end)
            answer = max(answer, len(pq))
        else:
            while True:
                if len(pq) == 0 or pq[0] >= start - 999:
                    hq.heappush(pq, end)
                    answer = max(answer, len(pq))
                    break
                else:
                    hq.heappop(pq)
    return answer


print(solution(lines))