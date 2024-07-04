word = "banana"
table = []
index = 0
life = 5
game = True
for letter in word:
    table.append('_')

print(table)

while game:
    guess = input("A letter: ")

    if guess in word:
        for letter in word:
            if guess == letter:
                table[index] = guess

            index += 1
    else:
        life -= 1

    index = 0

    print(table)
    print(f"You have {life} chances remaining!")
    if (life == 0):
        game = False
        print(f"You lost! the word was {word}!")
        break
    if ("_" not in table):
        game = False
        print(f"You won! the word was {word}!")
