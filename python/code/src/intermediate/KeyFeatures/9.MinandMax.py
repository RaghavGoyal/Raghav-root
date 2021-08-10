def main():
    countries = ['India', 'Japan', 'Uk', 'America', 'China', 'Sri Lanka', 'Nepal']
    population = [5, 2, 3, 4, 7, 1, 2]

#     apply min and max on int:
    print(min(population))
    print(max(population))

#     apply min and max on non-int:
#     compares the elements character by character, like sorting
    print(min(countries))
    print(max(countries))

#     min and max on tuple:
#     tuple comparison is also like string comparison; character by character
    print(min(zip(countries, population)))
    print(max(zip(countries, population)))

#     min and max with key:
#     this ensures that min and max results are calculated based on logic provided in key
    def getPopulation(pair):
        country, population = pair
        return population

    print(min(zip(countries, population), key=getPopulation))
    print(max(zip(countries, population), key=getPopulation))

#     key can also provide logic using lambda as:
    print(min(zip(countries, population), key= lambda x: x[1]))     # Accessing element of tuple at index 1;
    print(max(zip(countries, population), key= lambda x: x[1]))

if __name__ == '__main__':
    main()
