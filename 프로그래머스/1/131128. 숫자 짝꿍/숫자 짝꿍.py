def solution(X, Y):
    answer = ''
    dict = createDict(X)
    pq = []
    for i in range(len(Y)):
        next = Y[i]
        if next in dict:
            dict[next]-=1;
            pq.append(int(next))
            if dict[next] <= 0:
                del dict[next]

    if len(pq) == 0:
        return "-1"

    result = sorted(pq, reverse=True)
    string_nums = [str(num) for num in result]
    if string_nums[0] == '0':
        return "0"

    return ''.join(string_nums)



def createDict(X):
    dict = {}
    for i in range(len(X)):
        next = X[i]
        if next in dict:
            dict[next] += 1
        else:
            dict[next] = 1
    return dict
