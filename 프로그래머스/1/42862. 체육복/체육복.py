def solution(n, lost=[], reserve=[]):
    setLost = set(lost)
    setReserve = set(reserve)

    lost = list(setLost - setReserve)
    reserve = list(setReserve - setLost)

    print(lost, reserve)

    n -= len(lost)
    for lostOne in lost:
        for reserveOne in reserve:
            if lostOne - 1 <= reserveOne <= lostOne + 1:
                n += 1
                reserve.remove(reserveOne)
                break
    return n

