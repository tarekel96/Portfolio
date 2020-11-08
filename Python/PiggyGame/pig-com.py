# Tarek El-Hajjaoui
# pig-com.py

# import random module to use random.randint() method
import random

# the total player score
playerScore = 0

# the total computer score
computer = 0

# the player's score just for current turn
turn = 0

# the computer's score just for current score
computerTurn = 0

# This variable determines who's turn it is.
# By default it is = 0 and it is the player's turn
whoTurn = 0

# the program executes until either the computer
# or the player reaches a score of 100
while playerScore < 100 or computer < 100:
    # By default it is the player's turn
    if whoTurn == 0:
        # oneDie represents the die that the player rolls
        oneDie = random.randint(1, 6)
        # if the player rolls a 1, they will receive a 0 for that turn
        # and it will be the Computer's turn
        if oneDie == 1:
            turn = 0
            print("Player 1: You rolled a ", oneDie,
                  "so you receive 0 points and it is the Computer's turn")
            #  setting the varibale to 1, makes it the Computer's turn
            whoTurn = 1
        elif oneDie > 1:
                # below the currnet player's turn is added to keep count
            turn = turn + oneDie
            print("You rolled a ", oneDie)
            # asks the player if they would like to hold (keep the current die) or roll again
            rollAgain = input("Would you like to roll again or hold (r/h)? ")
            if rollAgain == 'h':
                playerScore = playerScore + turn
                print("Player Current score: ", playerScore)
                turn = 0
    else:
        # computerDie represents the die that the computer rolls
        computerDie = random.randint(1, 6)
        # if the computer rolls a 1, then the computer will recieve a 0 for that turn
        #  and it will be the Player's turn next
        if computerDie == 1:
            computerTurn = 0
            print("Computer: You rolled a ",
                  computerDie, "so you receive 0 points")
            whoTurn = 0
        # computerTurn = 0
        elif computerDie > 1:
            # adds the current computer die to the current computer's turn
            computerTurn = computerDie
            print("Computer you rolled a ", computerDie)
        # adds the current computer turn to the total computer score
            computer = computer + computerTurn
            print("Computer Current Score: ", computer)
        # if the computer's turn is greater than 20,
        # it will switch to the Player's turn and
        # reset the current computer's turn for the next time it is the computer's turn
        if computerTurn > 20:
            whoTurn = 0
            computer = computer + computerTurn
            computerTurn = 0
