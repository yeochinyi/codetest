class Bob {

    // https://e.printstacktrace.blog/groovy-regular-expressions-the-definitive-guide/
    // return response of lackadaisical teenager
    static response(input) {
        // Bob answers 'Sure.' if you ask him a question, such as "How are you?".
        // He answers 'Whoa, chill out!' if you YELL AT HIM (in all capitals).
        // He answers 'Calm down, I know what I'm doing!' if you yell a question at him.
        // He says 'Fine. Be that way!' if you address him without actually saying anything.
        // He answers 'Whatever.' to anything else.
        
        if(input == null || input.trim()==''){
            return 'Fine. Be that way!'
        }

        // println "input=${input}"
        switch(input.trim()){
            case ~/^[0-9\W]+\?$/:
                return "Sure."
            case ~/^[A-Z0-9\W]+\?$/:
                return "Calm down, I know what I'm doing!"
            case ~/^[A-Za-z0-9\W]+\?$/:
                return "Sure."
            case ~/^[0-9\W]+$/:
                return "Whatever."
            case ~/^[A-Z0-9\W]+$/:
                return "Whoa, chill out!"
            default:
                return "Whatever."
        }

    }

    static void main(args){
        // println "args=${args}"
        println Bob.response(args[0])
    }
}

