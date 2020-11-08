# Tarek El-Hajjaoui
# seconds.py

# first ask user for time in seconds
time = int(input("Choose a number (seconds) between 1 and 86, 400: "))
# returns the amount of exact hours (no decimals) rounded down
hours = time // 3600
# The amount of seconds remaining after removing the exact hours time
remainingSeconds = time % 3600
# floor divided remaining seconds to get exact minutes (rounded down)
mins = remainingSeconds // 60
# The seconds left is just the remainder after dividing the remainingSeconds
secs = remainingSeconds % 60

print(hours, 'hour(s)')
print(mins, 'mins')
print(secs, 'secs')
