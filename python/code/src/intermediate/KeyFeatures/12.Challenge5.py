"""
    In this challenge the task is to sort the custom object of country as given below:
        Country(Name,Population)
    population is string and has iso appended.
    Primary sorting should be done on the basis of population without considering iso
    and Secondary sorting should be done on the basis of country name; without considering the case


    inputList is:
    country_list = [
                Country('Taiwan', '24000000iso'),
                Country('Portugal', '10000000iso'),
                Country('netherlands', '17500000iso'),
                Country('nigeria', '198000000iso'),
                Country('jordan', '10000000iso'),
                Country('nepal', '30000000iso'),
                Country('niger', '24000000iso'),
                Country('japan', '128000000iso')
]
"""
if __name__ == '__main__':
    class Country:
        def __init__(self, name, population):
            self.name = name
            self.population = population

        def __repr__(self):
            return f'Country: {self.name} -> population: {self.population}'

    inputList = [
                Country('Taiwan', '24000000iso'),
                Country('Portugal', '10000000iso'),
                Country('netherlands', '17500000iso'),
                Country('nigeria', '198000000iso'),
                Country('jordan', '10000000iso'),
                Country('nepal', '30000000iso'),
                Country('niger', '24000000iso'),
                Country('japan', '128000000iso')
        ]

    print(sorted(inputList, key=lambda c: (int(c.population[:-3]), c.name.lower())))
