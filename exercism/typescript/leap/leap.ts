export function isLeap(y: number) {
    return y % 400 == 0 || y % 4 == 0 && y % 100 != 0
}
