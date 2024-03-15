public class SpellingBeePuzzle {
    private String puzzle;

    /**
     * Constructor for the SpellingBeePuzzle class
     * 
     * @param puzzle String of letters in the puzzle
     * @throws SpellingBeePuzzleException if the puzzle is invalid
     */
    public SpellingBeePuzzle(String puzzle) throws SpellingBeePuzzleException {
        if (puzzle.length()!= 7) {
            throw new SpellingBeePuzzleException("Puzzle must contain exactly seven letters");
        }

        for (int i = 0; i < puzzle.length(); i++) {
            char c = puzzle.charAt(i);
            if (c < 'A' || c > 'Z') {
                throw new SpellingBeePuzzleException("Every character must be a letter between A and Z");
            }

            for (int j = i + 1; j < puzzle.length(); j++) {
                if (puzzle.charAt(j) == c) {
                    throw new SpellingBeePuzzleException("No letter may appear more than once in the puzzle");
                }
            }
        }
        this.puzzle = puzzle;
    }

    /**
     * This method returns the puzzle letters
     * 
     * @return the puzzle letters
     */
    public String getPuzzle() {
        return puzzle;
    }

    /**
     * This method checks if a word uses only the letters in the puzzle
     * 
     * @param word the word to check
     * @return true if the word only uses the letters in the puzzle
     * @return false if the word uses letters not in the puzzle
     */
    public boolean wordUsesPuzzleLettersOnly(String word) {
        String puzzleLower = puzzle.toLowerCase();
        String wordLower = word.toLowerCase();

        for (int i = 0; i < wordLower.length(); i++) {
            if (puzzleLower.indexOf(wordLower.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method checks if a word uses the center letter
     * 
     * @param word the word to check
     * @return true if the word uses the center letter
     * @return false if the word does not use the center letter
     */
    public boolean wordUsesCenterLetter(String word) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.toUpperCase().charAt(i); 
            if (c == puzzle.charAt(0)) {
                return true;
            }
        }
        return false;
    }
    /**
     * This method checks if a word is a pangram
     * 
     * @param word the word to check
     * @return true if the word is a pangram
     * @return false if the word is not a pangram
     */
    public boolean isPangram(String word) {
        for (int i = 0; i < puzzle.length(); i++) {
            if (word.indexOf(puzzle.toLowerCase().charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}