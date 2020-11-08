# Tarek El-Hajjaoui
# latin.py

# define variables representing all of the elements of their respected names
consonants = "bcdfghjklmnpqrstvwxyz"
vowels = "aeiou"
punctuation = '.,?!'

# varibale that stores what text file the user would like to convert to pig latin
chosen_file = str(input("Which file would you like to convert to Pig Latin? "))
# variables that defines Python opening the chosen_file text file
the_file = open(chosen_file, "r")

# the function that converts an English word to its pig latin version


def word_to_pig(word):
    # lowercase all of the letters of the string because consonants and vowels are defined in lowercase above
    word = word.lower()

    # if the first letter of the word is a consosnant, this statement will proceed
    if word[0] in consonants:
        # converts the word from a string to a list
        word = list(word)
        # variable defining which consonant is the first letter
        conLetter = word[0]
        # removes the first letter (the consosnant) from the word array
        word.pop(0)
        # adds the that consosant to the end of the word array
        word.append(conLetter)
        # adds "ay" to the end of the word array
        word.append("a")
        word.append("y")
        # converts the word array back to a word string
        word = ''.join(word)

    # if the first letter of the word is a vowel, this statement will proceed
    else:
        word = list(word)
        word.append("y")
        word.append("a")
        word.append("y")
        word = ''.join(word)
    # must return the word back because this is a function
    return word


# for loop that loops through each line of the text file
for line in the_file:
    # strip() removes extra space from the lines
    line = line.strip()
    # separates each word of a line with a space
    words = line.split(" ")
    # initialize a new array where the pig latin words are added to
    pigLine = []
    # for loop that loops through each word of each line
    for word in words:
        # each word is passed as argument to the word_to_pig() function to convert the word to its pig latin version
        word = word_to_pig(word)
        # for loop that loops through each letter of a word and enumate is used here to keep track of the index (of each letter)
        for index, letter in enumerate(word):
            # if the letter is a punctuation this statement will proceed
            if letter in punctuation:
                # converts the word from a string to an array
                word = list(word)
                # pop() here removes the punctuation symbol, the index from enumerate tells it which index exactly is the punctuation symbol
                word.pop(index)
                # adds the punctuation to the end of the word array
                word.append(letter)
                # converts the word array to a string
                word = ''.join(word)
        # each word (converted from English to pig latin) is appended to the pigLine array
        pigLine.append(word)
        # function continues to convert each word to pig latin
        continue
# converts the pigLine array to an strings separated by a space
pigLine = ' '.join(pigLine)
print(pigLine)
