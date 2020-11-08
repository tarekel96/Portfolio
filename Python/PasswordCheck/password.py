# Tarek El-Hajjaoui
# password.py

# - password must be at least 6 characters and at most 20 characters
# - password must contain at least one lowercase letter, one uppercase letter, one number
# - password cannot contain spaces or punctuation

# the user variable represents the password (pw) inputted by the user
user = input("Please enter a passphrase: ")

# if the pw is less than 6 characters, it will inform the client to make the pw longer
if len(user) < 6:
    print("Your passphrase must contain at least 6 characters")
    user = input("Please enter a passphrase: ")

# if the pw is more than 20 characters, it will inform the client to make the pw shorter
if len(user) > 20:
    print("Your passphrase must be no more than 20 characters")
    user = input("Please enter a passphrase: ")

# if the pw does not contain a single capital letter, it will inform the client to add a capital letter
# any() - boolean function that returns False if an item is not in an iterable object
# any(there is a capital letter in pw)
# capital is the variable that is iterating over the pw
if any(capital.isupper() for capital in user) == False:
    print("You need at least one Capital Letter")

# if the pw does not contain a single lower-case letter, it will inform the client to add a lower-case letter
if any(lower.islower() for lower in user) == False:
    print("You need at least one Capital Letter")

# if the pw does not contain a single number, it will inform the client to add a number
if any(lower.isdigit() for lower in user) == False:
    print("You need at least one number")

# initial the iterating variable for the while loop
i = 0
# the loop will continue as long as the iterating variable is less than the character length of the pw
while len(user) > i:
    # if the pw contains a space, it will inform the client to remove the space
    if user[i] == ' ':
        print("You cannot have any spaces")
    # if user[i] == '@' or user[i] == '!' or user[i] == '#' or user[i] == '$' or user[i] == '%' or user[i] == '^' or user[i] == '&' or user[i] == '*' or user[i] == '(' or user[i] == ')' or user[i] == '-' or user[i] == '_' or user[i] == '+' or user[i] == '=':
    #     print("You cannot have any special characters")
    i = i + 1

# variable that represents an array of special characters
specialCharacters = ['$', '#', '@', '!', '*',
                     '%', "^", "&", "(", ")", "-", "_", "+", "="]

# if the pw contains a special character, it will inform the client to remove the special character
if any(special in specialCharacters for special in user) == True:
    print("You cannot have any special characters")
