class Isogram {
    // returns true if phrase is isogram
    static boolean isIsogram(String phrase) {        
        def enriched = phrase
            .toLowerCase()
            .toCharArray()
            .findAll {  it =~ '[a-z]' }
        return enriched.toSet().size() == enriched.size()
    }
}