
class Garden:

    def __init__(self, diagram, students=[ "Alice", "Bob", "Charlie", "David", "Eve", "Fred", "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry"]):
        students=sorted(students)
        self.dict = { x[0]:x for x in ["Radishes", "Grass", "Clover", "Violets"]}
        self.studentList = {}
        for (i, s) in enumerate(students):
            for d in diagram.split("\n"):
                if s not in self.studentList:
                    self.studentList[s] = ""                
                self.studentList[s] +=  d[i*2:i*2+2]
        # self.studentList = { s: [d[i*2:i*2+2]] for (i, s) in enumerate(students) for d in diagram.split("\n")}
        # self.studentList = [ d[i*2:i*2+2] for d in diagram.split("\n") for (i,t) in enumerate(d[::2]) ]
        # self.studentList = [ d[i*2:i*2+2] for d in diagram.split("\n") for (i,t) in enumerate(d[::2]) ]


    def plants(self, student):
        return [self.dict[i] for i in self.studentList[student]]
        # return [i for i in self.studentList[student]]


if __name__ == "__main__":
    g=Garden("12341234\n56785678")
    print(g.studentList)