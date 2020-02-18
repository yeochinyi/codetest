def slices(series, length):
    
    return [series[x:length+x] for x in range(0, len(series) - length + 1, 1)]


if __name__ == "__main__":
    print(slices("1234567890",4))