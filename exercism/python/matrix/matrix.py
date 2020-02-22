class Matrix:
    """ create a matrix starting from 1 as base  """
    def __init__(self, matrix_string):
        self.matrix = list(
            map(
                lambda x: list(map(
                    lambda y: int(y), 
                    x.split(" ")
                )),
                matrix_string.split("\n")
            )
        )
    def row(self, index):
        return self.matrix[index - 1]

    def column(self, index):
        return list(map(lambda x: x[index - 1], self.matrix))


# if __name__ == "__main__":
#     print(Matrix("1 2\n3 4").column(1))