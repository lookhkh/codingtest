class UserReport:
    def __init__(self, username):
        self.user_name = username
        self.reportees = set()
    def report(self, reportee):
        self.reportees.add(reportee)
    def getSize(self):
        return len(self.reportees)



def solution(id_list, report, k):
    answer = []
    reports = {}
    for id in id_list:
        reports[id]= UserReport(id)

    for entity in report:
        reporter, reportee = entity.split(" ")
        news = reports.get(reportee)
        news.report(reporter)

    keys = reports.keys()
    lists = []
    for key in keys:
        result = reports.get(key)
        size = result.getSize()
        if size >= k : lists.append(key)

    results = {}
    for id in id_list:
        results[id] = 0

    for name in lists:
        r = reports.get(name)
        reporters = r.reportees
        for nnn in reporters:
            results[nnn]+=1

    rrrrr = results.values()
    print

    return list(results.values())
