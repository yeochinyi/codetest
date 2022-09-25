export function decodedValue(colors: Array<string>) {
    let m = {
        'black':'0',
        'brown':'1',
        'red':'2',
        'orange':'3',
        'yellow':'4',
        'green':'5',
        'blue':'6',
        'violet':'7',
        'grey':'8',
        'white':'9', 
    }
    const m2 = new Map<string, string>(Object.entries(m));
    const r = colors.slice(0,2).map((a) => m2.get(a.toLowerCase())).reduce((a,b) => a!+b!);
    return +r!;
}
