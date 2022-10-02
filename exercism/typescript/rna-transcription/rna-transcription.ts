export function toRna(c: string) {
  let x = (s: string): string => {
    switch (s) {
      case "G":
        return "C";
      case "C":
        return "G";
      case "T":
        return "A";
      case "A":
        return "U";
      default:
        throw new Error("Invalid input DNA.");
    }
  };
  const r = c
    .split("")
    .map((y) => x(y))
    .join("");
  return r;
}
