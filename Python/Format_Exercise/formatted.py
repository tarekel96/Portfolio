# Tarek El-Hajjaoui
# formatted.py

# The {:10} creates a left column of 10 strings long
# The {:25} creates a left column of 25 strings long
print('Melting and Boiling Points of Alkanes')
print('{:10} {:25} {:25}'.format(
    'Name', 'Melting Point (deg C)', 'Boiling Point (deg C)'))
print('{:10} {:25} {:25}'.format('Methane', '-162', '-183'))
print('{:10} {:25} {:25}'.format('Ethane', '-89', '-172'))
print('{:10} {:25} {:25}'.format('Propane', '-42', '-188'))
print('{:10} {:25} {:25}'.format('Butane', '-42', '-135'))
