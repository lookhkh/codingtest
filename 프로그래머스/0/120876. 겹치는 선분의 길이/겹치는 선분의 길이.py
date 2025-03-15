def solution(lines):
    answer = 0
    
    dict = {value: 0 for value in (x for x in range(-100, 101))}
    
    for next in lines:
        for to in range(next[0], next[1]):
            dict[to] +=1
    
    
    for key in dict:
        val = dict[key]
        if val >= 2 : print(key, val)
        if val >= 2: answer+=1
        
    
    return answer

