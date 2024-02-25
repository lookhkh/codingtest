n, m = map(int, input().split(" "))
sub = [i for i in range(1, n + 1)]


def backtrack(path=[], idx=0, args=[]):
    if idx == m:
        result = ' '.join(map(str,args))
        print(result)
        return

    for i in range(len(sub)):
        if path[i]: continue
        path[i] = True
        args[idx] = sub[i]
        backtrack(path, idx+1, args)
        path[i] = False



path = [False for _ in range(0, n)]
idx = 0
args = [0 for _ in range(0,m)]

backtrack(path, idx, args)