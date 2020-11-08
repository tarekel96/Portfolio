#	Tarek El-Hajjaoui
# quadratric.py

# import math module to use math methods
import math
a = int(input("Enter a: "))
b = int(input("Enter b: "))
c = int(input("Enter c: "))

# made discrimnant a variable so code is cleaner
d = b**2-4*a*c  # discriminant

# solving quadratic formula like calculus
if d < 0:
    print("This equation has no real solution")
elif d == 0:
    x = (-b+math.sqrt(d))/2*a
    print("This equation has one solutions: ", x)
else:
    x1 = (-b+math.sqrt(d))/2*a
    x2 = (-b-math.sqrt(d))/2*a
    print("This equation has two solutions: ", x1, " and", x2)
