# Tarek El-Hajjaoui
# celcius.py

# first asks user for temperature is Celcius
tempInCelcius = int(input("What is the temperature in Celcius? "))
# Equation that converts Celclius to Fahrenheit
celciusToFahrenheit = (1.8 * tempInCelcius) + 32
# Equatin that converts Fahrenheit to Kelvin
Kelvin = (celciusToFahrenheit + 459.67) * (5/9)

print("The temperature in Fahrenheit is: ", celciusToFahrenheit)
print("The temperature in Kelvin is: ", Kelvin)
