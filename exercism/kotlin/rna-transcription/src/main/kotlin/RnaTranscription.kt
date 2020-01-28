val rnaMap = mapOf(
    'G' to 'C',
    'C' to 'G',
    'T' to 'A',
    'A' to 'U'
)

// fun transcribeToRna(dna: String): String =  dna.toCharArray().map { rnaMap[it] }.joinToString("")
fun transcribeToRna(dna: String): String = dna.fold("") { 
    a, n -> a + rnaMap[n] 
} 
