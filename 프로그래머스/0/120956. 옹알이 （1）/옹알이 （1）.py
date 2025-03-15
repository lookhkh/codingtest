def solution(babbling):
    answer = 0
    
    for i in range(len(babbling)):
        babbling[i] = babbling[i].replace("aya", "1")
        babbling[i] = babbling[i].replace("ye", "1")
        babbling[i] = babbling[i].replace("woo", "1")
        babbling[i] = babbling[i].replace("ma", "1")
        babbling[i] = babbling[i].replace("1", "")
        
        if len(babbling[i]) == 0:answer+=1
    
    return answer