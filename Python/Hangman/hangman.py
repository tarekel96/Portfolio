# Tarek El-Hajjaoui
# hangman.py

import random
# hard coded a list of words, but could use an API here for an extravagent list of words
possibleWords = ['computer', 'science', 'jellybeans',
                 'halloween', 'disneyland', 'california']
# use randint from random module here to  randomly choose a correct word/answer from a list of possible words
# the index is the index of that word in the possibleWords array
index = random.randint(0, len(possibleWords) - 1)
# correctWord represents the word the user is trying to guess
correctWord = possibleWords[index]


# setting up the puzzle
puzzle = []
for char in correctWord:
    puzzle.append("-")
print(puzzle)

# how we will print it out to the user
print(" ".join(puzzle))

# setting up guesses
guessses = [""]

# settin up bad guesses
badGuesses = 0

# the maximum number of times a user can try guessing different letters
maxGuesses = len(correctWord)+3

# this is the bulk of the program
# while loop executes until the length of list of the user's guesses is equal to the number of maximum guesses
while len(guessses) < maxGuesses:

    # if puzzle variable/string no longer contains the '-' string, the user wins and is informed that
    if '-' not in puzzle:
        print("You win!")
        # the loop breaks because the user won
        break

    # letter stores the user's guesses
    letter = input("Enter a letter to guess: ")

    # if the letter is contained in the string of the correct word, this for loop will be activated
    if letter in correctWord:
        # use enumerate to capture the index of each letter of the correct word
        for index, char in enumerate(correctWord):
            # if a character from the correct word string matches the inputted letter string,
            # the '-' will be replaced where that letter is supposed to be.
            # ex. if the correct word is 'that' and user guessed 't': 'that' '----' --> 't--t'
            if char == letter:
                puzzle[index] = char
        # put print outside of if statement so it only prints once if there are multiple spots where the '-' is being replaced with the correct letter
        print(puzzle)
        # the number of guesses left - maxmimum guesses minus number of guesses
        print("You have ", maxGuesses - badGuesses, "guesses left.")
        # while loop continues back to the top
        continue
    # if the letter is not contained in the string of the correct word, this if statement will execute
    if letter not in correctWord:
        print(letter, "is not in the word")
        # if they already guessed the inputted letter before, they will be informed about it &
        # the messaeg will will indicate how many cases the user has left. The while loop continues (starts back at the top)
        if letter in guessses:
            print("You already guessed", letter, "before")
            print("You still have ", maxGuesses - badGuesses, "guesses left.")
            print(puzzle)  # remind user what the puzzle looks like so far
            continue
        # only if the letter is not in guesses
        else:
            # add the newly incorrect word to the list of guesses
            guessses.append(letter)
            # user be penalized with the addition of a bad guess to total bad guesses
            badGuesses = badGuesses + 1
            print("You now only have ", maxGuesses -
                  badGuesses, "guesses left.")  # shows them a different message now, indicating they have one less guess than before

# iflength of the list of guesses is equal to the maximum guesses,
# the loop will stop executing
if len(guessses) == maxGuesses:
    print('YOU LOSE. Sorry you have reached the maximum number of guesses.')
